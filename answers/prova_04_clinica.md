# Prova 04 — Teste Funcional Baseado em Requisitos

## Contexto

A clínica **Vida Ativa** deseja automatizar a cobrança de consultas. O valor de uma consulta é calculado pelo
método
`double calculateAppointmentPrice(LocalDate appointmentDate, LocalTime appointmentTime, String specialty, boolean firstVisit)`
da classe `AppointmentPriceCalculator`.

As regras de negócio são as seguintes:

- `appointmentDate`, `appointmentTime` e `specialty` são obrigatórios.
- A clínica realiza atendimentos apenas de **segunda-feira a sexta-feira**.
- Horários válidos para início da consulta vão das **08:00** às **19:00**, inclusive.
- `specialty` deve ser obrigatoriamente `"GENERAL"`, `"DERMATOLOGY"` ou `"ORTHOPEDICS"`.
- Valores base por especialidade:
  - `"GENERAL"`: **R$ 120.00**
  - `"DERMATOLOGY"`: **R$ 180.00**
  - `"ORTHOPEDICS"`: **R$ 200.00**
- Consultas iniciadas antes das **09:00** ou a partir das **18:00** recebem acréscimo de **15%**.
- Caso `firstVisit` seja `true`, deverá ser somada uma taxa fixa de cadastro de **R$ 20.00**.
- Sempre que o método `calculateAppointmentPrice(...)` for invocado com valores nulos, deverá ser disparada uma
  `NullPointerException`.
- Sempre que o método `calculateAppointmentPrice(...)` for invocado com data, hora ou especialidade inválidas,
  deverá ser disparada uma `IllegalArgumentException`.

Também há uma classe chamada `ClinicReportService`, responsável por produzir relatórios. Nela, o método
`double averageDelayMinutes(UUID doctorId, LocalDate date)` é utilizado para calcular o atraso médio, em minutos,
dos atendimentos de um médico em um determinado dia. Para esse cálculo, a classe depende de um
`AppointmentRepository`.

As regras desse método são:

- Caso algum dos parâmetros seja nulo, deverá ser disparada uma `NullPointerException`.
- Caso não existam atendimentos para o médico na data informada, o método deverá retornar **0.0**.
- O valor retornado deverá corresponder à média aritmética simples dos atrasos registrados.
- A classe sob teste deverá ser isolada das dependências externas durante os testes.

Na avaliação das questões a seguir, não será levado em conta apenas o conjunto de casos de teste, mas também a
organização da classe de teste, o adequado uso de _frameworks_ e bibliotecas, bem como a qualidade da automação
dos testes. Considere o uso de **JUnit 5**, **AssertJ** e, quando houver dependências externas, **Mockito**.

### Questão 1 [5 pts]:

Crie um conjunto de casos de testes unitários para o método
`calculateAppointmentPrice(LocalDate appointmentDate, LocalTime appointmentTime, String specialty, boolean firstVisit)`
da classe `AppointmentPriceCalculator`, para cobrir **100% dos critérios da técnica funcional**. Antes de
automatizar os testes, liste cada requisito na tabela a seguir:

| ID  | Requisito de Teste   | Critério                       |
| --- | -------------------- | ------------------------------ |
| R1  | Exemplo de requisito | Particionamento / Valor Limite |

Indique o(s) id(s) dos requisitos nos testes que o(s) cobre(m), no `@DisplayName` ou como comentário.

---

### Questão 2 [5 pts]:

Crie um conjunto de casos de testes unitários para o método `averageDelayMinutes(UUID doctorId, LocalDate date)`
da classe `ClinicReportService`, para cobrir **100% dos critérios da técnica funcional**. Para isolar a classe
sob teste, emule a interação com o banco de dados. Em ao menos **dois** casos de teste, crie dublês de teste do
tipo `Mock`. Utilize métodos e anotações adequados para organizar códigos de _fixture_.

Antes de automatizar os testes, liste cada requisito testado na tabela a seguir:

| ID  | Requisito de Teste   | Critério                       |
| --- | -------------------- | ------------------------------ |
| R1  | Exemplo de requisito | Particionamento / Valor Limite |

Indique o(s) id(s) dos requisitos nos testes que o(s) cobre(m), no `@DisplayName` ou como comentário.
