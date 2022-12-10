package christmasPastryShop.core;

import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.OpenBooth;
import christmasPastryShop.entities.booths.PrivateBooth;
import christmasPastryShop.entities.cocktails.Hibernation;
import christmasPastryShop.entities.cocktails.MulledWine;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.delicacies.Gingerbread;
import christmasPastryShop.entities.delicacies.Stolen;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

public class ControllerImpl implements Controller {

    private DelicacyRepository<Delicacy> delicacyRepository;
    private CocktailRepository<Cocktail> cocktailRepository;
    private BoothRepository<Booth> boothRepository;
    private  double allBills;
    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
       this.delicacyRepository=delicacyRepository;
       this.cocktailRepository=cocktailRepository;
       this.boothRepository=boothRepository;
    }


    @Override
    public String addDelicacy(String type, String name, double price) {
        Delicacy delicacy = null;

        if("Gingerbread".equals(type)){
           delicacy= new Gingerbread(name,price);
        }
        if("Stolen".equals(type)){
            delicacy= new Stolen(name,price);
        }
        if(delicacyRepository.getByName(name)!=null){
            throw new IllegalArgumentException(String.format("%s %s is already in the pastry shop!",type,name));
        }
        delicacyRepository.add(delicacy);
        return String.format("Added delicacy %s - %s to the pastry shop!",name,type );
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        Cocktail cocktail = null;

        if("MulledWine".equals(type)){
            cocktail= new MulledWine(name,size,brand);
        }
        if("Hibernation".equals(type)){
            cocktail= new Hibernation(name,size,brand);
        }
        if(cocktailRepository.getByName(name)!=null){
            throw new IllegalArgumentException(String.format("%s %s is already in the pastry shop!",type,name));
        }
        cocktailRepository.add(cocktail);
        return String.format("Added cocktail %s - %s to the pastry shop!",name,brand );
    }


    @Override
    public String addBooth(String type, int boothNumber, int capacity) {

    Booth booth = null;

       if("OpenBooth".equals(type)){
           booth = new OpenBooth(boothNumber,capacity);
       }
       if("PrivateBooth".equals(type)){
           booth=new PrivateBooth(boothNumber,capacity);
       }
       if(boothRepository.getByNumber(boothNumber)!=null){
           throw new IllegalArgumentException(String.format("Booth %d is already added to the pastry shop!",boothNumber));
       }
       boothRepository.add(booth);

        return String.format("Added booth number %d in the pastry shop!",boothNumber);
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        Booth booth = boothRepository.getAll().stream().filter(s->!s.isReserved()&&s.getCapacity()>=numberOfPeople).findFirst().orElse(null);
        if(booth==null){
            return String.format("No available booth for %d people!",numberOfPeople);

        }
        booth.reserve(numberOfPeople);
        return String.format("Booth %d has been reserved for %d people!",booth.getBoothNumber(),numberOfPeople);
    }

    @Override
    public String leaveBooth(int boothNumber) {
        Booth booth = boothRepository.getByNumber(boothNumber);
        double bill = booth.getBill();
        allBills+=bill;
        booth.clear();

        return String.format("Booth: %d%nBill: %.2f",boothNumber,bill);
    }

    @Override
    public String getIncome() {

        return String.format("Income: %.2flv",allBills);
    }
}
