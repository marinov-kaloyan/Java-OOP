package L01_WorkingWithAbstractionLab.L02PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Point bottomLeft = new Point(arr[0],arr[1]);
        Point topRight = new Point(arr[2],arr[3]);
        Rectangle rectangle = new Rectangle(bottomLeft,topRight);
        int points = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < points; i++) {
            int[] point = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Point current = new Point(point[0],point[1]);
            System.out.println(rectangle.contains(current));
        }

    }

}
