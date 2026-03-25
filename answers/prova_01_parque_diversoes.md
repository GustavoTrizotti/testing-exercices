## Questão 1 [5 pts]:

Crie um conjunto de casos de testes unitários para o método `calculateTicketPrice(int age, int premiumAttractions)`
da classe `TicketPriceCalculator`, para cobrir **100% dos critérios da técnica funcional**. Antes de automatizar os
testes, liste cada requisito na tabela a seguir:

| ID  | Requisito de Teste                                                                                              | Critério         |
|-----|-----------------------------------------------------------------------------------------------------------------|------------------|
| R1  | `age` com valor negativo -> `IllegalArgumentException`                                                          | Particionamento  |
| R2  | `age` com valor maior que 120 anos -> `IllegalArgumentException`                                                | Particionamento  |
| R3  | `premiumAttractions` com valor menor ou igual a zero -> `IllegalArgumentException`                              | Particionamento  |
| R4  | `premiumAttractions` maior que 10 -> `IllegalArgumentException`                                                 | Particionamento  |
| R5  | `age` com valor entre 0 e 5 e uma `premiumAttractions` concede o ingresso base gratuito                         | Particionamento  |
| R6  | `age` com valor entre 6 e 12 e uma `premiumAttractions` concede o ingresso com valor R$ 20,00                   | Particionamento  |
| R7  | `age` com valor entre 13 e 59 e uma `premiumAttractions` concede o ingresso com valor R$ 35,00                  | Particionamento  |
| R8  | `age` com valor entre 60 e 120 e uma `premiumAttractions` concede o ingresso com valor R$ 18,00                 | Particionamento  |
| R9  | `age` com valor entre 6 e 12 e quatro `premiumAttractions` concede o ingresso com valor R$ 30,00                | Particionamento  |
| R10 | `age` com valor entre 6 e 12 e oito `premiumAttractions` concede o ingresso com valor R$ 38,00                  | Particionamento  |
| R11 | `age` com valor entre 6 e 12 e oito `premiumAttractions` concede o ingresso com valor R$ 38,00                  | Particionamento  |
| R12 | `age` com valor entre 0 e 5 e quatro `premiumAttractions` deve totalizar R$ 10,00 para o ingresso base gratuito | Particionamento  |
| R13 | `age` com valor entre 0 e 5 e oito `premiumAttractions` deve totalizar R$ 18,00 para o ingresso base gratuito   | Particionamento  |
| R14 | `age` com valor -1 -> IllegalArgumentException                                                                  | Valor Limite     |
| R15 | `age` com valor 0 deve garantir um ingresso base gratuito                                                       | Valor Limite     |
| R16 | `age` com valor 5 deve garantir um ingresso base gratuito                                                       | Valor Limite     |
| R17 | `age` com valor 6 deve garantir um ingresso base no valor de R$ 20,00                                           | Valor Limite     |
| R18 | `age` com valor 12 deve garantir um ingresso base no valor de R$ 20,00                                          | Valor Limite     |
| R19 | `age` com valor 13 deve garantir um ingresso base no valor de R$ 35,00                                          | Valor Limite     |
| R20 | `age` com valor 59 deve garantir um ingresso base no valor de R$ 35,00                                          | Valor Limite     |
| R21 | `age` com valor 60 deve garantir um ingresso base no valor de R$ 18,00                                          | Valor Limite     |
| R22 | `age` com valor 120 deve garantir um ingresso base no valor de R$ 18,00                                         | Valor Limite     |
| R23 | `age` com valor 121 -> IllegalArgumentException                                                                 | Valor Limite     |
| R24 | `premiumAttractions` com valor igual a zero -> IllegalArgumentException                                         | Valor Limite     |
| R25 | `premiumAttractions` com valor igual a 1 deve totalizar o mesmo valor do ingresso base (sem adição)             | Valor Limite     |
| R26 | `premiumAttractions` com valor igual a 3 deve totalizar o mesmo valor do ingresso base (sem adição)             | Valor Limite     |
| R27 | `premiumAttractions` com valor igual a 4 deve adicionar R$ 10,00 ao valor base do ingresso                      | Valor Limite     |
| R28 | `premiumAttractions` com valor igual a 7 deve adicionar R$ 10,00 ao valor base do ingresso                      | Valor Limite     |
| R29 | `premiumAttractions` com valor igual a 8 deve adicionar R$ 18,00 ao valor base do ingresso                      | Valor Limite     |
| R30 | `premiumAttractions` com valor igual a 10 deve adicionar R$ 18,00 ao valor base do ingresso                     | Valor Limite     |
| R31 | `premiumAttractions` com valor igual a 11 -> IllegalArgumentException                                           | Valor Limite     |

Indique o(s) id(s) dos requisitos nos testes que o(s) cobre(m), no `@DisplayName` ou como comentário.

## Resolução

### Classes de equivalência e valor limite:

| Parâmetro          | Valor Mínimo | Valor Máximo | Saída                    |
|--------------------|:------------:|:------------:|--------------------------|
| age                |     -INF     |      -1      | IllegalArgumentException |
| age                |      0       |      5       | Base R$ 00,00            |
| age                |      6       |      12      | Base R$ 20,00            |
| age                |      13      |      59      | Base R$ 35,00            |
| age                |      60      |     120      | Base R$ 18,00            |
| age                |     121      |     INF      | IllegalArgumentException |
| premiumAttractions |     -INF     |      0       | IllegalArgumentException |
| premiumAttractions |      1       |      3       | Adicional R$ 00,00       |
| premiumAttractions |      4       |      7       | Adicional R$ 10,00       |
| premiumAttractions |      8       |      10      | Adicional R$ 18,00       |
| premiumAttractions |      11      |     INF      | IllegalArgumentException |****