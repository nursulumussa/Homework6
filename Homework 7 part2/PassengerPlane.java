public class PassengerPlane extends Aircraft {
    public PassengerPlane(String id, int fuelLevel) {
        super(id, fuelLevel);
    }

    @Override
    public void receive(String msg) {
        System.out.println("Passenger Plane " + id + " received: " + msg);
    }
}
