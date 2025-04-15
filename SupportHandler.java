abstract class SupportHandler {
    protected SupportHandler next;

    public SupportHandler setNext(SupportHandler handler) {
        this.next = handler;
        return handler;
    }

    public abstract void handle(String issue);
}
