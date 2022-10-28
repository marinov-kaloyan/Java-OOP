package L01_WorkingWithAbstractionLab;

import java.util.Scanner;

public class L01_RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        printTopPart(input);

        printBottomPart(input);

    }

    private static void printTopPart(int input) {
        for (int row = 1; row <= input; row++) {
            printRow(input,row);

        }
    }

    private static void printBottomPart(int input) {
        for (int row = input -1; row >=1 ; row--) {
            printRow(input,row);
        }
    }


    private static void printRow(int n , int row){
        for (int space = 1; space <=n-row ; space++) {
            System.out.print(" ");

        }
        for (int star = 1; star <=row ; star++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}
