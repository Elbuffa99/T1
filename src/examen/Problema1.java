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

public class Problema1 extends JFrame {

	private JPanel contentPane;
	JTextArea txtResultado;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problema1 frame = new Problema1();
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
	public Problema1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cilindro cilindro = new Cilindro(10, 20);
				
				listadoCilindro(cilindro);
				
				imprimir("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				
				cilindro.setAltura(cilindro.getAltura()*1.45);
				cilindro.setRadio(cilindro.getRadio()*1.17);
				
				listadoCilindro(cilindro);
			}
		});
		btnProcesar.setBounds(164, 51, 89, 23);
		contentPane.add(btnProcesar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 116, 337, 122);
		contentPane.add(scrollPane);
		
		txtResultado = new JTextArea();
		scrollPane.setViewportView(txtResultado);
	}
	
	public void imprimir(String text) {
		txtResultado.append(text+"\n");
	}
	public void listadoCilindro(Cilindro cilindro) {
		imprimir("El radio es :"+ cilindro.getRadio());
		imprimir("La altura es :"+ cilindro.getAltura());
		imprimir("El volumen es :"+ cilindro.volumenTotal());
	}
}
