package ud4.objects.shapes;

public class Circle extends Shape {
    private double radius;

    public Circle(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    public Circle(double radius) {
        super(0, 0);
        this.radius = radius;
    }

    public Circle() {
        super(0, 0);
        this.radius = 1;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea(){
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public boolean contains(double px, double py){
        double dx = this.x - px;
        double dy = this.y - py;
        // double distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        double distance = Math.hypot(dx, dy);
        return distance <= this.radius;
    }
}
