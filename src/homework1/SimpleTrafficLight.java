package homework1;

import java.util.ArrayList;
import java.util.List;

public class SimpleTrafficLight implements TrafficLight {
    private LightColour colour;
    private List<SequenceNode> colourSequence;

    public SimpleTrafficLight() {
        colourSequence = new ArrayList<>();
        for (LightColour key : LightColour.values()) {
            SequenceNode node = new SequenceNode(key, 1);
            colourSequence.add(node);
        }
        colour = colourSequence.get(0).getColour();
    }

    public SimpleTrafficLight(List<SequenceNode> colourSequence) {
        if (colourSequence.isEmpty()) throw new IllegalArgumentException("ColourSequence must not be empty.");
        this.colourSequence = colourSequence;
        colour = colourSequence.get(0).getColour();
    }

    public void runFor(int endTime) {
        if (endTime < 0)
            throw new IllegalArgumentException("Only positive endTime numbers" +
                    " are allowed in SimpleTrafficLight.runFor().");
        int sequenceDuration = getSequenceDuration();

        for (int time = 0; time <= endTime; time++) {
            int innerTime = time % sequenceDuration;
            int colourChangeTime = 0;
            for (SequenceNode node : colourSequence) {
                colourChangeTime += node.getDuration();

                if (innerTime < colourChangeTime) {
                    colour = node.getColour();
                    break;
                }
            }
        }
    }

    public String getColour() {
        return colour.toString();
    }

    public void addSequenceElement(LightColour colour, int time) {
        if (time <= 0)
            throw new IllegalArgumentException("Only positive time numbers are allowed" +
                    " in SimpleTrafficLight.addSequenceElement().");
        SequenceNode node = new SequenceNode(colour, time);
        this.colourSequence.add(node);
    }

    public void clearSequence() {
        colourSequence.clear();
    }

    public int getSequenceDuration() {
        int sequenceTime = 0;
        for (SequenceNode node : colourSequence) {
            sequenceTime += node.getDuration();
        }
        return sequenceTime;
    }
}
