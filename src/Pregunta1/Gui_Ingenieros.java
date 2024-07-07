package Pregunta1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Gui_Ingenieros extends JFrame {
	private ArregloIngenieros arregloIngenieros;
	
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField txtHorasTrabajadas;
	private JTextField txtTarifa;
	private JTextArea txtResultados;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_Ingenieros frame = new Gui_Ingenieros();
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
	public Gui_Ingenieros() {
		arregloIngenieros = new ArregloIngenieros();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(234, 46, 117, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(234, 77, 117, 20);
		contentPane.add(txtEdad);
		txtEdad.setColumns(10);
		
		txtHorasTrabajadas = new JTextField();
		txtHorasTrabajadas.setBounds(234, 108, 117, 20);
		contentPane.add(txtHorasTrabajadas);
		txtHorasTrabajadas.setColumns(10);
		
		txtTarifa = new JTextField();
		txtTarifa.setBounds(234, 139, 117, 20);
		contentPane.add(txtTarifa);
		txtTarifa.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Edad");
		lblNewLabel.setBounds(111, 80, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(111, 49, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tarifa");
		lblNewLabel_2.setBounds(111, 142, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Horas Trabajadas");
		lblNewLabel_3.setBounds(111, 108, 179, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnAdicionar = new JButton("Ingreso");
		btnAdicionar.setBackground(Color.GREEN);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    double tarifa = Double.parseDouble(txtTarifa.getText());
                    int edad = Integer.parseInt(txtEdad.getText());
                    String nombre = txtNombre.getText();
                    int horasTrabajadas = Integer.parseInt(txtHorasTrabajadas.getText());

                    Ingeniero ingeniero = new Ingeniero(tarifa, edad, nombre, horasTrabajadas);
                    arregloIngenieros.adicionarIngeniero(ingeniero);

                    txtResultados.append("Ingeniero añadido: " + nombre + "\n");
                } catch (NumberFormatException ex) {
                    txtResultados.append("Error: Por favor ingrese valores válidos.\n");
                }
				
			}
		});
		btnAdicionar.setBounds(424, 48, 89, 23);
		contentPane.add(btnAdicionar);
		
		JButton btnProcesar = new JButton("Procesar");
		btnProcesar.setBackground(new Color(204, 204, 153));
		btnProcesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  double tarifaPromedio = arregloIngenieros.tarifaPromedio();
	                txtResultados.append("Tarifa Promedio de Ingenieros > 40 años: " + tarifaPromedio + "\n");
	          
	                String nombre = arregloIngenieros.nombrePrimerIngenieroMenorQue100();
	                if (nombre != null) {
	                    txtResultados.append("Primer Ingeniero con < 100 horas: " + nombre + "\n");
	                } else {
	                    txtResultados.append("No se encontró un ingeniero con < 100 horas.\n");
	                }
				
			}
		});
		btnProcesar.setBounds(424, 136, 89, 23);
		contentPane.add(btnProcesar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 215, 499, 173);
		contentPane.add(scrollPane);
		
		txtResultados = new JTextArea();
		scrollPane.setViewportView(txtResultados);
	}
		
	}

