# Prova 03 — Teste Funcional Baseado em Requisitos

## Contexto

A biblioteca universitária **Ler & Saber** deseja automatizar o cálculo de multas por atraso na devolução de livros.
O cálculo é realizado pelo método
`double calculateFine(LocalDate dueDate, LocalDate returnDate, String memberType)` da classe `LoanFineCalculator`.

As regras de negócio são as seguintes:

- `dueDate`, `returnDate` e `memberType` são obrigatórios.
- `memberType` deve ser obrigatoriamente `"STUDENT"`, `"TEACHER"` ou `"VISITOR"`.
- Caso `returnDate` seja anterior a `dueDate`, o método deverá retornar **0.0**.
- Caso `returnDate` seja igual a `dueDate`, o método deverá retornar **0.0**.
- Caso haja atraso, a multa será calculada por dia completo de atraso:
  - `"STUDENT"`: **R$ 1.50** por dia;
  - `"TEACHER"`: **R$ 0.75** por dia;
  - `"VISITOR"`: **R$ 3.00** por dia.
- A multa máxima possível é limitada a **R$ 90.00**.
- Sempre que o método `calculateFine(...)` for invocado com valores nulos, deverá ser disparada uma
  `NullPointerException`.
- Sempre que o método `calculateFine(...)` for invocado com `memberType` inválido, deverá ser disparada uma
  `IllegalArgumentException`.

Também há uma classe chamada `LibraryReportService`, responsável por produzir relatórios. Nela, o método
`double averageLoanDays(String isbn, LocalDate startDate, LocalDate endDate)` é utilizado para calcular a média
de dias de empréstimo de um livro em um intervalo de datas. Para esse cálculo, a classe depende de um
`LoanRepository`.

As regras desse método são:

- Caso algum dos parâmetros seja nulo, deverá ser disparada uma `NullPointerException`.
- Caso `isbn` seja vazio ou contenha apenas espaços em branco, deverá ser disparada uma `IllegalArgumentException`.
- Caso `startDate` seja posterior a `endDate`, deverá ser disparada uma `IllegalArgumentException`.
- Caso não existam empréstimos no período consultado, o método deverá retornar **0.0**.
- O valor retornado deverá corresponder à média aritmética simples da duração, em dias, dos empréstimos encontrados.

Na avaliação das questões a seguir, não será levado em conta apenas o conjunto de casos de teste, mas também a
organização da classe de teste, o adequado uso de _frameworks_ e bibliotecas, bem como a qualidade da automação
dos testes. Considere o uso de **JUnit 5**, **AssertJ** e, quando houver dependências externas, **Mockito**.

### Questão 1 [5 pts]:

Crie um conjunto de casos de testes unitários para o método
`calculateFine(LocalDate dueDate, LocalDate returnDate, String memberType)` da classe `LoanFineCalculator`,
para cobrir **100% dos critérios da técnica funcional**. Antes de automatizar os testes, liste cada requisito
na tabela a seguir:

| ID  | Requisito de Teste   | Critério                       |
| --- | -------------------- | ------------------------------ |
| R1  | Exemplo de requisito | Particionamento / Valor Limite |

Indique o(s) id(s) dos requisitos nos testes que o(s) cobre(m), no `@DisplayName` ou como comentário.

---

### Questão 2 [5 pts]:

Crie um conjunto de casos de testes unitários para o método
`averageLoanDays(String isbn, LocalDate startDate, LocalDate endDate)` da classe `LibraryReportService`,
para cobrir **100% dos critérios da técnica funcional**. Para isolar a classe sob teste, emule a interação
com o banco de dados. Em ao menos **dois** casos de teste, crie dublês de teste do tipo `Mock`. Utilize
métodos e anotações adequados para organizar códigos de _fixture_.

Antes de automatizar os testes, liste cada requisito testado na tabela a seguir:

| ID  | Requisito de Teste   | Critério                       |
| --- | -------------------- | ------------------------------ |
| R1  | Exemplo de requisito | Particionamento / Valor Limite |

Indique o(s) id(s) dos requisitos nos testes que o(s) cobre(m), no `@DisplayName` ou como comentário.
