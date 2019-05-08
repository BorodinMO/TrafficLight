package homework1;

public class Homework1 {
    public static void main(String[] args) {
        SimpleTrafficLight simpleTrafficLight = new SimpleTrafficLight();

        simpleTrafficLight.clearSequence();
        simpleTrafficLight.addSequenceElement(LightColour.RED, 2);
        simpleTrafficLight.addSequenceElement(LightColour.YELLOW, 1);
        simpleTrafficLight.addSequenceElement(LightColour.GREEN, 3);
        simpleTrafficLight.addSequenceElement(LightColour.YELLOW, 1);

        Runnable trafficLightRunner = new TrafficLightRunner(simpleTrafficLight);
        trafficLightRunner.run();
    }
}
