# API Tabela FIPE com Spring Boot

Este projeto é uma API REST desenvolvida em **Java com Spring Boot**, que permite consultar informações sobre **marcas, modelos e valores de carros** da **Tabela FIPE**. Além disso, a API implementa operações CRUD para gerenciar registros de veículos.

## 🛠️ Tecnologias Utilizadas
- **Java 21**
- **Spring Boot 3**
- **Spring Web**
- **Spring Data JPA**
- **H2 Database (para testes locais)**
- **API Tabela FIPE (Parallelum API)**

## 📌 Funcionalidades

### 1️⃣ API Local (CRUD de Carros)
- `GET /api/carros` → Lista todos os carros cadastrados no banco local
- `GET /api/carros/{id}` → Retorna os detalhes de um carro específico
- `POST /api/carros` → Adiciona um novo carro ao banco
- `PUT /api/carros/{id}` → Atualiza um carro cadastrado
- `DELETE /api/carros/{id}` → Remove um carro do banco

### 2️⃣ API Externa (Consulta FIPE)
- `GET /api/fipe/marcas` → Retorna todas as marcas disponíveis na Tabela FIPE
- `GET /api/fipe/modelos/{marcaId}` → Retorna os modelos de uma marca específica
- `GET /api/fipe/valor/{marcaId}/{modeloId}/{ano}` → Retorna o valor do carro específico na Tabela FIPE

## 🚀 Como Rodar o Projeto
### Pré-requisitos
- Java 17+
- Maven 3.8+
- Git

### Passos
1. **Clone o repositório:**
   ```sh
   git clone https://github.com/mauricio-theodoro/TabelaFipe.git
   ```
2. **Acesse a pasta do projeto:**
   ```sh
   cd TabelaFipe
   ```
3. **Compile e execute a aplicação:**
   ```sh
   mvn spring-boot:run
   ```
4. **Acesse a API no navegador ou Postman:**
   - http://localhost:8080/api/carros
   - http://localhost:8080/api/fipe/marcas

## 📁 Estrutura do Projeto
```
Tabelafipe/
│── src/
│   ├── main/
│   │   ├── java/com/tabela/fipe/
│   │   │   ├── controller/   # Controladores REST
│   │   │   ├── model/        # Modelos de Dados
│   │   │   ├── repository/   # Interfaces JPA
│   │   │   ├── service/      # Regras de Negócio
│   │   │   ├── FipeApplication.java
│   ├── resources/
│   │   ├── application.properties
│── pom.xml   # Dependências Maven
│── README.md
```

## 📜 Licença
Este projeto é de código aberto e está disponível sob a licença MIT.

---
**Desenvolvido por [Maurício Theodoro](https://github.com/mauricio-theodoro) 🚀**

