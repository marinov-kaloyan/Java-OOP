package christmasPastryShop.entities.booths;

import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseBooth implements Booth {

    private Collection<Delicacy> delicacyOrders;
    private Collection<Cocktail> cocktailOrders;
    private int numberOfPeople;
    private int boothNumber;
    private int capacity;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    public BaseBooth(int boothNumber, int capacity, double pricePerPerson) {
        this.delicacyOrders =new ArrayList<>();
        this.cocktailOrders = new ArrayList<>();
        this.boothNumber = boothNumber;
        setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        this.isReserved =false;

    }

    private void setCapacity(int capacity) {
        if(capacity<0){
            throw new IllegalArgumentException("Capacity has to be greater than 0!");
        }
        this.capacity = capacity;
    }

    private void setNumberOfPeople(int numberOfPeople) {
        if(numberOfPeople<=0){
            throw new IllegalArgumentException("Cannot place zero or less people!");
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public int getBoothNumber() {
        return boothNumber;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    public double getPricePerPerson() {
        return pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return isReserved;
    }

    @Override
    public double getPrice() {
        this.price=getPricePerPerson()*numberOfPeople;
        return price;
    }

    public void setPrice() {
        this.price = getPrice();
    }

    @Override
    public void reserve(int numberOfPeople) {
 setNumberOfPeople(numberOfPeople);
 setPrice();
 isReserved=true;
    }

    @Override
    public double getBill() {
        double delicacyBill= delicacyOrders.stream().mapToDouble(Delicacy::getPrice).sum();
        double cocktailsBill=cocktailOrders.stream().mapToDouble(Cocktail::getPrice).sum();


        return delicacyBill+cocktailsBill+getPrice();
    }

    @Override
    public void clear() {
        delicacyOrders.clear();
        cocktailOrders.clear();
        isReserved=false;
        numberOfPeople=0;
        price=0;

    }
}
