package grafica.panels;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;

import logica.controladores.ControladorEliminarVianda;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class PanelEliminarVianda extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField tfCodVianda;
	private JTextField tfCant;
	private JTextField tfCodVenta;
	private JPanel contentPanel;
	private PanelEliminarVianda vista;
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public PanelEliminarVianda() throws Exception {
		
		ControladorEliminarVianda miControlador = new ControladorEliminarVianda(vista);
		
		contentPanel = new JPanel();
		contentPanel.setBorder(new TitledBorder(null, "Eliminar una vianda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		setResizable(false);
		setTitle("Registrar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/3, screenSize.height/3, 350, 238);
		
		JLabel lblCodigoDeVianda = new JLabel("Código");
		lblCodigoDeVianda.setForeground(Color.BLACK);
		lblCodigoDeVianda.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCodigoDeVianda.setHorizontalAlignment(SwingConstants.LEADING);
		lblCodigoDeVianda.setBounds(10, 13, 70, 40);
		contentPanel.add(lblCodigoDeVianda);
		
		JTextField tfCodVianda = new JTextField();
		tfCodVianda.setColumns(10);
		tfCodVianda.setBounds(140, 25, 150, 20);
		contentPanel.add(tfCodVianda);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setForeground(Color.BLACK);
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCantidad.setHorizontalAlignment(SwingConstants.LEADING);
		lblCantidad.setBounds(10, 45, 70, 40);
		contentPanel.add(lblCantidad);
		
		JTextField tfCant = new JTextField();
		tfCant.setColumns(10);
		tfCant.setBounds(140, 56, 150, 20);
		contentPanel.add(tfCant);
		
		JLabel lblCodigoDeVenta = new JLabel("Codigo de venta");
		lblCodigoDeVenta.setForeground(Color.BLACK);
		lblCodigoDeVenta.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCodigoDeVenta.setHorizontalAlignment(SwingConstants.LEADING);
		lblCodigoDeVenta.setBounds(10, 85, 150, 20);
		contentPanel.add(lblCodigoDeVenta);
		
		tfCodVenta = new JTextField();
		tfCodVenta.setBounds(140, 85, 150, 20);
		tfCodVenta.setColumns(10);
		contentPanel.add(tfCodVenta);
		
		JLabel lblError = new JLabel("");
		lblError.setBounds(10, 120, 300, 20);
		contentPanel.add(lblError);
		
		JButton btnEliminar = new JButton("Eliminar");
		contentPanel.add(btnEliminar);
		btnEliminar.setBounds(65, 160, 100, 20);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codVianda = tfCodVianda.getText();
				int cant = Integer.parseInt(tfCant.getText());
				int numVenta = Integer.parseInt(tfCodVenta.getText());
				try {
					miControlador.eliminarVianda(codVianda, cant, numVenta);
				}catch(Exception ex) {
					lblError.setText("Error al eliminar las viandas");
				}
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(170, 160, 100, 20);
		contentPanel.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

	}

}
