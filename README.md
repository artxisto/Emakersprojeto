# Biblioteca API

API REST desenvolvida com Spring Boot para gerenciamento de biblioteca.

## Tecnologias

- Java
- Spring Boot
- Spring Security
- JWT
- Spring Data JPA
- MySQL
- Flyway
- Swagger
- Docker

## Funcionalidades

- Cadastro e autenticação de usuários
- Gerenciamento de livros
- Controle de empréstimos
- Devolução de livros
- Integração com ViaCEP
- Documentação Swagger
- Containerização com Docker

## Execução
Subir a aplicacao local
./mvnw spring-boot:run

Acessar a documentação Swagger
http://localhost:8080/swagger-ui/index.html

Executando com Docker

Gerar o arquivo JAR

./mvnw clean package -DskipTests

Construir a imagem Docker

docker build -t biblioteca-api .

Executar o container

docker run -p 8080:8080 biblioteca-api
