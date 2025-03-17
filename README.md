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

#### Exemplo de Entidade `Address`:
```java
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String number;
    private String complement;
    private String postalCode;
    private String city;
    private String state;
    private String country;

    @ManyToOne
    private Clients client;

    // Getters e Setters gerados automaticamente pelo Lombok
}
```

#### 2. Repositório (Repository)
Utilizamos o Spring Data JPA para criar a interface `ClientsRepository`, que oferece métodos para interação com o banco de dados.

```java
public interface ClientsRepository extends JpaRepository<Clients, Long> {
}
```

#### 3. Serviço (Service)
A camada de serviço contém a lógica de negócios. Aqui, são feitas as operações de criação, leitura, atualização e exclusão.
```java
@Service
public class ClientsService {

    @Autowired
    private ClientsRepository clientsRepository;

    public Clients createClients(Clients client) {
        return clientsRepository.save(client);
    }

    public Clients updateClients(Long id, Clients client) {
        if (clientsRepository.existsById(id)) {
            client.setId(id);
            return clientsRepository.save(client);
        } else {
            throw new EntityNotFoundException("Client not found");
        }
    }

    public void deleteClients(Long id) {
        if (clientsRepository.existsById(id)) {
            clientsRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Client not found");
        }
    }
}
```
#### 4. Controlador (Controller)
A camada de controlador expõe os endpoints da API para interagir com as funcionalidades do CRUD.
```java
@RestController
@RequestMapping("/v1/clients")
public class ClientsController {

    @Autowired
    private ClientsService clientsService;

    @GetMapping("/{id}")
    public ResponseEntity<Clients> getClientById(@PathVariable Long id) {
        Clients client = clientsService.getClientById(id);
        return ResponseEntity.ok(client);
    }

    @PostMapping
    public ResponseEntity<Clients> createClient(@RequestBody Clients client) {
        Clients createdClient = clientsService.createClients(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clients> updateClient(@PathVariable Long id, @RequestBody Clients client) {
        Clients updatedClient = clientsService.updateClients(id, client);
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientsService.deleteClients(id);
        return ResponseEntity.noContent().build();
    }
}
```
#### 5. Classe Principal (ProvaTokioApplication)
A classe `ProvaTokioApplication` é a classe principal do projeto que inicia a aplicação Spring Boot.
```java
@SpringBootApplication
public class ProvaTokioApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProvaTokioApplication.class, args);
    }
}
```

# Como Rodar o Projeto
### Requisitos
Java 11
Maven (para compilar e rodar o projeto)
### Passos
Clone o repositório do projeto:

```bash
git clone <url_do_repositorio>
```
Navegue até o diretório do projeto:

```bash
cd prova-tokio
```
Compile e rode o projeto:

```bash
mvn spring-boot:run
```
O projeto estará rodando no localhost na porta `8080`.

## Testando as APIs com Insomnia
Use o Insomnia para testar as requisições REST do seu CRUD. Abaixo estão os endpoints principais que você pode testar:

GET `/v1/clients/{id}` - Obtém um cliente pelo ID.
POST `/v1/clients` - Cria um novo cliente.
PUT `/v1/clients/{id}` - Atualiza um cliente existente.
DELETE `/v1/clients/{id}` - Deleta um cliente.
Exemplo de requisição para criar um cliente (`POST`):

```json
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com"
}
```
## Banco de Dados H2
O H2 é um banco de dados em memória, configurado para rodar durante os testes e desenvolvimento. Ele é útil para validação rápida, mas para produção é recomendado usar um banco de dados mais robusto.

### Configuração do H2
A configuração do banco H2 é feita automaticamente pelo Spring Boot, e a URL do banco pode ser visualizada através do console H2 no seguinte endereço:

```bash
http://localhost:8080/h2-console
A URL padrão do banco H2 é configurada da seguinte forma no `application.properties`:
```

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

### Contribuindo
Faça o fork do repositório.
Crie uma branch para suas modificações (`git checkout -b minha-branch`).
Faça as modificações necessárias e commite suas alterações.
Envie um pull request para a branch `main` do repositório original.
```javascript

Esse formato agora segue o estilo de código para as instruções e exemplos, como você solicitou. Assim, é possível copiar e colar diretamente no seu `README.md` para que o conteúdo tenha uma boa formatação e legibilidade.
```

Esse formato agora segue o estilo de código para as instruções e exemplos, como você solicitou. Assim, é possível copiar e colar diretamente no seu `README.md` para que o conteúdo tenha uma boa formatação e legibilidade.


**
