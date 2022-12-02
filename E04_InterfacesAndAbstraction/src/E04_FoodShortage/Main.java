package E04_FoodShortage;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Buyer> buyerMap = new HashMap<>();
        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfPeople; i++) {
            String input = scanner.nextLine();
            if(input.split(" ").length==3){
                String name = input.split(" ")[0];
                int age = Integer.parseInt(input.split(" ")[1]);
                String group = input.split(" ")[2];
                Rebel rebel = new Rebel(name,age,group);
                buyerMap.put(name,rebel);

            }
            else if(input.split(" ").length==4){
                String name = input.split(" ")[0];
                int age = Integer.parseInt(input.split(" ")[1]);
                String id = input.split(" ")[2];
                String birthDate = input.split(" ")[3];
                Citizen citizen = new Citizen(name,age,id,birthDate);
                buyerMap.put(name,citizen);
            }

        }

        String namesInput =scanner.nextLine();

        while(!"End".equals(namesInput)){
            if(buyerMap.containsKey(namesInput)){
                buyerMap.get(namesInput).buyFood();
            }


            namesInput= scanner.nextLine();
        }
 int totalFood = 0;
        for (Map.Entry<String, Buyer> entry : buyerMap.entrySet()) {
            totalFood+=entry.getValue().getFood();
        }

        System.out.println(totalFood);
    }

}

