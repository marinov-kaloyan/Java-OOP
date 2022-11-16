package E02_AnimalFarm;

public class  Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public void setName(String name) {
        if (name.length() < 1) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age > 15||age<=0) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public double productPerDay() {
     return calculateProductPerDay();
    }
    private double calculateProductPerDay(){
        double eggsPerDay = 0.75;
        if (this.age < 6) {
            eggsPerDay = 2;
        } else if (this.age < 12) {
            eggsPerDay = 1;

        }
        return eggsPerDay;

    }
    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", name, age, productPerDay());
    }


}
