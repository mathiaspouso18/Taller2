package grafica.panels;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelViandasxVenta extends JPanel {
	private JTextField tfCodVenta;

	/**
	 * Create the panel.
	 */
	public PanelViandasxVenta() {
		setBorder(new TitledBorder(null, "Listado de viandas de una venta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblCodigoDeLa = new JLabel("Codigo de la venta:");
		add(lblCodigoDeLa);
		
		tfCodVenta = new JTextField();
		add(tfCodVenta);
		tfCodVenta.setColumns(10);
		
		JButton btnListar = new JButton("Listar");
		add(btnListar);

	}

}
