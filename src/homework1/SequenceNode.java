package homework1;

public class SequenceNode {
    private LightColour colour;
    private int duration;

    public SequenceNode(LightColour colour, int duration) {
        this.colour = colour;
        this.duration = duration;
    }

    public SequenceNode() {

    }

    public LightColour getColour() {
        return colour;
    }

    public void setColour(LightColour colour) {
        this.colour = colour;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if (duration <= 0)
            throw new IllegalArgumentException("Only positive duration numbers are allowed in SequenceNode.setDuration().");
        this.duration = duration;
    }
}
