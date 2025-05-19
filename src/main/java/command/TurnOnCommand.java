package command;


import projector.Projector;

public class TurnOnCommand implements Command {
    private Projector projector;

    public TurnOnCommand(Projector projector) {
        this.projector = projector;
    }

    public void execute() {
        projector.turnOn();
    }
}