package Panels;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class PanelIngresoVianda extends JPanel {
	private JTextField tfCodVianda;
	private JTextField tfCant;
	private JTextField tfCodVenta;

	/**
	 * Create the panel.
	 */
	public PanelIngresoVianda() {
		setBorder(new TitledBorder(null, "Ingreso de viandas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(4, 2, 5, 5));
		
		JLabel lblCodigoDeVianda = new JLabel("Codigo de vianda:");
		lblCodigoDeVianda.setFont(new Font("Tahoma", Font.BOLD, 13));
		add(lblCodigoDeVianda);
		
		tfCodVianda = new JTextField();
		add(tfCodVianda);
		tfCodVianda.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 13));
		add(lblCantidad);
		
		tfCant = new JTextField();
		add(tfCant);
		tfCant.setColumns(10);
		
		JLabel lblCodigoDeVenta = new JLabel("Codigo de venta:");
		lblCodigoDeVenta.setFont(new Font("Tahoma", Font.BOLD, 13));
		add(lblCodigoDeVenta);
		
		tfCodVenta = new JTextField();
		add(tfCodVenta);
		tfCodVenta.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		add(btnAgregar);
		
		JButton btnCancelar = new JButton("Cancelar");
		add(btnCancelar);

	}

}
