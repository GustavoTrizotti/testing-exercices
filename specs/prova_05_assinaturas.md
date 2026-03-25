# Prova 05 — Teste Funcional Baseado em Requisitos

## Contexto

A plataforma **StreamFlex** deseja automatizar o cálculo de pagamentos em atraso de assinaturas mensais.
O valor final a ser pago é calculado pelo método
`BigDecimal calculateLatePaymentAmount(BigDecimal originalAmount, LocalDate dueDate, Instant paymentTimestamp)`
da classe `LatePaymentCalculator`.

As regras de negócio são as seguintes:

- `originalAmount`, `dueDate` e `paymentTimestamp` são obrigatórios.
- `originalAmount` deve ser maior que **0**.
- Pagamentos realizados até **23:59:59** da `dueDate` não possuem multa nem juros.
- Pagamentos realizados após a `dueDate` recebem:
  - multa fixa de **2%** sobre `originalAmount`;
  - juros simples de **0,1% por dia completo de atraso**.
- Os juros por atraso são limitados a no máximo **30 dias**.
- O valor final deve ser retornado com **2 casas decimais**, usando arredondamento comercial (_half-up_).
- Sempre que o método `calculateLatePaymentAmount(...)` for invocado com valores nulos, deverá ser disparada uma
  `NullPointerException`.
- Sempre que o método `calculateLatePaymentAmount(...)` for invocado com `originalAmount` menor ou igual a zero,
  deverá ser disparada uma `IllegalArgumentException`.

Também há uma classe chamada `BillingReportService`, responsável por produzir relatórios. Nela, o método
`BigDecimal averagePaidInvoiceAmount(UUID accountId, Instant from, Instant to)` é utilizado para calcular o valor
médio das faturas pagas por uma conta em um intervalo de tempo. Para esse cálculo, a classe depende de um
`InvoiceRepository`.

As regras desse método são:

- Caso algum dos parâmetros seja nulo, deverá ser disparada uma `NullPointerException`.
- Caso `from` seja posterior a `to`, deverá ser disparada uma `IllegalArgumentException`.
- Caso não existam faturas pagas no intervalo informado, o método deverá retornar `BigDecimal.ZERO`.
- O valor retornado deverá corresponder à média aritmética simples dos pagamentos encontrados, com **2 casas
  decimais**.
- A classe sob teste deverá ser isolada das dependências externas durante os testes.

Na avaliação das questões a seguir, não será levado em conta apenas o conjunto de casos de teste, mas também a
organização da classe de teste, o adequado uso de _frameworks_ e bibliotecas, bem como a qualidade da automação
dos testes. Considere o uso de **JUnit 5**, **AssertJ** e, quando houver dependências externas, **Mockito**.

### Questão 1 [5 pts]:

Crie um conjunto de casos de testes unitários para o método
`calculateLatePaymentAmount(BigDecimal originalAmount, LocalDate dueDate, Instant paymentTimestamp)` da classe
`LatePaymentCalculator`, para cobrir **100% dos critérios da técnica funcional**. Antes de automatizar os testes,
liste cada requisito na tabela a seguir:

| ID  | Requisito de Teste   | Critério                       |
| --- | -------------------- | ------------------------------ |
| R1  | Exemplo de requisito | Particionamento / Valor Limite |

Indique o(s) id(s) dos requisitos nos testes que o(s) cobre(m), no `@DisplayName` ou como comentário.

---

### Questão 2 [5 pts]:

Crie um conjunto de casos de testes unitários para o método
`averagePaidInvoiceAmount(UUID accountId, Instant from, Instant to)` da classe `BillingReportService`, para
cobrir **100% dos critérios da técnica funcional**. Para isolar a classe sob teste, emule a interação com o banco
de dados. Em ao menos **dois** casos de teste, crie dublês de teste do tipo `Mock`. Utilize métodos e anotações
adequados para organizar códigos de _fixture_.

Antes de automatizar os testes, liste cada requisito testado na tabela a seguir:

| ID  | Requisito de Teste   | Critério                       |
| --- | -------------------- | ------------------------------ |
| R1  | Exemplo de requisito | Particionamento / Valor Limite |

Indique o(s) id(s) dos requisitos nos testes que o(s) cobre(m), no `@DisplayName` ou como comentário.
