package examen;

public class ArreglosNota {

	private double n[];
	private int indice;
	protected int length;
	
	public ArreglosNota() {
		
		n = new double[5];
		indice =0;
	}
	
	public double[] getN() {
		return n;
	}

	public void setN(double[] n) {
		this.n = n;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}
	
	public int tamanio() {
		return indice;
	}

	private void ampliar() {
		double aux[]=n;
		n = new double[indice+5];
		for (int i = 0; i < aux.length; i++) {
			n[i]=aux[i];
		}
	}
	public void adicionar(double numero) {
		if (indice==n.length) {
			ampliar();
		}
		n[indice]= numero;
		indice ++;
	}
	public double posicionPrimeraNotaMayor16() {
		double nota= 0;
		
		for (int i = 0; i < n.length; i++) {
			if (16 < n[i]) {
				nota = n[i];	
				return nota;
			}
		}
		return -1;
	}
	public double sumarNotas() {
		double suma=0;
		for (int i=0; i<indice; i++)
			suma += n[i];
			return suma; 
	}
	public double retornarNotaMayor() {
		double mayor=0;
		
		for (int i = 0; i < n.length; i++) {
			if (n[i] > mayor) {
				mayor = n[i];	
			}
		}
		return mayor;
	}
	
	
	
	 public boolean reemplazarNota10_5() {
	        double notaMayor = retornarNotaMayor();
	        boolean reemplazado = false;
	        
	        for (int i = 0; i < indice; i++) {
	            if (n[i] == 10.5) {
	                n[i] = notaMayor;
	                reemplazado = true;
	                break;
	            }
	        }
	        
	        return reemplazado;
	 }
	
	 public void incrementarNotaMayor16() {
	        double notaMayor = retornarNotaMayor();
	        
	        for (int i = 0; i < indice; i++) {
	            if (n[i] > 16) {
	                n[i] += notaMayor * 0.20;
	            }
	        }
	    }
	
}
