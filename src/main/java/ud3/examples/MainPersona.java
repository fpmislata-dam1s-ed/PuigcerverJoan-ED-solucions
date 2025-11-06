package ud3.examples;

public class MainPersona {
    public static void main(String[] args) {
        Persona p1 = new Persona("00000000A", "2000-01-01");
        Persona p2 = new Persona("11111111B", "1990-05-15");
        System.out.println(p1.getDni());
        p1.setDni("22222222C");
    }
}
