package L01_WorkingWithAbstractionLab.L04_HotelReservation;

public enum Seasons {
    SUMMER("Summer",4),
    AUTUMN("Autumn",1),
    WINTER("Winter",3),
    SPRING("Spring",2);

    public String getName() {
        return name;
    }

    public int getMultiplyCoefficient() {
        return multiplyCoefficient;
    }

    private String name;
    private int multiplyCoefficient;

    Seasons(String name, int multiplyCoefficient) {
        this.name = name;
        this.multiplyCoefficient = multiplyCoefficient;
    }
}
