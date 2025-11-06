package ud3.examples;

import java.time.LocalDate;

public class Persona {
    private String dni;
    private LocalDate dataNaixement;

    public Persona(String dni, String dataNaixement){
        this.dni = dni;
        this.dataNaixement = LocalDate.parse(dataNaixement);
    }

    public int edat() {
        return LocalDate.now().getYear() - dataNaixement.getYear();
    }

    public String getDni() {
        return dni;
    }

    public LocalDate getDataNaixement() {
        return dataNaixement;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
