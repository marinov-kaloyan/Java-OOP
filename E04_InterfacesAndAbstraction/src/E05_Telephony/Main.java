package E05_Telephony;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> callable = Arrays.stream(scanner
                        .nextLine()
                        .split("\\s+"))
                .collect(Collectors.toList());
        List<String> browsable = Arrays.stream(scanner
                        .nextLine()
                        .split("\\s+"))
                .collect(Collectors.toList());
        Smartphone smartphone = new Smartphone(callable,browsable);

        System.out.print(smartphone.call());
        System.out.println(smartphone.browse());

    }
}
