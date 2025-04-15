public class SmartHomeDemo {
    public static void main(String[] args) {

        Light light = new Light();
        Thermostat thermostat = new Thermostat();

        Command lightOnCommand = new TurnOnLightCommand(light);
        Command setTempCommand = new SetThermostatCommand(thermostat, 18);

        SmartHomeRemoteControl remote = new SmartHomeRemoteControl();

        remote.setCommand("light_on", lightOnCommand);
        remote.setCommand("set_temp", setTempCommand);

        remote.pressButton("light_on");
        remote.pressButton("set_temp");
        remote.pressUndo();
    }
}
