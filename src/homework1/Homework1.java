package homework1;

import java.util.ArrayList;
import java.util.List;

public class Homework1 {
    public static void main(String[] args) {
        List<SequenceNode> colourSequence = new ArrayList<>();

        colourSequence.add(new SequenceNode(LightColour.RED, 2));
        colourSequence.add(new SequenceNode(LightColour.YELLOW, 1));
        colourSequence.add(new SequenceNode(LightColour.GREEN, 3));
        colourSequence.add(new SequenceNode(LightColour.YELLOW, 1));

        SimpleTrafficLight simpleTrafficLight = new SimpleTrafficLight(colourSequence);

        Runnable trafficLightRunner = new TrafficLightRunner(simpleTrafficLight);
        trafficLightRunner.run();
    }
}
