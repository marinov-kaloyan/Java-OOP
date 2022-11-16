package E01_ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
validation(length,"Length");
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    private void setWidth(double width) {
        validation(width,"Width");
        this.width = width;
    }

    private void setHeight(double height) {
        validation(height,"Height");
        this.height = height;
    }
    private void validation(double side,String prefix){
        if(side<=0){
            throw new IllegalArgumentException(prefix+" cannot be zero or negative.");
        }
    }


    public double calculateSurfaceArea(){
        return 2*this.length*this.height+2*this.length*this.width+2*this.width*this.height;
    }
    public double calculateLateralSurfaceArea(){
        return 2*this.length*this.height+2*this.width*this.height;
    }
    public double calculateVolume(){
        return this.height*this.width*this.length;
    }

}

