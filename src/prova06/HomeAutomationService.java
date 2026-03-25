package prova06;

public class HomeAutomationService {
    private final EnergyGridApi energyGridApi;
    private final DeviceRepository deviceRepository;

    public HomeAutomationService(EnergyGridApi energyGridApi, DeviceRepository deviceRepository) {
        this.energyGridApi = energyGridApi;
        this.deviceRepository = deviceRepository;
    }

    public boolean triggerPowerSavingMode(String deviceId) {
        if (deviceId == null || deviceId.trim().isEmpty()) {
            throw new IllegalArgumentException("O ID do dispositivo não pode ser nulo ou vazio.");
        }

        EnergyFlag currentFlag = energyGridApi.getCurrentFlag();

        if (currentFlag == EnergyFlag.RED) {
            return deviceRepository.turnOff(deviceId);
        }

        return false;
    }
}