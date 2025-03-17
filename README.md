# prova-tokio

# Projeto ProvaTokio

Este projeto foi desenvolvido utilizando Java 11 e Spring Boot para gerenciar um CRUD de clientes e endereços. A comunicação com o banco de dados foi feita utilizando H2 e as tabelas foram inicialmente configuradas utilizando JPA. O Lombok foi utilizado para gerar automaticamente os métodos getters e setters das entidades. As requisições de API foram testadas com o Insomnia.

## Tecnologias Usadas

- **Java 11**: Linguagem de programação utilizada.
- **Spring Boot**: Framework para desenvolvimento de aplicações Java.
- **Lombok**: Biblioteca para simplificação de código, gerando automaticamente os métodos getters e setters.
- **H2 Database**: Banco de dados em memória utilizado para desenvolvimento e testes.
- **JPA (Java Persistence API)**: Para mapeamento objeto-relacional e persistência no banco de dados.
- **Insomnia**: Ferramenta para testar as requisições HTTP da API.

## Funcionalidades

Este projeto implementa um CRUD para as entidades `Clients` e `Addresses`. As funcionalidades principais são:

- **Create (POST)**: Criar um novo cliente ou endereço.
- **Read (GET)**: Listar clientes ou endereços existentes.
- **Update (PUT)**: Atualizar informações de clientes ou endereços.
- **Delete (DELETE)**: Deletar clientes ou endereços.

## Estrutura do Projeto

Abaixo está uma breve descrição das principais classes e pacotes do projeto.

### 1. **Entidades (Entities)**

- **Client**: Representa os clientes no sistema. Possui um relacionamento com a entidade `Address`.
- **Address**: Representa os endereços associados aos clientes. Contém informações como `logradouro`, `bairro`, `cidade`, `estado`, entre outros.

#### Exemplo de Entidade `Client`:
```java
@Entity
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    
    @OneToMany(mappedBy = "client")
    private List<Address> addresses;

    // Getters e Setters gerados automaticamente pelo Lombok
}
```
