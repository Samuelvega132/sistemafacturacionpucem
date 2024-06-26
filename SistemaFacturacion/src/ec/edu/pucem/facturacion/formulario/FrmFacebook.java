package ec.edu.pucem.facturacion.formulario;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmFacebook extends JInternalFrame {

	private static final long serialVersionUID = 1L;


	public FrmFacebook() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 434, 14);
		getContentPane().add(lblNewLabel);
		
		JButton btnAlerta = new JButton("Alerta");
		btnAlerta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Mensaje", "Titulo", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnAlerta.setBounds(63, 25, 148, 23);
		getContentPane().add(btnAlerta);
		
		JButton btnConfirmacion = new JButton("Confirmacion");
		btnConfirmacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogResult = JOptionPane.showConfirmDialog(null, "Estàs seguro?","Confirme",JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_NO_OPTION) {
					System.out.println("Pulso en SI");
				}else {
					System.out.println("Pulso en NO");

				}
			}
		});
		btnConfirmacion.setBounds(63, 59, 148, 58);
		getContentPane().add(btnConfirmacion);

	}
}
