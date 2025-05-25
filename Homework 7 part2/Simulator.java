import java.util.*;
import java.util.concurrent.*;

public class Simulator {
    public static void main(String[] args) {
        ControlTower tower = new ControlTower();
        Random rand = new Random();

        List<Aircraft> aircraftList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            int fuel = rand.nextInt(100);
            Aircraft a;
            switch (rand.nextInt(3)) {
                case 0 -> a = new PassengerPlane("P" + i, fuel);
                case 1 -> a = new CargoPlane("C" + i, fuel);
                default -> a = new Helicopter("H" + i, fuel);
            }
            tower.registerAircraft(a);
            aircraftList.add(a);
        }

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            Aircraft a = aircraftList.get(rand.nextInt(aircraftList.size()));
            if (a.getFuelLevel() < 10 && rand.nextBoolean()) {
                a.send("MAYDAY", tower);
            } else if (rand.nextBoolean()) {
                a.send("REQUEST LANDING", tower);
            } else {
                a.send("REQUEST TAKEOFF", tower);
            }
            tower.processQueues();
            tower.printQueues();
            System.out.println("--------------------------");
        }, 0, 2, TimeUnit.SECONDS);

        scheduler.schedule(() -> {
            System.out.println("Simulation ended.");
            scheduler.shutdown();
        }, 30, TimeUnit.SECONDS);
    }
}
