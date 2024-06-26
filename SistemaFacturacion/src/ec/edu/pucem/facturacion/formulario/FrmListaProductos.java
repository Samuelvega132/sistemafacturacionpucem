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
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class FrmListaProductos extends JInternalFrame {
    private static final long serialVersionUID = 1L;
    private JTable table;
    private DefaultTableModel model;
    private ListaProducto listaProducto;
	private boolean Duplicado = false; 

    

    public FrmListaProductos(ListaProducto listaProducto) {
        this.listaProducto = listaProducto;

        setTitle("Lista de Productos");
        setBounds(100, 100, 600, 400);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        Duplicado = false;

        JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        model = new DefaultTableModel(
            new Object[][] {},
            new String[] { "Nombre", "Precio" }
        );
        table.setModel(model);
        scrollPane.setViewportView(table);

        cargarDatosProductos();
    }

    private void cargarDatosProductos() {
        model.setRowCount(0);
        List<Producto> productos = listaProducto.getListaProductos();
        for (Producto producto : productos) {
            model.addRow(new Object[] {
                producto.getNombre(), 
                producto.getPrecio(), 
                
            });
        }
    }
}
