package command;

import projector.Projector;

public class AnalyzeCommand implements Command {
    private Projector projector;

    public AnalyzeCommand(Projector projector) {
        this.projector = projector;
    }

    @Override
    public void execute() {
        projector.update("Move the light");
    }
}
