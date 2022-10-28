package L01_WorkingWithAbstractionLab.L04_HotelReservation;

public class PriceCalculator {

    public static double calculateHolidayPrice(double pricePerDay,int days, Seasons season, DiscountType discountType){
        double priceForAllDays = pricePerDay*days;
        priceForAllDays=priceForAllDays*season.getMultiplyCoefficient();
        priceForAllDays=priceForAllDays- priceForAllDays*discountType.getPercent()/100;
        return priceForAllDays;
    }

}
