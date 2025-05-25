public abstract class Aircraft {
    protected String id;
    protected int fuelLevel;

    public Aircraft(String id, int fuelLevel) {
        this.id = id;
        this.fuelLevel = fuelLevel;
    }

    public String getId() { return id; }
    public int getFuelLevel() { return fuelLevel; }

    public void send(String msg, TowerMediator mediator) {
        mediator.broadcast(msg, this);
    }

    public abstract void receive(String msg);
}
