package examen;

public class Medico {
	private int codigo;
	private double tarifa;
	private int consultas;
	
	private static double ingresoNeto=0.0;
	
	public final static double desc = 0.12;

	/**
	 * 
	 */
	public Medico(int codigo, double tarifa, int consultas) {
		this.codigo = codigo;
		this.tarifa = tarifa;
		this.consultas = consultas;
		ingresoNeto = ingresoNeto + ingresoNeto();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getTarifa() {
		return tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}

	public int getConsultas() {
		return consultas;
	}

	public void setConsultas(int consultas) {
		this.consultas = consultas;
	}

	public static double getIngresoNeto() {
		return ingresoNeto;
	}

	public static void setIngresoNeto(double ingresoNeto) {
		Medico.ingresoNeto = ingresoNeto;
	}
	
	public double ingresoBruto() {
		return tarifa*consultas;
	}
	public double descuento() {
		return ingresoBruto()*desc;
	}
	public double ingresoNeto() {
		return ingresoBruto() - descuento();
	}
}
