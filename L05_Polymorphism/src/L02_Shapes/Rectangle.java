package L02_Shapes;

public class Rectangle extends  Shape{
    private final Double height;
    private final   Double width;


    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    @Override
    Double calculatePerimeter() {
        return 2*height+2*width;
    }

    @Override
    Double calculateArea() {
        return height*width;
    }
}
