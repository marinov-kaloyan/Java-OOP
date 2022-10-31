package E01_WorkingWithAbstractionExercise.E04_TrafficLights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int iterations = Integer.parseInt(scanner.nextLine());
        List<TrafficLight> trafficLightList = new ArrayList<>();
        for (String signal : input) {
            Colour colour = Colour.valueOf( signal);
            TrafficLight trafficLight = new TrafficLight(colour);
            trafficLightList.add(trafficLight);
        }


        for (int i = 0; i < iterations; i++) {
            for (TrafficLight trafficLight : trafficLightList) {
trafficLight.changeColour();
                System.out.print(trafficLight.getColour()+" ");

            }
            System.out.println();
        }
}
}
