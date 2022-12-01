package E03_BirthdayCelebrations;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Birthable> birthableList = new ArrayList<>();
        while (!"End".equals(input)) {
            String type = input.split(" ")[0];
            switch (type) {
                case "Citizen":
                    String name = input.split(" ")[1];
                    int age = Integer.parseInt(input.split(" ")[2]);
                    String id = input.split(" ")[3];
                    String dateOfBirth = input.split(" ")[4];
                    Citizen citizen = new Citizen(name,age,id,dateOfBirth);
               birthableList.add(citizen);
               break;
                case "Pet":
                    String petName = input.split(" ")[1];
                    String petDateOfBirth = input.split(" ")[2];
                    Pet pet = new Pet(petName,petDateOfBirth);
                    birthableList.add(pet);
                    break;
                default:
                    break;
            }


            input = scanner.nextLine();
        }

        String year = scanner.nextLine();
        for (Birthable birthable : birthableList) {
            if(birthable.getBirthDate().endsWith(year)){
                System.out.println(birthable.getBirthDate());
            }
        }



    }
}

