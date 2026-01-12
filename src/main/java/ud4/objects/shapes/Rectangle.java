package ud4.objects.shapes;

public class Rectangle {
    private double x, y;
    private double width, height;

    public Rectangle(){
        this(0, 0, 1, 1);
    }

    public Rectangle(double width, double height){
        this(0, 0, width, height);
    }

    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getArea(){
        return this.width * this.height;
    }

    public double getPerimeter(){
        return 2 * this.width + 2 * this.height;
    }

    public boolean contains(double px, double py){
        return x <= px && px <= (x + width)
                && y <= py && py <= (y + height);
    }
}
