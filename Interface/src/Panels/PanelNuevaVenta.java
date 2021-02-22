package Panels;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;

public class PanelNuevaVenta extends JPanel {
	private JTextField tfFecha;
	private JTextField tfHora;

	/**
	 * Create the panel.
	 */
	public PanelNuevaVenta() {
		setBorder(new TitledBorder(null, "Datos de la venta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(4, 2, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Fecha");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		add(lblNewLabel);
		
		tfFecha = new JTextField();
		add(tfFecha);
		tfFecha.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Hora");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		add(lblNewLabel_1);
		
		tfHora = new JTextField();
		add(tfHora);
		tfHora.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Direccion de entrega:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		add(lblNewLabel_2);
		
		JTextArea taDirEntrega = new JTextArea();
		add(taDirEntrega);
		
		JButton btnAceptar = new JButton("Aceptar");
		add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		add(btnCancelar);

	}

}
