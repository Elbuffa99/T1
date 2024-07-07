package Pregunta1;


import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Optional;
import Pregunta1.Ingeniero;

public class ArregloIngenieros {
    private ArrayList<Ingeniero> inge;

    public ArregloIngenieros() {
    	inge = new ArrayList<>();
    }

    public void adicionarIngeniero(Ingeniero ing) {
    	inge.add(ing);
    }

    public double tarifaPromedio() {
        double sumaTarifas = 0;
        int contador = 0;
        
        for (Ingeniero ingeniero : inge) {
            if (ingeniero.getEdad() > 40) {
                sumaTarifas += ingeniero.getTarifa();
                contador++;
            }
        }
        
        if (contador > 0) {
            return sumaTarifas / contador;
        } else {
            return 0;
        }
    }

    public String nombrePrimerIngenieroMenorQue100() {
        for (Ingeniero ingeniero : inge) {
            if (ingeniero.getHorasTrabajadas() < 100) {
                return ingeniero.getNombre();
            }
        }
        return null;
    }
}
