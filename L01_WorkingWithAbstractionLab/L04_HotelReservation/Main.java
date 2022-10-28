package L01_WorkingWithAbstractionLab.L04_HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String input = scanner.nextLine();
        String [] splitInput = input.split("\\s+");
        double pricePerDay= Double.parseDouble(splitInput[0]);
        int numberOfDays= Integer.parseInt(splitInput[1]);
        Seasons season= Seasons.valueOf(splitInput[2].toUpperCase());
        DiscountType discountType = DiscountType.valueOf(splitInput[3].toUpperCase());
        System.out.printf("%.2f",PriceCalculator.calculateHolidayPrice(pricePerDay,numberOfDays,season,discountType));
    }
}
