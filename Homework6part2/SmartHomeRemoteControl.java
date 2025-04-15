import java.util.HashMap;
import java.util.Map;

public class SmartHomeRemoteControl {
    private Map<String, Command> slots = new HashMap<>();
    private Command lastCommand;

    public void setCommand(String slot, Command command) {
        slots.put(slot, command);
        Logger.log("Assigned command to slot: " + slot);
    }

    public void pressButton(String slot) {
        Command command = slots.get(slot);
        if (command != null) {
            Logger.log("Pressing button: " + slot);
            command.execute();
            lastCommand = command;
        } else {
            Logger.log("No command assigned to slot: " + slot);
        }
    }

    public void pressUndo() {
        if (lastCommand != null) {
            Logger.log("Undo last command");
            lastCommand.undo();
        } else {
            Logger.log("Nothing to undo");
        }
    }
}
