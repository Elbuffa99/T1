package Pregunta2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 407, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnProcesar = new JButton("Procesar");
		btnProcesar.setBackground(new Color(102, 204, 255));
		btnProcesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 procesar();
				
			}
		});
		btnProcesar.setBounds(108, 37, 179, 61);
		contentPane.add(btnProcesar);
	}
	 public void procesar() {
	       
	        AlquilerLocalComercial localComercial = new AlquilerLocalComercial(100, "Bastián Suarez", 30, 6, 150);
	     
	       
	        mostrarAlquilerLocal(localComercial);

	       
	        AlquilerAirbnb airbnb = new AlquilerAirbnb(102, "Jesus De Nazaret", 20, 150);
	        
	       
	        mostrarAlquilerAirbnb(airbnb);
	    }

	    public void mostrarAlquilerLocal(AlquilerLocalComercial alquiler) {
	        String mensaje = "Código Cliente: " + alquiler.getCodigoCliente() + "\n" +
	                         "Nombre Cliente: " + alquiler.getNombreCliente() + "\n" +
	                         "Días de Alquiler: " + alquiler.getDiasAlquiler() + "\n" +
	                         "Meses de Alquiler: " + alquiler.getMesesAlquiler() + "\n" +
	                         "Metraje: " + alquiler.getMetraje() + "\n" +
	                         "Costo de Alquiler: S/ " + alquiler.costoAlquiler();

	        JOptionPane.showMessageDialog(this, mensaje, "Alquiler Local Comercial", JOptionPane.INFORMATION_MESSAGE);
	    }

	    public void mostrarAlquilerAirbnb(AlquilerAirbnb alquiler) {
	        String mensaje = "Código Cliente: " + alquiler.getCodigoCliente() + "\n" +
	                         "Nombre Cliente: " + alquiler.getNombreCliente() + "\n" +
	                         "Días de Alquiler: " + alquiler.getDiasAlquiler() + "\n" +
	                         "Tarifa Diaria: S/ " + alquiler.getTarifaDiaria() + "\n" +
	                         "Costo de Alquiler: S/ " + alquiler.costoAlquiler();

	        JOptionPane.showMessageDialog(this, mensaje, "Alquiler Airbnb", JOptionPane.INFORMATION_MESSAGE);
	    }

}
	
