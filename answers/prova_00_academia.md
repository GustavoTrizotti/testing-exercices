### Questão 1 [5 pts]:

Crie um conjunto de casos de testes unitários para o método `checkout()` da classe `SessionPriceCalculator`,
para cobrir 100% dos critérios da técnica funcional. Antes de automatizar os testes, liste cada
requisito na tabela a seguir:

| ID  | Requisito de Teste                                                                                    | Critério        |
|-----|-------------------------------------------------------------------------------------------------------|-----------------|
| R1  | Sair antes da academia abrir -> IllegalStateException                                                 | Particionamento |
| R2  | Sair em horário bonificado no início do dia -> pagamento bonificado                                   | Particionamento |
| R3  | Sair em horário normal com entrada bonificada -> pagamento misto                                      | Particionamento |
| R4  | Sair em horário normal sem entrada bonificada -> pagamento normal                                     | Particionamento |
| R5  | Sair em horário bonificado no final do dia sem entrada bonificada -> pagamento misto                  | Particionamento |
| R6  | Sair em horário bonificado no final do dia com entrada bonificada -> pagamento bonificado             | Particionamento |
| R7  | Sair em horário bonificado no final do dia com entrada bonificada no início do dia -> pagamento misto | Particionamento |
| R8  | Sair sem ter entrado -> IllegalStateException                                                         | Particionamento |
| R9  | Sair em menos de um minuto -> IllegalStateException                                                   | Particionamento |
| R10 | Sair no próximo dia da entrada -> IllegalStateException                                               | Particionamento |
| R11 | Sair exatamente no minuto que a academia abre                                                         | Valor Limite    |
| R12 | Sair exatamente no minuto após a academia fechar                                                      | Valor Limite    |
| R13 | Sair exatamente no minuto após o limite da bonificação da manhã -> pagamento misto                    | Valor Limite    |
| R14 | Sair exatamente no minuto antes do limite da bonificação da manhã -> pagamento bonificado             | Valor Limite    |
| R15 | Sair exatamente no minuto antes o limite de horário comum -> pagamento sem bonificação noturna        | Valor Limite    |
| R16 | Sair exatamente no minuto após o limite de horário comum -> pagamento misto                           | Valor Limite    |
| R17 | Sair exatamente no minuto antes do limite de horário de fechamento -> pagamento válido                | Valor Limite    |
| R18 | Sair exatamente no minuto após do limite de horário de fechamento -> IllegalStateException            | Valor Limite    |

Indique o(s) id(s) dos requisitos no testes que o(s) cobre(m), no DisplayName ou como comentário.
