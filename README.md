# Projeto Back-End PicPay
picpaysimples

Resolução do DESAFIO REAL de VAGA para desenvolvedor BACKEND. 
O link do desfio no github: https://github.com/PicPay/picpay-desafio-backend.

Esse desafio aborda problemas comuns do dia-a-dia backend.

# Testes Unitários
Dependêcias: 
 - `Spring-boot-starter-test`- no spring starter estão contidos as bibliotecas os `JUnit` e `Mockito`
 - `H2` - banco em memória, usado como banco de teste 


Notações Usadas nas classes Tests: 
- `@DataJpaTest` - indíca para o spring que a classe em questão é uma classe de test JPA
- `@DisplayName()` - usado em metódos para descrever o que o mesmo faz  
- `@Test` - usado para o spring saber que é um metódo de test
- `@ActiveProfiles("test")` - usado na Classe para ativar o proprities de test (perfil de test)