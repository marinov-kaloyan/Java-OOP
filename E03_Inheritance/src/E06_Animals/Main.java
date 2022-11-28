package E06_Animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String animalType= scanner.nextLine();
        while (!"Beast!".equals(animalType)){
            String[] animalInfo = scanner.nextLine().split(" ");
            String name =animalInfo[0];
            int age =Integer.parseInt(animalInfo[1]);
            String gender =animalInfo[2];
            switch (animalType){
                case "Cat":
                    try{
                    Cat cat=new Cat(name,age,gender);
                    System.out.print(cat);}
                    catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Dog":
                    try{
                        Dog dog= new Dog(name,age,gender);
                        System.out.print(dog);}
                    catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Frog":
                    try{
                        Frog frog=new Frog(name,age,gender);
                        System.out.print(frog);}
                    catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Tomcat":
                    try{
                        Tomcat tomcats=new Tomcat(name,age);
                        System.out.print(tomcats);}
                    catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Kitten":
                    try{
                        Kitten kittens=new Kitten(name,age);
                        System.out.print(kittens);}
                    catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
            animalType= scanner.nextLine();
        }
    }
}
