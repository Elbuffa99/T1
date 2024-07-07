package Pregunta2;

public class AlquilerAirbnb extends Alquiler {
	 private int tarifaDiaria;

	    public AlquilerAirbnb(int codigoCliente, String nombreCliente, int diasAlquiler, int tarifaDiaria) {
	        super(codigoCliente, nombreCliente, diasAlquiler);
	        this.tarifaDiaria = tarifaDiaria;
	    }

	    public int getTarifaDiaria() {
	        return tarifaDiaria;
	    }

	    public void setTarifaDiaria(int tarifaDiaria) {
	        this.tarifaDiaria = tarifaDiaria;
	    }

	    @Override
	    public  double costoAlquiler() {
	        return getDiasAlquiler() * tarifaDiaria;
	    }

	    @Override
	    public String caracterizar() {
	        return super.caracterizar() + "-" + tarifaDiaria;
	    }


}
