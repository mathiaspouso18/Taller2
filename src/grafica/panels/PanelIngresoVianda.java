package grafica.panels;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Font;
import logica.controladores.ControladorIngresoVianda;

public class PanelIngresoVianda extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField tfCodVianda;
	private JTextField tfCant;
	private JTextField tfCodVenta;
	private JPanel contentPanel;
	private PanelIngresoVianda vista;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public PanelIngresoVianda() throws Exception {
		ControladorIngresoVianda miControlador = new ControladorIngresoVianda(vista);
		contentPanel = new JPanel();
		contentPanel.setBorder(new TitledBorder(null, "Ingreso de viandas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPanel);
		contentPanel.setLayout(new GridLayout(4, 2, 5, 5));
		
		setResizable(false);
		setTitle("Registrar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/3, screenSize.height/3, 350, 238);
		
		JLabel lblCodigoDeVianda = new JLabel("Codigo de vianda:");
		lblCodigoDeVianda.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblCodigoDeVianda);
		
		tfCodVianda = new JTextField();
		contentPanel.add(tfCodVianda);
		tfCodVianda.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblCantidad);
		
		tfCant = new JTextField();
		contentPanel.add(tfCant);
		tfCant.setColumns(10);
		
		JLabel lblCodigoDeVenta = new JLabel("Codigo de venta:");
		lblCodigoDeVenta.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblCodigoDeVenta);
		
		tfCodVenta = new JTextField();
		contentPanel.add(tfCodVenta);
		tfCodVenta.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		contentPanel.add(btnAgregar);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codVianda = tfCodVianda.getText();
				int cant = Integer.parseInt(tfCant.getText());
				int numVenta = Integer.parseInt(tfCodVenta.getText());
				try {
					miControlador.ingresoVianda(codVianda, cant, numVenta);
				}catch(Exception ex) {
					
				}
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		contentPanel.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

	}
}
