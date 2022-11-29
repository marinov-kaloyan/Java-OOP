package L01_CarShop;

public class Seat implements Car{
    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;

    public Seat(String model, String color, Integer horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public Integer getHorsePower() {
        return horsePower;
    }
@Override
    public String countryProduce() {
        return countryProduced;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder= new StringBuilder();
        stringBuilder.append("This is ").append(getModel()).append(" produced in ").append(countryProduced).append(" ").append(Car.TIRES).append(" tires");

    return stringBuilder.toString();}
}

