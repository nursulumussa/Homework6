public class Thermostat {
    private int temperature = 22;

    public void setTemperature(int temp) {
        System.out.println("[Thermostat] Setting temperature to " + temp + "°C");
        this.temperature = temp;
    }

    public void revertTemperature() {
        System.out.println("[Thermostat] Reverting to previous temperature");
    }
}
