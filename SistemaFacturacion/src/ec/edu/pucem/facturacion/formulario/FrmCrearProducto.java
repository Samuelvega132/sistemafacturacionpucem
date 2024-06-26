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
import ec.edu.pucem.facturacion.dominio.ListaProducto;
import ec.edu.pucem.facturacion.dominio.Producto;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FrmCrearProducto extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtnombre;
	private JTextField txtprecio;
	private JTable table;
	private DefaultTableModel model;
	private Producto producto;
	private ListaProducto listaproducto;
	private boolean Duplicado = false; 

	
	public FrmCrearProducto (ListaProducto listaproducto) {
		this.listaproducto = listaproducto;
		FrmCrearProductos ();
	}


	public void FrmCrearProductos() {
		setTitle("Crear Producto");
		setBounds(100, 100, 408, 464);
		setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(24, 42, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Precio:");
		lblNewLabel_1.setBounds(24, 85, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(91, 40, 245, 20);
		getContentPane().add(txtnombre);
		txtnombre.setColumns(10);
		
		txtprecio = new JTextField();
		txtprecio.setBounds(91, 79, 89, 20);
		getContentPane().add(txtprecio);
		txtprecio.setColumns(10);
		
				
		JButton btnNewButton = new JButton("Nuevo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtnombre.setText("");
				txtprecio.setText("");
			}
		});
		btnNewButton.setBounds(10, 176, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearProducto();
				listaproducto.agregarProducto(producto);
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
				"Nombre", "Precio"
			}
		));
		scrollPane.setViewportView(table);
		model = (DefaultTableModel) table.getModel();

	}
	private void crearProducto() {
		producto =new Producto();
		producto.setNombre(this.txtnombre.getText());
		producto.setPrecio(this.txtprecio.getText());
		
		agregarFila();
				
	}
	private void agregarFila() {
		Object[] fila= new Object [3];
		fila[0] = producto.getNombre();
		fila[1] = producto.getPrecio();
		model.addRow(fila);

	}
}
