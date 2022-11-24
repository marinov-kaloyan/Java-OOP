package E03_ShoppingSpree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] people = scanner.nextLine().split(";");
        String[] products = scanner.nextLine().split(";");
        Map<String, Person> peopleMap = new LinkedHashMap<>();
        Map<String, Product> productMap = new LinkedHashMap<>();
        for (int i = 0; i < people.length; i++) {
            String name = people[i].split("=")[0];
            double money = Double.parseDouble(people[i].split("=")[1]);
            try {
                Person person = new Person(name, money);
                peopleMap.put(name, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        for (int i = 0; i < products.length; i++) {
            String name = products[i].split("=")[0];
            double cost = Double.parseDouble(products[i].split("=")[1]);
            try {
                Product product = new Product(name, cost);
                productMap.put(name, product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String personName = command.split(" ")[0];
            String productName = command.split(" ")[1];
            Person buyer  = peopleMap.get(personName);
            Product product = productMap.get(productName);
            try{
                buyer.buyProduct(product);

            }
            catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
command = scanner.nextLine();
        }
peopleMap.values().forEach(System.out::println);

    }
}
