package observer;

public interface Observer {
    public default void update(String data) { }
}
