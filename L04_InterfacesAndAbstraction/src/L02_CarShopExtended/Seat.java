package L02_CarShopExtended;

public class Seat extends CarImpl implements Sellable{
    private Double price;
    public Seat(String model, String color, Integer horsePower, String countryProduced,Double price) {
        super(model, color, horsePower, countryProduced);
        this.price=price;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
       StringBuilder sb= new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
       sb.append(getModel()).append(" sells for ").append(getPrice());
        return sb.toString();
    }
}
