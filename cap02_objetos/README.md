## Utilização de métodos static factory ao contrário do uso de construtores - Item 1.

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

`Material complementar: Esse comportamento está descrito nessa` [fonte] (http://hg.openjdk.java.net/jdk8u/jdk8u/jdk/file/7d1d5f4d019a/src/share/classes/java/util/EnumSet.java#l115).

E) Não precisa existir a classe do objeto retornado quando a classe contém o método de escrita.

`Trecho adaptado `: Esse tipo de comportamento está implementado na API do JDBC (Java Database Connectivity).

`Comentário pessoal: F) Complemento que uma das vantagens do uso do static factory, é a utilização de valores padrões nos construtores e mover a lógica para fora dos construtores, princípio da responsabilidade única.`

### Desvantagens

A) Classes sem construtores públicos ou protegidos não podem ser dividados em subclasses.

Impossível dividir em subclasses qualquer uma das classes pertinentes à implementação no Collections Framework. Provavelmente, isso pode ser uma dádiva disfarçada, pois, incentiva os programadores a usarem a composição em vez da herança exigida pelos tipos imutáveis.

`Comentário pessoal: Composição é quando um Objeto de uma Classe X utiliza recursos de outro Objeto de uma Classe Y. Ou seja, a Composição é uma técnica de reutilização de código sem acoplamento entre Classes. Herança é uma técnica de reutilização de código com acoplamento entre as Classes.`

`Material complementar: https://www.journaldev.com/1325/composition-in-java-example`[EN].

B) Difíceis de serem encontrados pelos programadores.

Não estão destacados na documentação da API do mesmo modo que os construtores, por esse motivo pode ser difícil descobrir como instanciar uma classe que forneça de métodos `static factory` em vez de construtores.

`Trecho adaptado `: Um bom ponto para contornar isso é respeitando as convenções comuns de nomenclatura. 

Uns exemplos são ;

`From` - Método de conversão de tipo que apresenta um único parâmetro e retorna uma instância correspondente desse tipo, por exemplo:

`Date d = Date.From(instante)`.

`Of` - Método de agregação que apresenta diversos parâmetros e retorna uma instância desse tipo que incorpora esses parâmetro:

`Set<Rank> faceCards = EnumSet.of(JACK, QUEEN, KING);`

`ValueOf` - Uma alternativa mais verbosa para o `from` e para o `of`:

`BigInteger prime = BigInteger.valueOf(Integer.MAX_VALUE);`

`Material complementar: Mais exemplos podem ser encontrados em https://jorgenringen.github.io/2018/01/factory_method_naming_conventions/ [EN].`

## Cogite o uso de um builder quando se deparar com muitos parâmetros no construtor - Item 2.

As `static factories` e os construtores compartilham uma limitação: não se adéquam bem a um grande número de parâmetros opcionais.

Analise o caso de uma classe, aqui exemplificada como `NutritionFacts`, representando um daqueles rótulos de informações nutricionais vinculados nas embalagens de comida. Eles têm alguns campos obrigatórios - a quantidade da porção, a quantidade das porções por embalagem e as calorias por porção - e mais de 20 campos opcionais.

Quais tipos de construtores ou métodos `static factory` você deveria escrever para essa classe? Tradicionalmente, os programadores têm usado o padrão `telescoping construtor`, no qual você fornece um construtor somente com os parâmetros necessários, outro com um único parâmetro opcional, e assim por diante.

`Exemplo completo disponível em https://www.javatips.net/api/effective-java-examples-master/src/main/java/org/effectivejava/examples/chapter02/item02/telescopingconstructor/NutritionFacts.java.`

`Nota: Esse tipo de padrão não é escalável`.

Concluindo, o padrão telescoping constructor funciona, mas é difícil escrever o código do cliente quando se tem muitos parâmetros, e é ainda mais difícil de o ler.

Uma segunda alternativa quando se deparar com muitos parâmetros opcionais em um construtor é o padrão `JavaBeans`. Nele, você chama um construtor sem parâmetros para criar o objeto e, em seguida chama os métodos setter para definir cada parâmetro obrigatório e cada parâmetro opcional de interesse.

`Comentário do autor: //Padrão Java Beans - Permite a inconsistência, autoriza a mutabilidade`

`Exemplo completo disponível em https://www.javatips.net/api/effective-java-examples-master/src/main/java/org/effectivejava/examples/chapter02/item02/javabeans/NutritionFacts.java.`

`Material complementar - Oque é um JavaBean exatamente[EN] - https://stackoverflow.com/questions/3295496/what-is-a-javabean-exactly`.

Esse padrão não tem nenhuma das desvantagens que o padrão `telescoping constructor` apresenta. Com ele é fácil, embora um tanto prolixo, de criar instâncias, e de ler o código resultante:

