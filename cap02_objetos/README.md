### Utilização de métodos static factory ao contrário do uso de construtores.

O modo tradicional leva em consideração a criação de um construtor público tradicional.

### Sugestão

Fornecer um método static factory público que retorna uma instância de uma classe. Este padrão não é o mesmo que o padrão `Factory method` do design pattern.

`Comentário pessoal: Uma sucinta diferença entre os dois, é que o padrão criacional Factory method fornece uma interface para criação de objetos a partir de uma superclasse, além de fornecer que as subclasses alterem o tipo de objetos. Outro ponto, é a substituição de chamadas diretas de construção de objetos, por exemplo o uso do New.`

### Vantagens

A) Ao contrário dos construtores, tem nomes mais `declarativos`.
B) Ao contrário dos construtores, não precisam criar um novo objeto sempre que invocamos.

`Comentário pessoal: Padrão Singleton, apenas uma instância da classe pode existir.`

A capacidade dos métodos `static factory` de retornar o mesmo objeto apartir de chamadas repetidas possibilita as classes assegurarem o controle rigoroso sobre a instância existente a todos momentos.

`Comentário pessoal: Caso de uso gerenciamento de cache, considerado também um polêmico/anti-pattern`

C) Ao contrário dos construtores, poedem retornar um objeto de qualquer subtipo do próprio tipo de retorno -> escolha do objeto retornado.

Retornar objetos sem tornar suas classes públicas -> API Compacta.

`Nota: O Autor usa API como uma referência a classes, interfaces, construtores, membros e aos objetos serializados dos quais um programador acessa uma classe, interface ou pacote.`

Técnica compatível com frameworks baseados em interfaces-> Em que interfaces são os tipos de retornos naturais para os métodos `static factory`.

O uso do `static factory` exige que o cliente referencie o objeto retornado pela interface em ves de referenciar a classe de implementação, o que geralmente é uma boa prática.

`Nota: Na tradução é usado também "método static factory" ou simplesmente static factory.`

`Complemento: O Java 8 exige que todos os membros estáticos de uma interface sejam públicos. O Java 9 permite a utilização de método estáticos privados, porém, exige que as classes membros estáticas e os campos estáticos ainda sejam públicos.`

D) A classe do objeto retornado pode variar de chamada para chamada, em função dos parâmetros de entrada.

Permite-se qualquer subtipo do tipo de retorno declarado, a classe do objeto retornado também pode variar de versão para versão.

`A classe EnumSet não apresenta construtores públicos, somente static factories. No OpenJDK, retorna uma instância de duas subclasses, dependendo do tamanho do tipo enum subjacente. Os clientes não sabem e nem se preocupam com a classe do objeto que retornam da fábrica; eles só se preocupam que seja alguma subclasse do enum.`

`Material complementar: Esse comportamento está descrito nesse fonte,http://hg.openjdk.java.net/jdk8u/jdk8u/jdk/file/7d1d5f4d019a/src/share/classes/java/util/EnumSet.java#l115`.

E) Não precisa existir a classe do objeto retornado quando a classe contém o método de escrita.

`Adaptado`: Esse tipo de comportamento está implementado na API do JDBC (Java Database Connectivity).

`Comentário pessoal: F) Complemento que uma das vantagens do uso do static factory, é a utilização de valores padrões nos construtores e mover a lógica para fora dos construtores, princípio da responsabilidade única.`

### Desvantagens

A) Classes sem construtores públicos ou protegidos não podem ser dividados em subclasses.

Impossível dividir em subclasses qualquer uma das classes pertinentes à implementação no Collections Framework. Provavelmente, isso pode ser uma dádiva disfarçada, pois, incentiva os programadores a usarem a composição em vez da herança exigida pelos tipos imutáveis.

`Comentário pessoal: Composição é quando um Objeto de uma Classe X utiliza recursos de outro Objeto de uma Classe Y. Ou seja, a Composição é uma técnica de reutilização de código sem acoplamento entre Classes. Herança é uma técnica de reutilização de código com acoplamento entre as Classes.`

`Material complementar: https://www.journaldev.com/1325/composition-in-java-example`.

B) Difíceis de serem encontrados pelos programadores.

Não estão destacados na documentação da API do mesmo modo que os construtores, por esse motivo pode ser difícil descobrir como instanciar uma classe que forneça de métodos `static factory` em vez de construtores.

`Adaptado`: Um bom ponto para contornar isso é respeitando as convenções comuns de nomenclatura. 

