# API Autenticação

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
[![Licence](https://img.shields.io/github/license/Ileriayo/markdown-badges?style=for-the-badge)](./LICENSE)

Este projeto é uma API criada usando **Java, Java Spring, H2 como banco de dados.**

## Instalação

1. Clonar o repositorio:

```bash
git clone https://github.com/Fernanda-Kipper/auth-api.git
```

2. Install dependencies with Maven

## Uso

1. Inicie o aplicativo com o Maven
2. A API estará acessível em http://localhost:8080

```json
[
    {
        "id": 1,
        "firstName": "Pedro",
        "lastName": "Silva",
        "document": "123456787",
        "email": "pedro@example.com",
        "password": "senha",
        "balance": 20.00,
        "userType": "MERCHANT"
    },
    {
        "id": 4,
        "firstName": "Luckas",
        "lastName": "Silva",
        "document": "123456783",
        "email": "luckas@example.com",
        "password": "senha",
        "balance": 0.00,
        "userType": "COMMON"
    }
]
```

**POST USERS**
```markdown
POST /users - Registre um novo usuário no aplicativo
```
```json
{
    "firstName": "Lucas",
    "lastName": "Silva",
    "password": "senha",
    "document": "123456783",
    "email": "lucas@example.com",
    "userType": "COMMON",
    "balance": 10
}
```

**POST TRANSACTIONS**
```markdown
POST /transactions - Registre uma nova transação entre users (COMMON to COMMON or COMMON to MERCHANT)
```

```json

{
  "senderId": 4,
  "receiverId": 1,
  "value": 10
}
```

## Database
O projeto utiliza [H2 Database](https://www.h2database.com/html/tutorial.html) como database.

## API Endpoints
The API provides the following endpoints:
Resolução do DESAFIO REAL de VAGA para desenvolvedor BACKEND. 
O link do desfio no github: https://github.com/PicPay/picpay-desafio-backend.

Esse desafio aborda problemas comuns do dia-a-dia backend.

# Testes Unitários
O projeto utiliza teste unitário. 

Dependêcias: 
* `Spring-boot-starter-test`- no spring starter estão contidos as bibliotecas os `JUnit` e `Mockito`
* `H2` - banco em memória, usado como banco de teste 

Notações Usadas nas classes Tests: 
* `@DataJpaTest` - indíca para o spring que a classe em questão é uma classe de test JPA
* `@DisplayName()` - usado em metódos para descrever o que o mesmo faz  
* `@Test` - usado para o spring saber que é um metódo de test
* `@ActiveProfiles("test")` - usado na Classe para ativar o proprities de test (perfil de test)
