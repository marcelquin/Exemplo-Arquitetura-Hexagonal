- Arquitetura Hexagonal também conhecido como **Ports and Adapters.** É um padrão proposto por Alistair Cockburn para reduzir o acoplamento entre as diferentes camadas de um sistema, aumentando assim sua testabilidade. O padrão recebe este nome por conta da forma como uma aplicação que o utilize interage com o mundo externo: a partir de ports (portas) e adapters (adaptadoes).

- **Uma Arquitetura Hexagonal divide as classes de um sistema em dois grupos principais:** 1. Classes de domínio, isto é, diretamente relacionadas com o negócio do sistema. 2. Classes relacionadas com infraestrutura, tecnologias e responsáveis pela integração com sistemas externos (tais como bancos de dados). 3.Além disso, em uma Arquitetura Hexagonal, **classes de domínio não devem depender de classes relacionadas com infraestrutura, tecnologias ou sistemas externos.** A vantagem dessa divisão é desacoplar esses dois tipos de classes.

ENTIRY

Possuindo 2 entidades uma referente as informações de trafego do banco de dados e outra referente ao trafego da aplicação, ultiliza-se de um conversor(mapper) convertendo alterando e/ou salvando e convertendo o novamente em entidade(domain ) sem vinculo com o banco de dados sendo somente retorno da informação ou do processo que ocorreu.
	
REPOSITORIOS

Assim como a entidade há 2 repositórios, um jpaRepository que movimenta as informações com o banco de dados, e o Repository(Domain) que utiliza-se de um adapter(classe) para incrementar chamando dentro de sua classe “imp” o repositor JPA executando os processos e retornando a entidade do domain, ocultando a entidade original.
	
SERVICE

  Utilizando de um port para implementar os métodos sendo de maneira a isolar, deste modo o controller que recebe a requisição não conhece o service que só executa e retorna tendo o usecase que faz a ligação dele para com qualquer classe que necessite de utilizar seus processos dentro ou fora da aplicação.
  
 USE CASES

 Classes que estão ligadas ao port do service, que quando invocado busca no port que vai ao service executa retornando somente a resposta de modo que o requisitante não sabe o processo que foi feito.

 Podendo ser feito uma classe para cada método do service, ou como para cada verbo(GET, POST, PUT ou DELETE), dependendo da complexidade e/ou exigência do projeto levando em consideração a segurança necessária.

 CONTROLLER

 Porta de entrada de requisição que se conecta não ao service, mas sim ao use case, ou seja executa isoladamente a requisição sem conhecer o caminho de entrada ou retorno da informação.
 
	
