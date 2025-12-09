package ud4.objects;

public class Robot {
    private double x, y;
    private double speed;

    public Robot(){
        this.x = 0;
        this.y = 0;
        this.speed = 1;
    }

    public Robot(double x, double y) {
        this.x = x;
        this.y = y;
        this.speed = 1;
    }

    public Robot(double x, double y, double speed) {
        this.x = x;
        this.y = y;
        this.setSpeed(speed);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getSpeed() {
        return speed;
    }

    private void setSpeed(double speed){
        this.speed = Math.max(Math.min(speed, 10), 0);
    }

    public void accelerate(){
        this.setSpeed(this.speed + 0.5);
    }
    public void decelerate(){
        this.setSpeed(this.speed - 0.5);
    }
    public void up(){
        this.y += this.speed;
    }
}
