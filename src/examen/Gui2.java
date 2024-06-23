package examen;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui2 extends JFrame {

	private JPanel btnProcesar;
	private JTextField txtIngreso;
	JTextArea txtResultado;
	ArreglosNota nota =  new ArreglosNota();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui2 frame = new Gui2();
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
	public Gui2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 433);
		btnProcesar = new JPanel();
		btnProcesar.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(btnProcesar);
		btnProcesar.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 151, 722, 232);
		btnProcesar.add(scrollPane);
		
		txtResultado = new JTextArea();
		scrollPane.setViewportView(txtResultado);
		
		JButton btnNewButton = new JButton("Procesar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procesarNotas();
			}
		});
		btnNewButton.setBounds(297, 92, 170, 32);
		btnProcesar.add(btnNewButton);
		
		txtIngreso = new JTextField();
		txtIngreso.setBounds(312, 39, 133, 20);
		btnProcesar.add(txtIngreso);
		txtIngreso.setColumns(10);
	}
	private void procesarNotas() {
        try {
            double notaIngresada = Double.parseDouble(txtIngreso.getText());
            nota.adicionar(notaIngresada);

            double[] notas = nota.getN();
            int tamanio = nota.tamanio();
            int pos = nota.getIndice() - 1;

            double a = nota.posicionPrimeraNotaMayor16();
            double b = nota.sumarNotas();
            double c = nota.retornarNotaMayor();
            boolean reemplazo = nota.reemplazarNota10_5();

            imprimir("La primera nota mayor a 16 es: " + a);
            imprimir("La suma de todas las notas es: " + b);
            imprimir("La nota más alta obtenida es: " + c);

            imprimir("****************************************************");

            for (int i = 0; i < notas.length; i++) {
                imprimir("Nota [" + i + "]: " + notas[i]);
            }

            imprimir("****************************************************");

            if (reemplazo) {
                imprimir("Se reemplazó la primera nota 10.5 por la mayor nota.");
            } else {
                imprimir("No se encontró la nota 10.5 para reemplazar.");
            }

        } catch (NumberFormatException ex) {
            imprimir("Error: Ingrese un número válido para la nota.");
        }
    }
	
	
	public void imprimir (String text) {
		txtResultado.append(text+"\n");
	}
	

}
