package Pregunta1;


public class Ingeniero {
    private double tarifa;
    private int edad;
    private String nombre;
    private int horasTrabajadas;


    public Ingeniero(double tarifa, int edad, String nombre, int horasTrabajadas) {
        this.tarifa = tarifa;
        this.edad = edad;
        this.nombre = nombre;
        this.horasTrabajadas = horasTrabajadas;
    }

    public double getTarifa() {
        return tarifa;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }
}
