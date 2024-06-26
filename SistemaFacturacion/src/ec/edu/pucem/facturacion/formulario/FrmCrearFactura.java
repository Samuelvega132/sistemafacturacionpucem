package ec.edu.pucem.facturacion.formulario;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ec.edu.pucem.facturacion.dominio.Cliente;
import ec.edu.pucem.facturacion.dominio.ListaCliente;
import ec.edu.pucem.facturacion.dominio.ListaProducto;
import ec.edu.pucem.facturacion.dominio.Producto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FrmCrearFactura extends JInternalFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtCantidad;
    private JTable table;
    private DefaultTableModel model;
    private JComboBox<Cliente> cmbClientes;
    private JComboBox<Producto> cmbProductos;
    private JLabel lblSubtotal, lblIVA, lblTotal;
    private List<Cliente> clientes;
    private List<Producto> productos;
	private boolean Duplicado = false; 


    public FrmCrearFactura(List<Cliente> clientes, List<Producto> productos) {
        this.clientes = clientes;
        this.productos = productos;

        setTitle("Crear Factura");
        setBounds(100, 100, 684, 600);
        getContentPane().setLayout(null);

        JLabel lblCliente = new JLabel("Cliente:");
        lblCliente.setBounds(24, 59, 60, 14);
        getContentPane().add(lblCliente);

        cmbClientes = new JComboBox<>();
        for (Cliente cliente : clientes) {
            cmbClientes.addItem(cliente);
        }
        cmbClientes.setBounds(90, 56, 300, 20);
        getContentPane().add(cmbClientes);

        JLabel lblProducto = new JLabel("Producto:");
        lblProducto.setBounds(24, 89, 60, 14);
        getContentPane().add(lblProducto);

        cmbProductos = new JComboBox<>();
        for (Producto producto : productos) {
            cmbProductos.addItem(producto);
        }
        cmbProductos.setBounds(90, 86, 300, 20);
        getContentPane().add(cmbProductos);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(439, 70, 60, 14);
        getContentPane().add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(499, 68, 60, 20);
        getContentPane().add(txtCantidad);
        txtCantidad.setColumns(10);

        JButton btnAgregarProducto = new JButton("Agregar");
        btnAgregarProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarProducto();
            }
        });
        btnAgregarProducto.setBounds(470, 102, 89, 23);
        getContentPane().add(btnAgregarProducto);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(24, 135, 600, 200);
        getContentPane().add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Producto", "Cantidad", "Precio Unitario", "Total"}
        ));
        scrollPane.setViewportView(table);

        lblSubtotal = new JLabel("Subtotal: $0.00");
        lblSubtotal.setBounds(424, 356, 180, 14);
        getContentPane().add(lblSubtotal);

        lblIVA = new JLabel("IVA: $0.00");
        lblIVA.setBounds(424, 380, 180, 14);
        getContentPane().add(lblIVA);

        lblTotal = new JLabel("Total: $0.00");
        lblTotal.setBounds(424, 404, 180, 14);
        getContentPane().add(lblTotal);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarFactura();
            }
        });
        btnGuardar.setBounds(150, 400, 89, 23);
        getContentPane().add(btnGuardar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Duplicado = false;
                dispose();
            }
        });
        btnCancelar.setBounds(275, 400, 89, 23);
        getContentPane().add(btnCancelar);
        
        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                limpiarFormulario();
        	}
        });
        btnLimpiar.setVerticalAlignment(SwingConstants.TOP);
        btnLimpiar.setBounds(24, 401, 89, 23);
        getContentPane().add(btnLimpiar);
    }

    private void agregarProducto() {
        Producto producto = (Producto) cmbProductos.getSelectedItem();
        int cantidad = Integer.parseInt(txtCantidad.getText());
        float precio = producto.getPrecio();
        float total = cantidad * precio;

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[]{producto.getNombre(), cantidad, precio, total});

        calcularTotales();
    }

    private void calcularTotales() {
        float subtotal = 0;
        for (int i = 0; i < table.getRowCount(); i++) {
            subtotal += (float) table.getValueAt(i, 3);
        }
        float iva = subtotal * 0.12f;
        float total = subtotal + iva;

        lblSubtotal.setText("Subtotal: $" + String.format("%.2f", subtotal));
        lblIVA.setText("IVA: $" + String.format("%.2f", iva));
        lblTotal.setText("Total: $" + String.format("%.2f", total));
    }

    private void guardarFactura() {
        JOptionPane.showMessageDialog(this, "Factura guardada exitosamente");
        limpiarFormulario();
    }

    private void limpiarFormulario() {
        cmbClientes.setSelectedIndex(0);
        cmbProductos.setSelectedIndex(0);
        txtCantidad.setText("");
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        lblSubtotal.setText("Subtotal: $0.00");
        lblIVA.setText("IVA: $0.00");
        lblTotal.setText("Total: $0.00");
    }
    
}