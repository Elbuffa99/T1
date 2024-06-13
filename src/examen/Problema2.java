package examen;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Problema2 extends JFrame {

	private JPanel btnProcesar;
	JTextArea txtResultado;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problema2 frame = new Problema2();
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
	public Problema2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		btnProcesar = new JPanel();
		btnProcesar.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(btnProcesar);
		btnProcesar.setLayout(null);
		
		JButton btnNewButton = new JButton("Procesar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medico medico = new Medico(2,20.0,5);
				listadoMedico( medico);
				imprimir("!!!!!!!!!!!!!!!!!!!!!!!!");
				listadoGeneral( medico);
			}
		});
		btnNewButton.setBounds(174, 53, 89, 23);
		btnProcesar.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 100, 372, 150);
		btnProcesar.add(scrollPane);
		
		txtResultado = new JTextArea();
		scrollPane.setViewportView(txtResultado);
	}
	public void imprimir(String text) {
		txtResultado.append(text+"\n");
	}
	public void listadoMedico(Medico medico) {
		imprimir("El código es "+medico.getCodigo());
		imprimir("La tarifa por consulta es "+medico.getTarifa());
		imprimir("El número de consultas es "+medico.getConsultas());
		imprimir("El ingreso bruto es "+medico.ingresoBruto());
		imprimir("El descuento es "+medico.descuento());
		imprimir("El sueldo neto es "+medico.ingresoNeto());
	}
	public void listadoGeneral(Medico medico) {
		imprimir("El ingreso acumulado es "+medico.getIngresoNeto());
		
	}

}
