package grafica.panels;

import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

public class PanelViandasxVenta extends JFrame {
	private JTextField tfCodVenta;
	private JFrame frame;
	private JPanel contentPanel;
	private Toolkit t = Toolkit.getDefaultToolkit();
	JTable table;

	/**
	 * Create the panel.
	 */
	public PanelViandasxVenta() {
		contentPanel = new JPanel();
		contentPanel.setBorder(new TitledBorder(null, "Listado de viandas de una venta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.setLayout(new GridLayout(6, 6, 0, 0));
		setContentPane(contentPanel);
		
		setTitle("Listados");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/3, screenSize.height/3, 800, 300);
		
		JLabel lblCodigoDeLa = new JLabel("Codigo de la venta:");
		contentPanel.add(lblCodigoDeLa);
		
		tfCodVenta = new JTextField();
		contentPanel.add(tfCodVenta);
		tfCodVenta.setColumns(10);
		
		JButton btnListar = new JButton("Listar");
		contentPanel.add(btnListar);
		
		

	}

}
