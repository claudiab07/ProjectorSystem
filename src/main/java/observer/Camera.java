package observer;

import java.util.ArrayList;
import java.util.List;
import strategy.CameraBehavior;

public class Camera implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private CameraBehavior behavior;

    public void setBehavior(CameraBehavior behavior) {
        this.behavior = behavior;
    }

    public String detect() {
        String data = behavior.detectBehavior();
        notifyObservers(data);
        return data;
    }


    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers(String data) {
        for (Observer o : observers) {
            o.update(data);
        }
    }
}
