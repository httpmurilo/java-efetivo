### Utilização de métodos static factory ao contrário do uso de construroes.

O modo tradicional leva em consideração a criação de um construtor público tradicional.

### Sugestão

Fornecer um método static factory público que retorna uma instância de uma classe. Este padrão não é o mesmo que o padrão `Factory method` do design pattern.

`Comentário pessoal : Uma sucinta diferença entre os dois, é que o padrão criacional Factory method fornece uma interface para criação de objetos a partir de uma superclasse, além de fornecer que as subclasses alterem o tipo de objetos. Outro ponto, é a substituição de chamadas diretas de construção de objetos, por exemplo o uso do New.`

### Vantagens

A) Ao contrário dos construtores, tem nomes mais `declarativos`.
B) Ao contrário dos construtores, não precisam criar um novo objeto sempre que invocamos.

`Comentário pessoal : Padrão Singleton, apenas uma instância da classe pode existir.`

A capacidade dos métodos `static factory` de retornar o mesmo objeto apartir de chamadas repetidas possibilita as classes assegurarem o controle rigoroso sobre a instância existente a todos momentos.

`Comentário pessoal : Caso de uso gerenciamento de cache, considerado também um polêmico/anti-pattern`

C) Ao contrário dos construtores, poedem retornar um objeto de qualquer subtipo do próprio tipo de retorno -> escolha do objeto retornado.

Retornar objetos sem tornar suas classes públicas -> API Compacta.

`Nota : O Autor usa API como uma referência a classes, interfaces, construtores, membros e aos objetos serializados dos quais um programador acessa uma classe, interface ou pacote.`

D) Técnica compatível com frameworks baseados em interfaces-> Em que interfaces são os tipos de retornos naturais para os métodos `static factory`

