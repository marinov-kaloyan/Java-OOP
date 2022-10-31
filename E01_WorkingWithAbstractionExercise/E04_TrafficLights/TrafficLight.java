package E01_WorkingWithAbstractionExercise.E04_TrafficLights;

public class TrafficLight {
    private Colour colour;

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public TrafficLight(Colour colour) {
        this.colour = colour;

    }
    public void changeColour(){
        switch (colour){
            case RED : colour=Colour.GREEN;
            break;
            case GREEN: colour=Colour.YELLOW;
            break;
            case YELLOW: colour=Colour.RED;

        break;
            default:break;}
    }
}
