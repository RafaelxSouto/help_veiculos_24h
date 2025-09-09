# Sistema de Guincho 24 Horas - Help Veículos

Este é um sistema RESTful desenvolvido em Spring Boot para gerenciamento de solicitações de guincho da empresa "Help Veículos".

## Requisitos

- Java 17+
- MySQL
- Maven

## Configuração do Banco de Dados

1. Instale o MySQL/XAMPP
2. Crie o banco de dados: `guincho_db`
3. Configure o usuário e senha no arquivo `application.properties` se necessário

## Como executar

```bash
mvn spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

## Endpoints da API

### 1. Solicitar Guincho (POST)

**URL:** `POST /api/guincho/solicitar`

**Exemplo de requisição:**
```json
{
    "placaVeiculo": "ABC1234",
    "nomeCliente": "João Silva",
    "foneCelular": "(11) 99999-9999",
    "endereco": "Rua das Flores, 123, Centro",
    "cidade": "São Paulo"
}
```

**Exemplo de resposta:**
```json
{
    "id": 1,
    "placaVeiculo": "ABC1234",
    "nomeCliente": "João Silva",
    "foneCelular": "(11) 99999-9999",
    "endereco": "Rua das Flores, 123, Centro",
    "cidade": "São Paulo"
}
```

### 2. Buscar por Placa (GET)

**URL:** `GET /api/guincho/buscar/placa/{placa}`

**Exemplo:** `GET /api/guincho/buscar/placa/ABC1234`

### 3. Buscar por Nome do Cliente (GET)

**URL:** `GET /api/guincho/buscar/cliente/{nomeCliente}`

**Exemplo:** `GET /api/guincho/buscar/cliente/João`

## Validações

- **Placa:** Formato brasileiro (ABC1234 ou ABC1D23)
- **Nome:** Entre 2 e 100 caracteres
- **Telefone:** Formato (XX) 9XXXX-XXXX ou (XX) XXXX-XXXX
- **Endereço:** Entre 5 e 200 caracteres
- **Cidade:** Entre 2 e 100 caracteres

## Testando no Postman

### POST - Solicitar Guincho
1. Método: POST
2. URL: `http://localhost:8080/api/guincho/solicitar`
3. Headers: `Content-Type: application/json`
4. Body (raw JSON):
```json
{
    "placaVeiculo": "ABC1234",
    "nomeCliente": "João Silva",
    "foneCelular": "(11) 99999-9999",
    "endereco": "Rua das Flores, 123, Centro",
    "cidade": "São Paulo"
}
```

### GET - Buscar por Placa
1. Método: GET
2. URL: `http://localhost:8080/api/guincho/buscar/placa/ABC1234`

### GET - Buscar por Nome
1. Método: GET
2. URL: `http://localhost:8080/api/guincho/buscar/cliente/João`