```
NutritionFacts cocaCola = new NutritionFacts();
cocaCola.setServingSize(240);
cocaCola.setServings(8);
cocaCola.setCalories(100);
cocaCola.setSodium(35);
cocaCola.setCarbohydrate(27);
```

O padrão `JavaBeans` apresenta graves desvantagens, sendo elas :

- Construção dividida em várias chamadas

Um `JavaBean` pode apresentar um estado parcialmente inconsistente durante sua construção. A classe não tem a opção de implementar a consistência apenas verificando a validade dos parâmetros do construtor. As tentativas de usar um objeto quando ele apresenta um estado inconsistente podem causar falhas que estarão bem distantes do código com o bug, e serão difíceis de depurar. Uma das desvantagens que reside nesse fato é que o padrão `JavaBeans` exclui a possibilidade de uma classe ser imutável, e exige, um esforço complementar a fim de garantir a segurança da thread.


É possivel minimizar essas desvantagens congelando o objeto quando sua construção está completa e não permitindo o uso dele até estar congelado.

`Trecho adaptado`: O padrão `builder` une a segurança do padrão `telescoping constructor` com a legibilidade do padrão `JavaBeans`. A ideia é que a criação de um objeto complexo seja segredado em diversos pedacinhos. Dado a quantidade de material desse padrão, não irei me estender sobre esse tópico.

`Material complementar - Builder em Java[PT-BR/EN] - https://refactoring.guru/pt-br/design-patterns/builder/java/example`.
`Material complementar - Padrões de Projetos: Soluções Reutilizáveis de Software Orientado a Objetos - Cap 3 Padrões de Criação - pag104 - Builder `.

O padrão `builder` se adequa bem nas hierarquivas de classe. Use uma hierarquia paralela de builders, onde as classes abstratas tem builders abstratos, as classes concretas, builder concetros.

### Vantagens

- Em relação aos construtores, builders apresentam diversos parâmetros de `varargs`, pois cada parâmetro é especificado no próprio método.

`Nota` : `vargs` consiste em um parâmetro que pode receber 0, um array ou muitos parâmetros.

- Builders podem agregar os parâmetros passados em múltiplas chamadas de um método dentro de um único campo.

- Flexível : um builder pode ser usado várias vezes para criar inúmeros objetos.

### Desvantagens

- Para a criação de um objeto, deve criar primeiro um builder.

- Desempenho, embora seja pouco provável que o custo de criação desse builder seja considerável na prática, isso pode ser um problema em situações críticas de desempenho.

`Análise pessoal:` Usando uma pequena entidade os testes usando construtores e o padrão `builder` foi metido o tempo de execução com o `Google Guava`. A tabela abaixo demostra o resultado dos testes :



| Construtor    | Tempo em ms   |
| ------------- |:-------------:|
| Padrão        | 4,648         |
| Builder       | 8,959         |

