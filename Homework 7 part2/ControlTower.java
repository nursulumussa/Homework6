import java.util.*;

public class ControlTower implements TowerMediator {
    private Queue<Aircraft> landingQueue = new LinkedList<>();
    private Queue<Aircraft> takeoffQueue = new LinkedList<>();
    private List<Aircraft> allAircraft = new ArrayList<>();
    private boolean runwayOccupied = false;

    public void registerAircraft(Aircraft a) {
        allAircraft.add(a);
    }

    @Override
    public void broadcast(String msg, Aircraft sender) {
        System.out.println("[TOWER] " + sender.getId() + " -> " + msg);
        if (msg.equalsIgnoreCase("MAYDAY")) {
            handleEmergency(sender);
        } else if (msg.equalsIgnoreCase("REQUEST LANDING")) {
            landingQueue.add(sender);
        } else if (msg.equalsIgnoreCase("REQUEST TAKEOFF")) {
            takeoffQueue.add(sender);
        }
    }

    @Override
    public boolean requestRunway(Aircraft a) {
        if (!runwayOccupied) {
            runwayOccupied = true;
            System.out.println("Runway granted to " + a.getId());
            return true;
        }
        return false;
    }

    private void handleEmergency(Aircraft emergency) {
        System.out.println("!!! EMERGENCY from " + emergency.getId() + " !!!");
        runwayOccupied = false;
        landingQueue.remove(emergency);
        landingQueue.add(emergency); // добавим в конец, потом перенесем вверх
        LinkedList<Aircraft> list = new LinkedList<>(landingQueue);
        list.remove(emergency);
        list.addFirst(emergency);
        landingQueue = list;

        for (Aircraft a : allAircraft) {
            if (!a.getId().equals(emergency.getId())) {
                a.receive("Hold position. Emergency in progress.");
            }
        }

        if (requestRunway(emergency)) {
            emergency.receive("You are cleared for emergency landing!");
        }
    }

    public void processQueues() {
        if (!runwayOccupied) {
            Aircraft next = !landingQueue.isEmpty() ? landingQueue.poll() : takeoffQueue.poll();
            if (next != null) {
                runwayOccupied = true;
                next.receive("You are cleared for runway.");
            }
        }
    }

    public void releaseRunway() {
        runwayOccupied = false;
    }

    public void printQueues() {
        System.out.println("Landing Queue: " + queueToString(landingQueue));
        System.out.println("Takeoff Queue: " + queueToString(takeoffQueue));
    }

    private String queueToString(Queue<Aircraft> queue) {
        StringBuilder sb = new StringBuilder();
        for (Aircraft a : queue) {
            sb.append(a.getId()).append(" ");
        }
        return sb.toString().trim();
    }
}
