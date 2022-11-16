package L02_Encapsulation.L02_SalaryIncrease;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    private double salary;

    public Person(String firstName, String lastName, int age,double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary=salary;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public int getAge() {   
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double bonus){
        double newSalary = this.getSalary();
        if(age<30){
            bonus=bonus/200;
        }
        else {bonus=bonus/100;}
        newSalary=newSalary*(1+bonus);
        this.setSalary(newSalary);

    }

    @Override
    public String toString() {
        return String.format("%s %s gets %.2f leva.", this.getFirstName(), this.getLastName(), this.getSalary());
    }
}
