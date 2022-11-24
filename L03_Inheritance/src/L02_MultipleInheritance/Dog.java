package L02_MultipleInheritance;

public class Dog extends Animal {
    @Override
    public void eat() {
        super.eat();
    }
    public void bark(){
        System.out.println("barking...");
    }
}
