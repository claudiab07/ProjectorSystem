import command.AnalyzeCommand;
import command.Command;
import command.TurnOnCommand;
import observer.Camera;
import observer.Subject;
import projector.Projector;
import strategy.GestureRecognition;
import strategy.ObjectTracking;

public class Main {
    public static void main(String[] args) {
        Projector projector1 = new Projector("projector.Projector A");
        Projector projector2 = new Projector("projector.Projector B");

        Subject camera = new Camera();
        ((Camera) camera).setBehavior(new GestureRecognition());

        camera.registerObserver(projector1);
        camera.registerObserver(projector2);

        Command turnOn1 = new TurnOnCommand(projector1);
        Command turnOn2 = new TurnOnCommand(projector2);

        turnOn1.execute();
        turnOn2.execute();


        String gestureDetection = ((Camera) camera).detect();

        System.out.println("\nGesture Detection");
        if (gestureDetection.equalsIgnoreCase("Gesture Detected")) {
            Command analyze1 = new AnalyzeCommand(projector1);
            Command analyze2 = new AnalyzeCommand(projector2);
            analyze1.execute();
            analyze2.execute();
        }

        System.out.println("\nObject tracking");
        ((Camera) camera).setBehavior(new ObjectTracking());
        String objectDetection = ((Camera) camera).detect();

        if (objectDetection.equalsIgnoreCase("Object Movement Detected")) {
            Command analyze1 = new AnalyzeCommand(projector1);
            Command analyze2 = new AnalyzeCommand(projector2);
            analyze1.execute();
            analyze2.execute();
        }
    }
}
