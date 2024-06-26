package ec.edu.pucem.facturacion.formulario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ec.edu.pucem.facturacion.dominio.ListaCliente;
import ec.edu.pucem.facturacion.dominio.ListaProducto;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.CardLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
public class FrmMenuPrincipal extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JDesktopPane desktopPane;
    private ListaCliente listacliente = new ListaCliente();
    private ListaProducto listaproducto = new ListaProducto();
    private FrmCrearCliente frmcrearcliente;
    private FrmListaClientes frmlistacliente;
    private FrmListaProductos frmlistaproductos;
    private FrmCrearProducto frmcrearproducto;
    private FrmCrearFactura frmcrearfactura;

    public FrmMenuPrincipal() {
        setTitle("Sistema de Facturacion Electronica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 999, 767);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnArchivo = new JMenu("Archivo");
        mnArchivo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuBar.add(mnArchivo);

        JMenuItem mntmSalir = new JMenuItem("Salir");
        mntmSalir.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/ec/edu/pucem/facturacion/imagen/exit.png")));
        mntmSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mntmSalir.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        mnArchivo.add(mntmSalir);

        JMenu mnClientes = new JMenu("Clientes");
        mnClientes.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuBar.add(mnClientes);

        JMenuItem mntmCrearNuevo = new JMenuItem("Crear Nuevo");
        mntmCrearNuevo.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/ec/edu/pucem/facturacion/imagen/crear.png")));
        mntmCrearNuevo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                if (frmcrearcliente == null || !frmcrearcliente.isVisible()) {
                    frmcrearcliente = new FrmCrearCliente(listacliente);
                    desktopPane.add(frmcrearcliente);
                    frmcrearcliente.setVisible(true);
                } else {
                    frmcrearcliente.requestFocus();
                }
            }
        });

        mnClientes.add(mntmCrearNuevo);
        
        

        JMenuItem mntmListaClientes = new JMenuItem("Lista de Clientes");
        mntmListaClientes.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/ec/edu/pucem/facturacion/imagen/lista.png")));
        mntmListaClientes.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                if (frmlistacliente == null || !frmlistacliente.isVisible()) {
                    frmlistacliente = new FrmListaClientes(listacliente);
                    desktopPane.add(frmlistacliente);
                    frmlistacliente.setVisible(true);
                } else {
                    frmlistacliente.requestFocus();
                }
            }
        });
        mnClientes.add(mntmListaClientes);

        JMenu mnFacturas = new JMenu("Facturas");
        mnFacturas.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuBar.add(mnFacturas);

        JMenuItem mntmNuevaFactura = new JMenuItem("Nueva Factura");
        mntmNuevaFactura.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/ec/edu/pucem/facturacion/imagen/factura.png")));
        mntmNuevaFactura.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                if (frmcrearfactura == null || !frmcrearfactura.isVisible()) {
                    frmcrearfactura = new FrmCrearFactura(listacliente.getListaClientes(), listaproducto.getListaProductos());
                    desktopPane.add(frmcrearfactura);
                    frmcrearfactura.setVisible(true);
                } else {
                    frmcrearfactura.requestFocus();
                }
            }
        });
        mnFacturas.add(mntmNuevaFactura);

        JMenu mnProductos = new JMenu("Productos");
        mnProductos.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuBar.add(mnProductos);

        JMenuItem mntmNewMenuItem = new JMenuItem("Nuevo Producto");
        mntmNewMenuItem.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/ec/edu/pucem/facturacion/imagen/producto.png")));
        mntmNewMenuItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                if (frmcrearproducto == null || !frmcrearproducto.isVisible()) {
                    frmcrearproducto = new FrmCrearProducto(listaproducto);
                    desktopPane.add(frmcrearproducto);
                    frmcrearproducto.setVisible(true);
                } else {
                    frmcrearproducto.requestFocus();
                }
            }
        });
        mnProductos.add(mntmNewMenuItem);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Lista productos");
        mntmNewMenuItem_1.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/ec/edu/pucem/facturacion/imagen/lista.png")));
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                if (frmlistaproductos == null || !frmlistaproductos.isVisible()) {
                    frmlistaproductos = new FrmListaProductos(listaproducto);
                    desktopPane.add(frmlistaproductos);
                    frmlistaproductos.setVisible(true);
                } else {
                    frmlistaproductos.requestFocus();
                }
            }
        });
        mnProductos.add(mntmNewMenuItem_1);

        JMenu mnRedes = new JMenu("Redes");
        mnRedes.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuBar.add(mnRedes);

        JMenuItem mntmFacebook = new JMenuItem("Facebook");
        mntmFacebook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrmFacebook frmfacebook = new FrmFacebook();
                frmfacebook.setVisible(true);
                desktopPane.add(frmfacebook);
            }
        });
        mntmFacebook.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        mntmFacebook.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/ec/edu/pucem/facturacion/imagen/facebook.png")));
        mnRedes.add(mntmFacebook);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout(0, 0));

        desktopPane = new JDesktopPane();
        contentPane.add(desktopPane, "name_7123010558300");
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmMenuPrincipal frame = new FrmMenuPrincipal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}