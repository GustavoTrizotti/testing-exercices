# Prova 02 — Teste Funcional Baseado em Requisitos

## Contexto

A transportadora **Rota Certa** deseja calcular fretes automaticamente. O valor final de um frete é calculado
pelo método `double calculateFreight(double weightKg, double distanceKm, String serviceLevel)` da classe
`FreightCalculator`.

As regras de negócio são as seguintes:

- `weightKg` deve ser maior que **0** e menor ou igual a **50.0**.
- `distanceKm` deve ser maior ou igual a **1.0** e menor ou igual a **1000.0**.
- `serviceLevel` deve ser obrigatoriamente `"STANDARD"` ou `"EXPRESS"`.
- Para peso maior que **0** e menor ou igual a **1.0 kg**, o valor base é **R$ 15.00**.
- Para peso maior que **1.0 kg** e menor ou igual a **10.0 kg**, o valor base é **R$ 15.00 + R$ 2.00**
  para cada quilo acima de **1.0 kg**.
- Para peso maior que **10.0 kg** e menor ou igual a **50.0 kg**, o valor base é
  **R$ 33.00 + R$ 3.00** para cada quilo acima de **10.0 kg**.
- Caso `distanceKm` seja maior que **300.0**, deverá ser somada uma sobretaxa fixa de **R$ 8.00**.
- Caso `serviceLevel` seja `"EXPRESS"`, o valor final deverá receber acréscimo de **25%**.
- Sempre que o método `calculateFreight(...)` for invocado com configurações inválidas, deverá ser disparada uma
  `IllegalArgumentException`.

Também há uma classe chamada `DeliveryAnalyticsService`, responsável por produzir relatórios. Nela, o método
`double averageDeliveryTimeInHours(String city, LocalDate startDate, LocalDate endDate)` é utilizado para calcular
o tempo médio de entrega, em horas, para uma cidade em um determinado intervalo. Para esse cálculo, a classe
depende de um `DeliveryRepository`.

As regras desse método são:

- Caso algum dos parâmetros seja nulo, deverá ser disparada uma `NullPointerException`.
- Caso `city` seja vazia ou contenha apenas espaços em branco, deverá ser disparada uma `IllegalArgumentException`.
- Caso `startDate` seja posterior a `endDate`, deverá ser disparada uma `IllegalArgumentException`.
- Caso não existam entregas no período consultado, o método deverá retornar **0.0**.
- O valor retornado deverá corresponder à média aritmética simples das durações encontradas.

Na avaliação das questões a seguir, não será levado em conta apenas o conjunto de casos de teste, mas também a
organização da classe de teste, o adequado uso de _frameworks_ e bibliotecas, bem como a qualidade da automação
dos testes. Considere o uso de **JUnit 5**, **AssertJ** e, quando houver dependências externas, **Mockito**.

### Questão 1 [5 pts]:

Crie um conjunto de casos de testes unitários para o método
`calculateFreight(double weightKg, double distanceKm, String serviceLevel)` da classe `FreightCalculator`,
para cobrir **100% dos critérios da técnica funcional**. Antes de automatizar os testes, liste cada requisito
na tabela a seguir:

| ID  | Requisito de Teste   | Critério                       |
| --- | -------------------- | ------------------------------ |
| R1  | Exemplo de requisito | Particionamento / Valor Limite |

Indique o(s) id(s) dos requisitos nos testes que o(s) cobre(m), no `@DisplayName` ou como comentário.

---

### Questão 2 [5 pts]:

Crie um conjunto de casos de testes unitários para o método
`averageDeliveryTimeInHours(String city, LocalDate startDate, LocalDate endDate)` da classe
`DeliveryAnalyticsService`, para cobrir **100% dos critérios da técnica funcional**. Para isolar a classe sob
teste, emule a interação com o banco de dados. Em ao menos **dois** casos de teste, crie dublês de teste do tipo
`Mock`. Utilize métodos e anotações adequados para organizar códigos de _fixture_.

Antes de automatizar os testes, liste cada requisito testado na tabela a seguir:

| ID  | Requisito de Teste   | Critério                       |
| --- | -------------------- | ------------------------------ |
| R1  | Exemplo de requisito | Particionamento / Valor Limite |

Indique o(s) id(s) dos requisitos nos testes que o(s) cobre(m), no `@DisplayName` ou como comentário.
