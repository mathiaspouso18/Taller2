package Panels;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.Font;

public class PanelNuevaVianda extends JPanel {
	private JTextField tfCodVianda;
	private JTextField tfPrecio;

	/**
	 * Create the panel.
	 */
	public PanelNuevaVianda() {
		setBorder(new TitledBorder(null, "Nueva vianda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(4, 2, 5, 5));
		
		JLabel lblCodigoDeVianda = new JLabel("Codigo de Vianda:");
		lblCodigoDeVianda.setFont(new Font("Tahoma", Font.BOLD, 13));
		add(lblCodigoDeVianda);
		
		tfCodVianda = new JTextField();
		add(tfCodVianda);
		tfCodVianda.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setFont(new Font("Tahoma", Font.BOLD, 13));
		add(lblDescripcin);
		
		JTextArea taDescripcion = new JTextArea();
		add(taDescripcion);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 13));
		add(lblPrecio);
		
		tfPrecio = new JTextField();
		add(tfPrecio);
		tfPrecio.setColumns(10);
		
		JLabel label = new JLabel("");
		add(label);
		
		JCheckBox chckbxVegana = new JCheckBox("Vegana");
		add(chckbxVegana);

	}

}
