Book Manager 📚

Aplicação Java desenvolvida como atividade acadêmica para gerenciamento de livros e autores.

🛠 Tecnologias Utilizadas
- Java 17
- Spring Boot 3.4.0 (Spring Web, Spring Data JPA, Thymeleaf)
- Maven 3.9+ (com Maven Wrapper incluso)
- JPA (Hibernate)
- PostgreSQL
- SpringDoc OpenAPI / Swagger UI 2.7.0
- MapStruct 1.6.3
- Lombok
- IntelliJ IDEA


💡 Funcionalidades
Cadastro de livros

Cadastro de autores

Associação entre livros e autores

Visualização de todos os registros

📁 Estrutura do Projeto
```text
book-manager/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/bookmanager/
│   │   │       └── DemoApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── templates/
│   └── test/
│       └── java/
│           └── com/example/bookmanager/
├── .mvn/wrapper/
├── mvnw
├── mvnw.cmd
└── pom.xml
```
🚀 Como Executar

### Pré-requisitos
- Java JDK 17
- PostgreSQL instalado e em execução

### Passos
1. Clone o repositório:
```bash
git clone https://github.com/odavid062/book-manager.git
cd book-manager
```

2. Configure o banco de dados PostgreSQL e edite o arquivo `src/main/resources/application.properties` com suas credenciais locais de conexão.

3. Execute a aplicação:
- **Via Maven Wrapper (Terminal):**
  - Linux/macOS:
    ```bash
    ./mvnw spring-boot:run
    ```
  - Windows:
    ```powershell
    .\mvnw.cmd spring-boot:run
    ```
- **Via IDE (IntelliJ IDEA, VS Code ou Eclipse):**
  - Importe o projeto como projeto Maven e execute a classe principal `com.example.bookmanager.DemoApplication`.

4. Para rodar os testes:
- Linux/macOS: `./mvnw test`
- Windows: `.\mvnw.cmd test`

### Documentação da API (Swagger / OpenAPI)
Com a aplicação em execução, a documentação interativa do Swagger UI fica acessível em:
- [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- Especificação OpenAPI: `http://localhost:8080/v3/api-docs`

🧠 Observação
Este projeto faz parte das atividades da disciplina de Desenvolvimento de Software.

👨‍💻 Autor
David Rodrigues
