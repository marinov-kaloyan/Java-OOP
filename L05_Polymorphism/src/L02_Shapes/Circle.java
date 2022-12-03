package L02_Shapes;

public class Circle extends Shape {
    private final Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public  Double getRadius() {
        return radius;
    }

    @Override
    Double calculatePerimeter() {
        return 2*radius*Math.PI;
    }

    @Override
    Double calculateArea() {
        return  radius*radius*Math.PI;
    }
}
