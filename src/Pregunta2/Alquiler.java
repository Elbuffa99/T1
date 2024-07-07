package Pregunta2;

public abstract class Alquiler {
	private int codigoCliente;
    private String nombreCliente;
    private int diasAlquiler;
	/**
	 * @param codigoCliente
	 * @param nombreCliente
	 */
	public Alquiler(int codigoCliente, String nombreCliente, int diasAlquiler) {
		super();
		this.codigoCliente = codigoCliente;
		this.nombreCliente = nombreCliente;
		this.diasAlquiler = diasAlquiler;
	}
	public int getDiasAlquiler() {
		return diasAlquiler;
	}
	public void setDiasAlquiler(int diasAlquiler) {
		this.diasAlquiler = diasAlquiler;
	}
	public int getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public abstract double costoAlquiler();
    
	public String caracterizar() {
		return codigoCliente + "-" + nombreCliente + "-" + diasAlquiler;
    }
}
