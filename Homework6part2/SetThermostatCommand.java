public class SetThermostatCommand implements Command {
    private Thermostat thermostat;
    private int previousTemp;
    private int newTemp;

    public SetThermostatCommand(Thermostat thermostat, int newTemp) {
        this.thermostat = thermostat;
        this.newTemp = newTemp;
    }

    @Override
    public void execute() {
        Logger.log("Executing SetThermostatCommand");
        previousTemp = 22;
        thermostat.setTemperature(newTemp);
    }

    @Override
    public void undo() {
        Logger.log("Undo SetThermostatCommand");
        thermostat.revertTemperature();
    }
}
