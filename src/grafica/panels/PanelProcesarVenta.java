package grafica.panels;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;

import logica.controladores.ControladorProcesarVenta;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;

public class PanelProcesarVenta extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField tfCodVenta;
	private PanelProcesarVenta vista;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public PanelProcesarVenta() throws Exception {
		ControladorProcesarVenta miControlador = new ControladorProcesarVenta(vista);
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
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numVenta = Integer.parseInt(tfCodVenta.getText());
				boolean indicacion = false;
				if(rdbtnConfirmar.isSelected()){
					indicacion = true;
				}
				try {
					miControlador.procesarVenta(numVenta, indicacion);
				}catch(Exception ex) {
					
				}
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
}
