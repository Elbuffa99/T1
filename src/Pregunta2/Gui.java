package Pregunta2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Pregunta2.Empleados;
import Pregunta2.ArregloPersonas;
import java.awt.Color;

public class Gui extends JFrame {
    private JPanel contentPane;
    private JTextField txtCodigo, txtNombre, txtDni, txtCantidadVentas, txtComisionPorVenta, txtEstado;
    private JTextArea textArea;
    private ArregloPersonas ae = new ArregloPersonas();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Gui frame = new Gui();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Gui() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Labels and TextFields
        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(30, 30, 100, 25);
        contentPane.add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(150, 30, 200, 25);
        contentPane.add(txtCodigo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 70, 100, 25);
        contentPane.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(150, 70, 200, 25);
        contentPane.add(txtNombre);

        JLabel lblDni = new JLabel("DNI:");
        lblDni.setBounds(30, 110, 100, 25);
        contentPane.add(lblDni);

        txtDni = new JTextField();
        txtDni.setBounds(150, 110, 200, 25);
        contentPane.add(txtDni);

        JLabel lblCantidadVentas = new JLabel("Cantidad Ventas:");
        lblCantidadVentas.setBounds(30, 150, 100, 25);
        contentPane.add(lblCantidadVentas);

        txtCantidadVentas = new JTextField();
        txtCantidadVentas.setBounds(150, 150, 200, 25);
        contentPane.add(txtCantidadVentas);

        JLabel lblComisionPorVenta = new JLabel("Comisión por Venta:");
        lblComisionPorVenta.setBounds(30, 190, 150, 25);
        contentPane.add(lblComisionPorVenta);

        txtComisionPorVenta = new JTextField();
        txtComisionPorVenta.setBounds(150, 190, 200, 25);
        contentPane.add(txtComisionPorVenta);

        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setBounds(30, 230, 100, 25);
        contentPane.add(lblEstado);

        txtEstado = new JTextField();
        txtEstado.setBounds(150, 230, 200, 25);
        contentPane.add(txtEstado);

        // TextArea
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 310, 600, 100);
        contentPane.add(scrollPane);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        // Buttons
        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.setBackground(new Color(224, 255, 255));
        btnAdicionar.setBounds(400, 30, 120, 25);
        contentPane.add(btnAdicionar);
        btnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarEmpleado();
            }
        });

        JButton btnConsultar = new JButton("Consultar");
        btnConsultar.setBackground(new Color(152, 251, 152));
        btnConsultar.setBounds(530, 30, 120, 25);
        contentPane.add(btnConsultar);
        btnConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                consultarEmpleado();
            }
        });

        JButton btnModificar = new JButton("Modificar");
        btnModificar.setBackground(new Color(100, 149, 237));
        btnModificar.setBounds(400, 70, 120, 25);
        contentPane.add(btnModificar);
        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarEmpleado();
            }
        });

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBackground(new Color(255, 0, 0));
        btnEliminar.setBounds(530, 70, 120, 25);
        contentPane.add(btnEliminar);
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarEmpleado();
            }
        });
    }

    private void adicionarEmpleado() {
        try {
            int codigo = Integer.parseInt(txtCodigo.getText());
            String nombre = txtNombre.getText();
            String dni = txtDni.getText();
            int cantidadVentas = Integer.parseInt(txtCantidadVentas.getText());
            double comisionPorVenta = Double.parseDouble(txtComisionPorVenta.getText());
            int estado = Integer.parseInt(txtEstado.getText());

            Empleados empleadocodigo = ae.buscarPorCodigo(codigo);
            
            if (empleadocodigo != null) {
                textArea.setText("El empleado con código " + codigo + " ya existe.");
                return;
            }
            Empleados empleadodni = ae.buscarPorDni(dni);
            if (empleadodni != null) {
            	textArea.setText("El empleado con dni " + dni + " ya existe.");
                return;
            }

            Empleados nuevoEmpleado = new Empleados(codigo, nombre, dni, cantidadVentas, comisionPorVenta, estado);
            ae.adicionar(nuevoEmpleado);
            textArea.setText("Empleado añadido con éxito.");
        } catch (NumberFormatException ex) {
            textArea.setText("Ingrese valores válidos en todos los campos.");
        }
    }

    private void consultarEmpleado() {
        String dni = txtDni.getText();
        Empleados empleado = ae.buscarPorDni(dni);
        if (empleado != null) {
            textArea.setText("Empleado encontrado:\n" +
                    "Código: " + empleado.getCodigo() + "\n" +
                    "Nombre: " + empleado.getNombre() + "\n" +
                    "DNI: " + empleado.getDni() + "\n" +
                    "Cantidad de Ventas: " + empleado.getCantidadVentas() + "\n" +
                    "Comisión por Venta: " + empleado.getComisionPorVenta() + "\n" +
                    "Estado: " + empleado.getEstado() + "\n" +
                    "Sueldo Bruto: " + empleado.sueldoBruto());
        } else {
            textArea.setText("Empleado con DNI " + dni + " no encontrado.");
        }
    }

    private void modificarEmpleado() {
        String dni = txtDni.getText();
        Empleados empleado = ae.buscarPorDni(dni);
        if (empleado != null) {
            try {
                int cantidadVentas = Integer.parseInt(txtCantidadVentas.getText());
                double comisionPorVenta = Double.parseDouble(txtComisionPorVenta.getText());
                int estado = Integer.parseInt(txtEstado.getText());

                empleado.setCantidadVentas(cantidadVentas);
                empleado.setComisionPorVenta(comisionPorVenta);
                empleado.setEstado(estado);

                textArea.setText("Empleado modificado con éxito:\n" +
                        "Código: " + empleado.getCodigo() + "\n" +
                        "Nombre: " + empleado.getNombre() + "\n" +
                        "DNI: " + empleado.getDni() + "\n" +
                        "Cantidad de Ventas: " + empleado.getCantidadVentas() + "\n" +
                        "Comisión por Venta: " + empleado.getComisionPorVenta() + "\n" +
                        "Estado: " + empleado.getEstado() + "\n" +
                        "Sueldo Bruto: " + empleado.sueldoBruto());
            } catch (NumberFormatException ex) {
                textArea.setText("Ingrese valores válidos en los campos de cantidad de ventas, comisión por venta y estado.");
            }
        } else {
            textArea.setText("Empleado con DNI " + dni + " no encontrado.");
        }
    }

    private void eliminarEmpleado() {
        String dni = txtDni.getText();
        Empleados empleado = ae.buscarPorDni(dni);
        if (empleado != null) {
            ae.eliminar(empleado);
            textArea.setText("Empleado eliminado con éxito.");
        } else {
            textArea.setText("Empleado con DNI " + dni + " no encontrado.");
        }
    }
}
                   
