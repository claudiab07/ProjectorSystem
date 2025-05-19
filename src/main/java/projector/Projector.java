package projector;

import observer.Observer;

public class Projector implements Observer {
    private String name;

    public Projector(String name) {
        this.name = name;
    }

    public void turnOn() {
        System.out.println(name + " turned on.");
    }

    public void moveLight() {
        System.out.println(name + ": Light moved.");
    }

    public void update(String data) {
        System.out.println(name + " received update: " + data);

        if (data.equalsIgnoreCase("Move the light")) {
            moveLight();
        }
    }
}