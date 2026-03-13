# 📚 API Biblioteca

API REST desenvolvida em **Spring Boot** para gerenciamento de uma biblioteca, permitindo o controle de **Usuários**, **Carteiras de Biblioteca** e **Empréstimos**.

Este projeto foi desenvolvido com o objetivo de praticar **modelagem de entidades, relacionamentos JPA e criação de APIs REST**.

---

# 🧰 Tecnologias utilizadas

* Java 25
* Spring Boot
* Spring Data JPA
* Hibernate
* Lombok
* Validation
* MySQL
* Maven
* Postman

---

# 🗂️ Estrutura do projeto

```
com.bible.biblioteca
│
├── controladores
│   ├── UsuarioControlador.java
│   ├── EmprestimoControlador.java
│   └── CarteiraControlador.java
│
├── servicos
│   ├── UsuarioServico.java
│   ├── EmprestimoServico.java
│   └── CarteiraServico.java
│
├── repositorios
│   ├── UsuarioRepositorio.java
│   ├── EmprestimoRepositorio.java
│   └── CarteiraRepositorio.java
│
├── modelos
│   ├── Usuario.java
│   ├── Emprestimo.java
│   └── CarteiraBiblioteca.java
│
└── dtos
    └── UsuarioDTO.java
```

---

# 🗄️ Banco de Dados

Nome do banco:

```
biblioteca_db
```

Tabelas geradas automaticamente pelo Hibernate:

```
usuarios
emprestimos
carteiras
```

---

# 🔗 Relacionamentos

O sistema possui os seguintes relacionamentos:

### Usuário → CarteiraBiblioteca

```
1 : 1
```

Cada usuário possui apenas **uma carteira de biblioteca**.

---

### Usuário → Empréstimo

```
1 : N
```

Um usuário pode possuir **vários empréstimos**.

---

# 🚀 Como executar o projeto

1️⃣ Clonar o repositório

```
git clone https://github.com/seu-usuario/biblioteca-api
```

2️⃣ Entrar na pasta

```
cd biblioteca-api
```

3️⃣ Configurar o banco de dados no arquivo:

```
src/main/resources/application.properties
```

Exemplo:

```
spring.datasource.url=jdbc:mysql://localhost:3306/biblioteca_db
spring.datasource.username=root
spring.datasource.password=senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

4️⃣ Executar o projeto

```
mvn spring-boot:run
```

Servidor iniciará em:

```
http://localhost:8080
```

---

# 📮 Testes da API (Postman)

Base URL:

```
http://localhost:8080
```

---

# 👤 Usuários

## Criar usuário

POST

```
http://localhost:8080/usuarios
```

Body:

```json
{
  "nome": "Gabriel Vereda",
  "email": "gabriel@email.com"
}
```

---

## Listar usuários

GET

```
http://localhost:8080/usuarios
```

---

## Buscar usuário por ID

GET

```
http://localhost:8080/usuarios/{id}
```

Exemplo:

```
http://localhost:8080/usuarios/1
```

---

## Atualizar usuário

PUT

```
http://localhost:8080/usuarios/{id}
```

Body:

```json
{
  "nome": "Gabriel Atualizado",
  "email": "gabrielnovo@email.com"
}
```

---

## Deletar usuário

DELETE

```
http://localhost:8080/usuarios/{id}
```

---

# 💳 Carteira Biblioteca

A carteira possui relacionamento **1:1 com usuário**.

## Criar carteira

POST

```
http://localhost:8080/carteiras
```

Body:

```json
{
  "numeroCarteira": 1001,
  "dataEmissao": "2026-03-06",
  "valida": true,
  "usuario": {
    "id": 1
  }
}
```

---

# 📚 Empréstimos

Relacionamento **1:N com usuário**.

---

## Criar empréstimo

POST

```
http://localhost:8080/emprestimos
```

Body:

```json
{
  "dataEmprestimo": "2026-03-06",
  "dataDevolucao": "2026-03-20",
  "usuario": {
    "id": 1
  }
}
```

---

## Listar empréstimos

GET

```
http://localhost:8080/emprestimos
```

---

## Buscar empréstimo por ID

GET

```
http://localhost:8080/emprestimos/{id}
```

---

## Atualizar empréstimo

PUT

```
http://localhost:8080/emprestimos/{id}
```

Body:

```json
{
  "dataEmprestimo": "2026-03-07",
  "dataDevolucao": "2026-03-25"
}
```

---

## Deletar empréstimo

DELETE

```
http://localhost:8080/emprestimos/{id}
```

---

# 📖 Listar empréstimos de um usuário

GET

```
http://localhost:8080/usuarios/{id}/emprestimos
```

Exemplo:

```
http://localhost:8080/usuarios/1/emprestimos
```

Resposta:

```json
[
  {
    "id": 1,
    "dataEmprestimo": "2026-03-06",
    "dataDevolucao": "2026-03-20"
  }
]
```

---

# 🧪 Ordem recomendada para testes

Para evitar erro de chave estrangeira, siga esta ordem:

1️⃣ Criar usuário

```
POST http://localhost:8080/usuarios
```

2️⃣ Criar carteira

```
POST http://localhost:8080/carteiras
```

3️⃣ Criar empréstimo

```
POST http://localhost:8080/emprestimos
```

4️⃣ Listar empréstimos do usuário

```
GET http://localhost:8080/usuarios/{id}/emprestimos
```

---

# 🎯 Objetivo da atividade

Este projeto tem como objetivo demonstrar:

* Criação de APIs REST com Spring Boot
* Modelagem de entidades com JPA
* Implementação de relacionamentos (1:1 e 1:N)
* Organização de projeto em camadas (Controller, Service, Repository)
* Integração com banco de dados MySQL

---

# 👨‍💻 Autor

Projeto desenvolvido por **Gabriel Vereda** para fins educacionais.
