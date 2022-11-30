package L02_CarShopExtended;


public class Audi extends CarImpl implements Rentable{
    private Integer minRentDay;
    private Double pricePerDay;

    public Audi(String model, String color, Integer horsePower, String countryProduced, Integer minRentDay, Double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return pricePerDay;
    }

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append("Minimum rental period of ").append(getMinRentDay()).append(" days. Price per day ").append(getPricePerDay());
        return sb.toString();
    }
}
