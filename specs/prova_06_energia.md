### Exercício Simulado: Verificação, Validação e Teste de Software

#### Contexto
A startup *EcoHouse* desenvolveu um sistema inteligente para gestão de energia residencial. O sistema possui duas funcionalidades principais em seu domínio: o cálculo da tarifa mensal baseada no consumo e o acionamento automático de um modo de economia de energia.

O cálculo da fatura é realizado pela classe EnergyBillCalculator, através do método double calculateBill(double kwh). A lógica de cobrança é escalonada em faixas de consumo:
*   Se o consumo for negativo, o método deve disparar uma IllegalArgumentException.
*   Para consumos de *0 até 100 kWh* (inclusive), é aplicada a tarifa social de *R$ 0,50* por kWh.
*   Para consumos *acima de 100 kWh até 300 kWh* (inclusive), a tarifa passa a ser de *R$ 0,80* por kWh.
*   Para consumos *acima de 300 kWh*, a tarifa é de RS 1,20 por kWh, acrescido de uma taxa fixa extra de R$ 20,00 pelo excesso de demanda.

Além disso, o sistema conta com a classe HomeAutomationService, responsável por gerenciar os dispositivos da casa. Nela, o método boolean triggerPowerSavingMode(String deviceId) interage com duas interfaces de infraestrutura externa: a EnergyGridApi (que informa a bandeira tarifária atual da rede elétrica) e o DeviceRepository (que envia comandos de hardware para as tomadas).
As regras deste método são:
*   Se o deviceId for nulo ou vazio (em branco), o método deve disparar uma IllegalArgumentException.
*   O método consulta a API externa através da chamada energyGridApi.getCurrentFlag().
*   Se a bandeira retornada for "RED", o método aciona o repositório chamando deviceRepository.turnOff(deviceId) e retorna true (indicando que o modo de economia foi ativado com sucesso).
*   Se a bandeira retornada for qualquer outra (como "GREEN" ou "YELLOW"), o método *não* deve chamar o repositório para desligar o dispositivo e deve retornar false.

Na avaliação das questões a seguir, não será levado em conta apenas o conjunto de casos de teste, mas também a organização da classe de teste, o adequado uso de frameworks (JUnit e AssertJ) e bibliotecas (Mockito), bem como a qualidade da automação dos testes.

---

#### Questão 1 [5 pts]:
Crie um conjunto de casos de testes unitários para o método calculateBill(double kwh) da classe EnergyBillCalculator, para cobrir 100% dos critérios da técnica funcional (Particionamento de Classes de Equivalência e Análise do Valor Limite). Antes de automatizar os testes, liste cada requisito na tabela a seguir:

| ID  | Requisito de Teste                                                  | Critério          |
|:----|:--------------------------------------------------------------------|:------------------|


Indique o(s) id(s) dos requisitos nos testes que o(s) cobre(m), no @DisplayName ou como comentário.

---

#### Questão 2 [5 pts]:
Crie um conjunto de casos de testes unitários para o método triggerPowerSavingMode(String deviceId) da classe HomeAutomationService, para cobrir 100% dos critérios da técnica funcional. Para isolar a unidade em teste de suas dependências com a API externa e com o repositório, crie dublês de teste do tipo *Mock* utilizando o framework Mockito. Configure a classe de teste para que os mocks sejam criados e injetados de forma automática (utilizando @ExtendWith(MockitoExtension.class), @Mock e @InjectMocks).

Antes de automatizar os testes, liste cada requisito testado na tabela a seguir:

| ID | Requisito de Teste                                    | Critério          |
|:---|:------------------------------------------------------|:------------------|


Indique o(s) id(s) dos requisitos nos testes que o(s) cobre(m), no @DisplayName ou como comentário.

*