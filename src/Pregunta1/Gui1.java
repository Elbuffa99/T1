package Pregunta1;

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

public class Gui1 extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    ArregloSueldos sueldo = new ArregloSueldos();
    JTextArea textArea;

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

    public Gui1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 617, 437);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(58, 185, 463, 202);
        contentPane.add(scrollPane);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarSueldo();
            }
        });
        btnAgregar.setBounds(151, 133, 89, 23);
        contentPane.add(btnAgregar);

        JButton btnListar = new JButton("Listar");
        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarSueldos();
            }
        });
        btnListar.setBounds(250, 133, 89, 23);
        contentPane.add(btnListar);

        JButton btnReemplazar = new JButton("Reemplazar");
        btnReemplazar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reemplazarSueldo();
            }
        });
        btnReemplazar.setBounds(349, 133, 120, 23);
        contentPane.add(btnReemplazar);

        textField = new JTextField();
        textField.setBounds(247, 72, 86, 20);
        contentPane.add(textField);
        textField.setColumns(10);
    }

    private void agregarSueldo() {
        try {
            double sueldoIngresado = Double.parseDouble(textField.getText());
            sueldo.adicionar(sueldoIngresado);
            imprimir("");
            imprimir("Sueldo agregado: " + sueldoIngresado);
            
        } catch (NumberFormatException ex) {
            textArea.setText("Ingrese un número válido.");
        }
    }

    private void listarSueldos() {
   
        double[] sueldos = sueldo.getSueldo();
        int cantidad = sueldo.tamaño();

        imprimir("Sueldos:\n");
        for (int i = 0; i < cantidad; i++) {
        	imprimir("sueldos [" + i + "]: " + sueldos[i]);
         
        }

        imprimir("Cantidad de valores registrados: "+cantidad+"\n");

        int posicion = sueldo.posicionPrimerSueldoMenorQue1000();
        if (posicion == -1) {
        	imprimir("No existe sueldo menor a 1000\n");
        } else {
        	imprimir("Posición del primer sueldo menor a 1000: "+posicion+"\n");
        }

        imprimir("Sueldo mayor: "+sueldo.sueldoMayor()+"\n");


    }

    private void reemplazarSueldo() {
        boolean reemplazado = sueldo.reemplazarPrimerSueldoMenorQue950();
        if (reemplazado) {
            listarSueldos();
        } else {
        	imprimir("No existe ningún sueldo menor que 950.");
        }
    }

    public void imprimir(String text) {
        textArea.append(text + "\n");
    }
}
