package examen;

public class Cilindro {
	
	private double radio;
	private double altura;
	static double pi = 3.1416;
	/**
	 * 
	 */
	public Cilindro(double radio, double altura) {
		this.altura = altura;
		this.radio = radio;	
	}
	public double getRadio() {
		return radio;
	}
	public void setRadio(double radio) {
		this.radio = radio;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public double volumenTotal() {
		return 2*pi*radio*(radio+altura);
	}
	
}
