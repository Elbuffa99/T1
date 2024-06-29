package Pregunta2;

import java.util.ArrayList;

public class ArregloPersonas {
	private ArrayList<Empleados> per;
	
	public ArregloPersonas() {
        per = new ArrayList<>();
        
        for (int i = 1; i <= 5; i++) {
            per.add(new Empleados(i, "Nombre" + i, "DNI" + i, 10 * i, 50.0, 1));
        }
	}
	public void adicionar(Empleados emp) {
        per.add(emp);
    }
	
	public int tamaño() {
		return per.size();
	}
	public Empleados obtener(int pos) {
		return per.get(pos);
	}
	public void eliminar(Empleados emp) {
        per.remove(emp);
    }
	 public Empleados buscarPorCodigo(int codigo) {
	        for (Empleados emp : per) {
	            if (emp.getCodigo() == codigo) {
	                return emp;
	            }
	        }
	        return null;
	    }
	 public Empleados buscarPorDni(String dni) {
	        for (Empleados emp : per) {
	            if (emp.getDni().equals(dni)) {
	                return emp;
	            }
	        }
	        return null;
	    }
}
