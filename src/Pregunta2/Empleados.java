package Pregunta2;

public class Empleados {
	private int codigo;
    private String nombre;
    private String dni;
    private int cantidadVentas;
    private double comisionPorVenta;
    private int estado;
    
    public Empleados(int codigo, String nombre, String dni, int cantidadVentas, double comisionPorVenta, int estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.dni = dni;
        this.cantidadVentas = cantidadVentas;
        this.comisionPorVenta = comisionPorVenta;
        this.estado = estado;
    }

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getCantidadVentas() {
		return cantidadVentas;
	}

	public void setCantidadVentas(int cantidadVentas) {
		this.cantidadVentas = cantidadVentas;
	}

	public double getComisionPorVenta() {
		return comisionPorVenta;
	}

	public void setComisionPorVenta(double comisionPorVenta) {
		this.comisionPorVenta = comisionPorVenta;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
    
	public double sueldoBruto() {
        return this.cantidadVentas * this.comisionPorVenta;
    }
}
