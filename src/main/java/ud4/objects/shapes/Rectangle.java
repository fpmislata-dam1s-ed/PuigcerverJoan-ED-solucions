package ud4.objects.shapes;

public class Rectangle extends Shape {
    private double width, height;

    public Rectangle(double x, double y, double width, double height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public Rectangle(double width, double height) {
        super(0, 0);
        this.width = width;
        this.height = height;
    }

    public Rectangle() {
        super(0, 0);
        this.width = 1;
        this.height = 1;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getArea(){
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * width + 2 * height;
    }

    @Override
    public boolean contains(double px, double py){
        return x <= px && px <= (x + width)
                && y <= py && py <= (y + height);
    }
}
