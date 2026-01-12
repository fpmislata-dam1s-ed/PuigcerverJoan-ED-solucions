package ud4.objects;

/**
 * Classe que representa un cotxe.
 * @author Joan Puigcerver
 * @version 1.3 2026-01-07
 */
public class Car {
    /**
     * Matrícula del cotxe
     */
    private final String plate;
    /**
     * Velocitat del cotxe en km/h
     */
    private int speed;
    /**
     * Distància total recorreguda pel cotxe en km
     */
    private double kilometers;

    /**
     * Crea un cotxe a partir de la matrícula i els
     * kilòmetres totals recorreguts i la velocitat.
     * @param plate Matrícula del cotxe
     * @param kilometers Kilòmetres recorreguts
     * @param speed Velocitat actual
     */
    public Car(String plate, double kilometers, int speed){
        this.plate = plate;
        this.kilometers = kilometers;
        this.speed = speed;
    }

    /**
     * Crea un cotxe a partir de la matrícula i els
     * kilòmetres totals recorreguts. La velocitat inicial és 0 km/h.
     * @param plate Matrícula del cotxe
     * @param kilometers Kilòmetres recorreguts
     */
    public Car(String plate, double kilometers){
        this(plate, kilometers, 0);
    }

    /**
     * Crea un cotxe a partir de la matrícula
     * Els kilòmetres totals recorreguts inicials és 0 i la velocitat inicial és 0 km/h.
     * @param plate Matrícula del cotxe
     */
    public Car(String plate){
        this(plate, 0, 0);
    }

    /**
     * Obté la matrícula del cotxe
     * @return Matrícula del cotxe
     */
    public String getPlate() {
        return plate;
    }

    /**
     * Obté la velocitat actual del cotxe
     * @return Velocitat del cotxe
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Obté els kilòmetres totals recorreguts pel cotxe
     * @return Kilòmetres recorreguts
     */
    public double getKilometers() {
        return kilometers;
    }

    /**
     * Accelera el cotxe en la velocitat especificada
     * @param speed Velocitat que accelerarà el cotxe
     */
    public void accelerate(int speed){
        this.speed += speed;
    }

    /**
     * Accelera el cotxe en 5 km/h
     */
    public void accelerate(){
        accelerate(5);
    }

    /**
     * Condueix el cotxe durant els segons especificats.
     * Aquest mètode actualitza els kilòmetres recorreguts tenint en compte
     * la velocitat actual.
     */
    public void drive(int seconds){
        this.kilometers += (double) speed * seconds / 3600.0;
    }

    /**
     * Condueix el cotxe durant un minut.
     * Aquest mètode actualitza els kilòmetres recorreguts tenint en compte
     * la velocitat actual.
     * @see Car#drive()
     */
    public void drive(){
        drive(1);
    }

    /**
     * Retorna una representació de l'objecte en format String
     * @return Representació del cotxe
     */
    @Override
    public String toString() {
        return String.format("Car %s: {speed=%d km/h, kilometers=%.2f km", plate, speed, kilometers);
    }
}
