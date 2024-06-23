package examen;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui1 extends JFrame {

	private JPanel contentPane;
	JTextArea txtResultado;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui1 frame = new Gui1();
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
	public Gui1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 93, 343, 157);
		contentPane.add(scrollPane);
		
		txtResultado = new JTextArea();
		scrollPane.setViewportView(txtResultado);
		
		JButton btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Asesor asesor = new Asesor("Bastián",1,70768431,45.50);
			Asesor asesor1 = new Asesor("Alberto",79857465);
			Asesor asesor2 = new Asesor();
			
			listadoAsesor(asesor);
			print("***********************");
			listadoAsesor(asesor1);
			print("***********************");
			listadoAsesor(asesor2);
			print("***********************");
			listadoGeneral(asesor2);
			
			}
		});
		btnProcesar.setBounds(164, 45, 89, 23);
		contentPane.add(btnProcesar);
	}
	public void print(String text) {
		txtResultado.append(text+"\n");
	}
	public void listadoAsesor(Asesor asesor) {
		print("El nombre del asesor es :"+asesor.getNom());
		print("El código del asesor es :"+asesor.getCodigo());
		print("El DNI del asesor es :"+asesor.getDni());
		print("La remuneración en dolares del asesor es :"+asesor.getRemdolar());

	}
	public void listadoGeneral(Asesor asesor) {
		print("La suma de todas las remuneraciones es :"+asesor.getCantRemu());
		print("La cantidad de objetos es "+asesor.getCantAsesor());  
	}
}
