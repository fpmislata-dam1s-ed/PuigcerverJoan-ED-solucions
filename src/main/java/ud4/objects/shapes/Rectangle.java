package ud4.objects.shapes;

public class Rectangle {
    private double x, y;
    private double width, height;

    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle() {
        this.width = 1;
        this.height = 1;
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
        return width * height;
    }

    public void move(double dx, double dy){
        this.x += dx;
        this.y += dy;
    }

    public boolean contains(double px, double py){
        return x <= px && px <= (x + width)
                && y <= py && py <= (y + height);
    }
}
