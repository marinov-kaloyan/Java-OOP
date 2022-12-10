package christmasPastryShop.entities.delicacies;

import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

public abstract class BaseDelicacy implements Delicacy {

    private String name;
    private double portion;
    private double price;

    public BaseDelicacy(String name, double portion, double price) {
        this.setName(name);
        this.setPortion(portion);
        this.setPrice(price);
    }

    private void setPrice(double price) {
    if(price<=0){throw new IllegalArgumentException("Price cannot be less or equal to zero!");}
    this.price=price;
    }

    private void setPortion(double portion) {
        if (portion <= 0) {
            throw new IllegalArgumentException("Portion cannot be less or equal to zero!");
        }
        this.portion=portion;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or white space!");
        }
        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPortion() {
        return portion;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2fg - %.2f",getName(),getPortion(),getPrice());
    }
}

