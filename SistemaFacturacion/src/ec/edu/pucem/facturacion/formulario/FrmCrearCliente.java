package ec.edu.pucem.facturacion.formulario;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ec.edu.pucem.facturacion.dominio.Cliente;
import ec.edu.pucem.facturacion.dominio.ListaCliente;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FrmCrearCliente extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtcedula;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDireccion;
	private JTextField txtCelular;
	private JTextField txtEmail;
	private JTable table;
	private DefaultTableModel model;
	private Cliente cliente;
	private ListaCliente listacliente;
	private boolean Duplicado = false; 
	
	public FrmCrearCliente (ListaCliente listacliente) {
		this.listacliente = listacliente;
		FrmCrearClientes ();
	}


	public void FrmCrearClientes() {
		setTitle("Crear Usuario");
		setBounds(100, 100, 408, 464);
		setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cedula:");
		lblNewLabel.setBounds(24, 11, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres:");
		lblNewLabel_1.setBounds(24, 36, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos:");
		lblNewLabel_2.setBounds(24, 61, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Direccion:");
		lblNewLabel_3.setBounds(24, 86, 60, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Celular:");
		lblNewLabel_4.setBounds(24, 111, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("E-mail");
		lblNewLabel_5.setBounds(24, 136, 46, 14);
		getContentPane().add(lblNewLabel_5);
		
		txtcedula = new JTextField();
		txtcedula.setBounds(91, 8, 86, 20);
		getContentPane().add(txtcedula);
		txtcedula.setColumns(10);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(91, 33, 290, 20);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(91, 58, 290, 20);
		getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(91, 83, 290, 20);
		getContentPane().add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(91, 108, 86, 20);
		getContentPane().add(txtCelular);
		txtCelular.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(91, 133, 168, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnNewButton = new JButton("Nuevo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtcedula.setText("");
				txtNombres.setText("");
				txtApellidos.setText("");
				txtDireccion.setText("");
				txtCelular.setText("");
				txtEmail.setText("");
			}
		});
		btnNewButton.setBounds(10, 176, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearCliente();
				listacliente.agregarCliente(cliente);
			}

			
		});
		btnGuardar.setBounds(109, 176, 89, 23);
		getContentPane().add(btnGuardar);
		
		JButton btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Duplicado = false;
				dispose();
			}
		});
		btnNewButton_2.setBounds(208, 176, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 210, 316, 163);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cedula", "Nombres", "Apellidos"
			}
		));
		scrollPane.setViewportView(table);
		model = (DefaultTableModel) table.getModel();

	}
	private void crearCliente() {
		cliente =new Cliente();
		cliente.setCedula(this.txtcedula.getText());
		cliente.setNombres(this.txtNombres.getText());
		cliente.setApellidos(this.txtApellidos.getText());
		cliente.setDireccion(this.txtDireccion.getText());
		cliente.setCelular(this.txtCelular.getText());
		cliente.setEmail(this.txtEmail.getText());
		agregarFila();
				
	}
	private void agregarFila() {
		Object[] fila= new Object [3];
		fila[0] = cliente.getCedula();
		fila[1] = cliente.getNombres();
		fila[2] = cliente.getApellidos();
		model.addRow(fila);

	}
}