`Obs: Para o teste foi utilizado o jdk 17 para a arquitetura x86_64 para a plataforma Linux. A entidade pode ser consultada em` [Main.java](https://github.com/httpmurilo/java-efetivo/blob/main/cap02_objetos/exemplos/builder/src/com/mercado/Main.java).

- O padrão `buider` é considerado mais verboso do que o padrão `telescoping constructor`, isso significa que o padrão `builder` só deve ser usado se existe parâmetros suficientes que justifiquem o seu uso, + 4 parâmetros.

`Nota pessoal: Precisamos lembrar que conforme o sistema vai crescendo/tomando forma, as entidades tendem a crescer conforme a necessidade do sistema vai aumentando. A recomendação do livro é que frequentemente devemos considerar que seja melhor já começar com um builder, pois ao se começar com static factories ou construtores, pode-se chegar a um ponto que a quantidade de parâmetros saia do nosso controle. Nesse sentido, evitamos refatoração/dívida técnica`.

- O padrão `builder` é uma boa opção para projetar classes cujo construtores ou `static factories` tenham poucos parâmetros, especialmente se muito parâmetros forem opcionais ou do tipo idêntico.

`Conclusão: concluem-se que o padrão builder torna a leitura/manutenção do código mais simples  e possui um nível maior de segurança do que se compararmos com o telescoping constructor e JavaBeans.`

## Implemente a propriedade de um singleton com um construtor privado ou um tipo enum - Item 3.

Um singleton é uma classe instanciada exatamente uma vez. Os singletons representam tanto um objeto sem estado que executa tarefas como uma função, ou um componente do sistema intrinsecamente único.

Existe duas formas tradicionais de implementar os singletons. Ambas são baseadas em manter o construtor privado e exportar os membros estáticos púbicos para permitir acesso à instância única.

### No primeiro exemplo, o membro público é um campo final:

```java
package io.murilo.school.model;

public class Student {
    public static final Student INSTANCE = new Student();

    private Integer id;
    private String name;
    private Integer age;
}
```

É chamado o construtor privado apenas uma vez para inicializar o campo final estático Student.

A ausência de um construtor público ou de um construtor protegido garante que existirá somente uma instância de Student. Contudo, um desenvolvedor poderá invocar o construtor privado premeditamente com o auxílio do método `AcessibleObject.setAcessible`. Nesses cenários, para impedir a criação de uma segunda instância poderá ser usado uma exceção caso alguém tente criar uma segunda instância.

### No segundo exemplo, o membro público é um método static factory (rever item 1):

```java
package io.murilo.school.model;

public class Student {
    private static final Student INSTANCE = new Student();
  
    private Student() {
      ...
      public static Student getInstance(); 
    }
    private Integer id;
    private String name;
    private Integer age;
    
}
```

Todas as chamadas para Student.getInstance retornam a mesma referência de objeto, e nenhuma outra instância jamais será criada. Com a exceção do uso do `AcessibleObject.setAcessible`.

```java
package io.murilo.school.model;

public class Student {
    private static final Student INSTANCE = new Student();
  
    private Student() {
      ...
      public static Student getInstance(); 
    
    }
    private Integer id;
    private String name;
    private Integer age;
    
}
```

A principal vantagem da abordagem de campo público é que a API deixa bem claro que a classe é um singleton: o campo estático público é final, portanto, sempre terá a mesma referência de objeto. A segunda vantagem é que é mais simples.

Sobre a abordagem do uso de `statics factorys`, possui três vantagens principais, sendo elas:

- Flexibilidade para mudar a implementação singleton, sem alterar a sua API. O método pode ser facilmente modificado para retornar uma instância separada para cada thread que a invoca.

- Pode-se criar fábricas genéricas de singleton, conforme o exemplo abaixo:

```java
public class GenericSingletonFactory {
	// Generic singleton factory pattern
	private static UnaryFunction<Object> IDENTITY_FUNCTION = new UnaryFunction<Object>() {
		public Object apply(Object arg) {
			return arg;
		}
	};

	// IDENTITY_FUNCTION is stateless and its type parameter is
	// unbounded so it's safe to share one instance across all types.
	@SuppressWarnings("unchecked")
	public static <T> UnaryFunction<T> identityFunction() {
		return (UnaryFunction<T>) IDENTITY_FUNCTION;
	}

	// Sample program to exercise generic singleton
	public static void main(String[] args) {
		String[] strings = { "jute", "hemp", "nylon" };
		UnaryFunction<String> sameString = identityFunction();
		for (String s : strings)
			System.out.println(sameString.apply(s));

		Number[] numbers = { 1, 2.0, 3L };
		UnaryFunction<Number> sameNumber = identityFunction();
		for (Number n : numbers)
			System.out.println(sameNumber.apply(n));
	}
}
```

`Obs:` exemplo extraído do próprio livro. Créditos do autor.

- Referência de método, a uma vantagem de usar a `static factory` é que uma referência de método pode ser usada como `supplier`, por exemplo `Student::instance` é um `Supplier<Student>`.

`Nota:` A interface `Supplier` nada mais é do que uma interface funcional, basicamente ela não aceita argumentos e retorna um resultado. Fonte [Receitas de código](https://receitasdecodigo.com.br/java/exemplos-supplier-java-8).

O autor complementa, que ao menos, que uma dessas vantagens seja relevantes, a abordagem do campo público é mais aconselhável.

Obs: Para tornar uma classe singleton serializável onde é usada uma dessas qualquer abordagem, não é suficiente somente informar o `implements Serializable` à sua declaração.

### Singleton como Enum

Uma terceira abordagem de implementar um singleton é declarar um enum como um elemento único.

```java
public enum Student {
	INSTANCE;
	...
	public void addAverage(){}
}
```

Benefícios:

- Semelhante à do campo público, porém é mais concisa.
- Maneira descomplicada de serialização.
- Oferece garantia contra as instâncias múltiplas, mesmo em casos de ataques sofisticados de serialização ou ataques por reflexão.
- Um tipo enum de elemento único é muitas vezes a melhor forma de implementar um singleton.

Não pode empregá-la caso seu singleton deva estender outra superclasse que não seja a Enum.

### Item 4: Implemente a não instanciação através de construtores privados

Essa necessidade surge, quando queremos criar classes que sejam apenas um agrupamento de métodos e campos estáticos. Elas podem ser usadas para agrupar métodos relacionados aos valores primitivos ou arrays, como as de `java.lang.Math` ou `java.util.Arrays`. Também podem ser utilizadas para agrupar métodos estáticos, incluindo fábricas.

Pode-se fazer com que uma classe seja não instanciável através da inclusã de construtores privados. Na ausência de construtores explícitos, no momento da compilação, o compilador fornece un construtor padrão público, sem parâmetros.

```java
//Classe utilitária não instancíavel
public class UtilityClass {
	//suprima o construtor padrão para a não instanciação
	private UtilityClasse() {
		throw new AssertionError();
	}
	//omitido
}
```
Exemplo extraído do próprio livro.
