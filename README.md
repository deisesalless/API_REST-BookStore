
# Sistema de uma Livraria
Este é um projeto que implementa operações CRUD (Cadastrar, Listar, Editar, Deletar) para autores e livros, onde cada autor pode ter uma lista de vários livros. O projeto segue a arquitetura MVC (Model-View-Controller), com regras de negócio e validações concentradas na camada de serviço (Service). Todas as respostas são padronizadas de acordo com o protocolo HTTP.

## Visão Geral
O projeto consiste na construção de uma API REST para uma livraria para obter o controle de registros de livros e autores, podendo obter a listagem de livros separada dos autores, ou listar todos os autores e obter junto a listagem de seus respectivos livros.

## Tecnologias Utilizadas
- JDK 17
- Maven
- Lombok
- Flyway (Controle de versão para bancos de dados)
- H2 Database (Banco de dados em memória)
- JPA
- Spring Boot
- Spring Web

## Anotações Utilizadas
- @AllArgsConstructor, @NoArgsConstructor, @Getter, @Setter, @Data:
  - **Anotações do Lombok para geração automática de construtores, getters, setters e outros métodos úteis.**
- @Entity, @Table, @Id, @GeneratedValue:
  - **Anotações do JPA para mapeamento de entidades e chaves primárias.**
- @OneToMany, @ManyToOne, @JoinColumn:
  - **Anotações do JPA para mapeamento de relacionamentos entre entidades.**
- @JsonIgnore:
  - **Anotação do Jackson (biblioteca para serialização/desserialização JSON em Java) para ignorar propriedades durante a serialização.**
- @EqualsAndHashCode:
  - **Anotação do Lombok para geração automática dos métodos equals() e hashCode().**
- @RestController, @RequestMapping, @PostMapping, @GetMapping, @PutMapping, @DeleteMapping:
  - **Anotações do Spring para mapeamento de endpoints REST.**
- @Autowired:
  - **Anotação do Spring para injeção de dependências.**
- @Repository:
  - **Anotação do Spring para indicar que uma classe é um repositório, permitindo exceções de acesso a dados.**
- @RestControllerAdvice, @ExceptionHandler:
  - **Anotações do Spring para tratamento de exceções em controladores REST.**

## Funcionalidades
- Cadastrar livro e autor
- Listar livro e autor
- Editar livro e autor
- Deletar livro e autor

## Como executar o projeto
1. Certifique-se de ter o JDK 17 instalado em sua máquina.
2. Clone este repositório para sua máquina local.
3. Navegue até o diretório raiz do projeto.
4. Execute o comando mvn spring-boot:run para iniciar a aplicação.
5. Acesse os endpoints (book e author) definidos na classe de controladores para interagir com o projeto.

## Diagrama de Classes (UML)
<p align="center"> <img width="800px" src="https://github.com/deisesalless/API_REST-BookStore/blob/main/UML/diagrama.jpeg" /> </p>
