package grafica.panels;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;

public class PanelProcesarVenta extends JPanel {
	private JTextField tfCodVenta;

	/**
	 * Create the panel.
	 */
	public PanelProcesarVenta() {
		setBorder(new TitledBorder(null, "Procesar venta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(4, 2, 5, 5));
		
		JLabel lblCodigoDeVenta = new JLabel("Codigo de venta:");
		lblCodigoDeVenta.setFont(new Font("Tahoma", Font.BOLD, 13));
		add(lblCodigoDeVenta);
		
		tfCodVenta = new JTextField();
		add(tfCodVenta);
		tfCodVenta.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 13));
		add(lblEstado);
		
		JRadioButton rdbtnConfirmar = new JRadioButton("Confirmar");
		add(rdbtnConfirmar);
		
		JLabel label = new JLabel("");
		add(label);
		
		JRadioButton rdbtnCancelar = new JRadioButton("Cancelar");
		add(rdbtnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		add(btnCancelar);

	}

}
