package L01_SingleInheritance;

public class Dog extends Animal{
    @Override
    public void eat() {
        super.eat();
    }
    public void bark(){
        System.out.println("barking...");
    }
}
