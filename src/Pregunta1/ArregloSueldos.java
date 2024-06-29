package Pregunta1;

public class ArregloSueldos {
  
	private double sueldo[];
    private int indice;

    public ArregloSueldos() {
        sueldo = new double[10];
        indice = 0;
    }

    public double[] getSueldo() {
		return sueldo;
	}

	public void setSueldo(double[] sueldo) {
		this.sueldo = sueldo;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public int tamaño() {
        return indice;
    }

    public double obtener(int p) {
        return sueldo[p];
    }

    public void adicionar(double s) {
        if (indice == tamaño())
            ampliarArreglo();
        sueldo[indice] = s;
        indice++;
    }

    private void ampliarArreglo() {
        double aux[] = sueldo;
        sueldo = new double[indice + 10];
        for (int i = 0; i < indice; i++)
            sueldo[i] = aux[i];
    }
    
    public void eliminarTodo() {
        indice = 0;
    }

    public void eliminarFinal() {
        indice--;
    }
    
    //Metodo para retornar primer sueldo menor a 1000
    public int posicionPrimerSueldoMenorQue1000() {
        for (int i = 0; i < indice; i++) {
            if (sueldo[i] < 1000) {
                return i;
            }
        }
        return -1; // Si no se encuentra ningún sueldo menor a 1000
    }
    
    public double sueldoMayor() {
    	double sMayor = 0;
    	for (int i = 0; i < indice; i++) {
			if (sueldo[i] > sMayor) {
				sMayor = sueldo[i];
			}
		}
    	return sMayor;
    }
    
    public boolean reemplazarPrimerSueldoMenorQue950() {
    	double SMayor = sueldoMayor();
    	boolean reemplazar = false;
    	
    	for (int i = 0; i < indice; i++) {
			if(sueldo[i] < 950) {
				sueldo[i] = SMayor;
				reemplazar = true;
				break;
			}
		}
    	return reemplazar;
    }
}
