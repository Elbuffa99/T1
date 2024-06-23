package examen;

public class Asesor {

	private String nom;
	private int codigo;
	private int dni;
	private double Remdolar;
	
	private static int cantAsesor = 0;
	private static double cantRemu=0;
	public static final String Inst = "Cibertec";

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public double getRemdolar() {
		return Remdolar;
	}

	public void setRemdolar(double remdolar) {
		Remdolar = remdolar;
	}

	public static int getCantAsesor() {
		return cantAsesor;
	}

	public static void setCantAsesor(int cantAsesor) {
		Asesor.cantAsesor = cantAsesor;
	}

	public static double getCantRemu() {
		return cantRemu;
	}

	public static void setCantRemu(double cantRemu) {
		Asesor.cantRemu = cantRemu;
	}

	public static String getInst() {
		return Inst;
	}

	
	public Asesor(String nom, int codigo,int dni, double Remdolar) {
		this.nom = nom;
		this.codigo = codigo;
		this.dni = dni;
		this.Remdolar = Remdolar;
		
		cantAsesor++;
		cantRemu+=Remdolar;
	}
	
	public Asesor(String nom,int dni) {
	this(nom,55555,dni,2000.0);
	this.nom = nom;
	this.dni = dni;
	}
	
	public Asesor() {
		this("NN",88888888);
	}
	
	
}
