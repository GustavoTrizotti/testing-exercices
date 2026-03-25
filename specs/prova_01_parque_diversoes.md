# Prova 01 — Teste Funcional Baseado em Requisitos

## Contexto

A empresa **Sky Fun Park** administra um parque de diversões e deseja automatizar parte da cobrança de ingressos.
O valor de um ingresso depende da idade do visitante e da quantidade de atrações premium escolhidas no momento
da compra. O cálculo é realizado pelo método `int calculateTicketPrice(int age, int premiumAttractions)` da
classe `TicketPriceCalculator`.

As regras de negócio são as seguintes:

- A idade informada deve estar entre **0** e **120** anos, inclusive.
- A quantidade de atrações premium deve estar entre **1** e **10**, inclusive.
- Visitantes de **0 a 5 anos** pagam **R$ 0** de ingresso base.
- Visitantes de **6 a 12 anos** pagam **R$ 20** de ingresso base.
- Visitantes de **13 a 59 anos** pagam **R$ 35** de ingresso base.
- Visitantes de **60 a 120 anos** pagam **R$ 18** de ingresso base.
- Se `premiumAttractions` estiver entre **1 e 3**, não há acréscimo.
- Se `premiumAttractions` estiver entre **4 e 7**, há acréscimo de **R$ 10**.
- Se `premiumAttractions` estiver entre **8 e 10**, há acréscimo de **R$ 18**.
- Sempre que o método `calculateTicketPrice(...)` for invocado com valores inválidos, deverá ser disparada uma
  `IllegalArgumentException`.

Também há uma classe chamada `ParkReportService`, responsável por produzir relatórios. Nela, o método
`double averageSpentByVisitor(UUID visitorId)` é utilizado para calcular o valor médio gasto em compras
de ingressos por um determinado visitante. Para esse cálculo, a classe depende de um `TicketPurchaseRepository`.

As regras desse método são:
********
- Caso o valor de entrada do método seja nulo, deverá ser disparada uma `NullPointerException`.
- Caso o visitante não possua compras registradas, o método deverá retornar **0.0**.
- O valor retornado deverá corresponder à média aritmética simples dos valores pagos nas compras encontradas.

Na avaliação das questões a seguir, não será levado em conta apenas o conjunto de casos de teste, mas também a
organização da classe de teste, o adequado uso de _frameworks_ e bibliotecas, bem como a qualidade da automação
dos testes. Considere o uso de **JUnit 5**, **AssertJ** e, quando houver dependências externas, **Mockito**.

### Questão 1 [5 pts]:

Crie um conjunto de casos de testes unitários para o método `calculateTicketPrice(int age, int premiumAttractions)`
da classe `TicketPriceCalculator`, para cobrir **100% dos critérios da técnica funcional**. Antes de automatizar os
testes, liste cada requisito na tabela a seguir:

| ID  | Requisito de Teste   | Critério                       |
| --- | -------------------- | ------------------------------ |
| R1  | Exemplo de requisito | Particionamento / Valor Limite |

Indique o(s) id(s) dos requisitos nos -testes que o(s) cobre(m), no `@DisplayName` ou como comentário.

---

### Questão 2 [5 pts]:

Crie um conjunto de casos de testes unitários para o método `averageSpentByVisitor(UUID visitorId)` da classe
`ParkReportService`, para cobrir **100% dos critérios da técnica funcional**. Para isolar a classe sob teste,
emule a interação com o banco de dados. Em ao menos **dois** casos de teste, crie dublês de teste do tipo `Mock`.
Utilize métodos e anotações adequados para organizar códigos de _fixture_.

Antes de automatizar os testes, liste cada requisito testado na tabela a seguir:

| ID  | Requisito de Teste   | Critério                       |
| --- | -------------------- | ------------------------------ |
| R1  | Exemplo de requisito | Particionamento / Valor Limite |

Indique o(s) id(s) dos requisitos nos testes que o(s) cobre(m), no `@DisplayName` ou como comentário.
