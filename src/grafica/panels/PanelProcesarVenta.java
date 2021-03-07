package grafica.panels;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;

import excepciones.VentasException;
import logica.controladores.ControladorProcesarVenta;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class PanelProcesarVenta extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField tfCodVenta;
	private JPanel contentPanel;
	private PanelProcesarVenta vista;
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public PanelProcesarVenta() throws Exception {
		ControladorProcesarVenta miControlador = new ControladorProcesarVenta(vista);
		
		contentPanel = new JPanel();
		contentPanel.setBorder(new TitledBorder(null, "Procesar venta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		setResizable(false);
		setTitle("Registrar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/3, screenSize.height/3, 350, 238);
		
		JLabel lblCodigoDeVenta = new JLabel("Codigo de venta:");
		lblCodigoDeVenta.setForeground(Color.BLACK);
		lblCodigoDeVenta.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCodigoDeVenta.setHorizontalAlignment(SwingConstants.LEADING);
		lblCodigoDeVenta.setBounds(10, 13, 118, 40);
		contentPanel.add(lblCodigoDeVenta);
		
		tfCodVenta = new JTextField();
		tfCodVenta.setColumns(10);
		tfCodVenta.setBounds(140, 25, 150, 20);
		contentPanel.add(tfCodVenta);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setForeground(Color.BLACK);
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEstado.setHorizontalAlignment(SwingConstants.LEADING);
		lblEstado.setBounds(10, 45, 70, 40);
		contentPanel.add(lblEstado);
		
		JRadioButton rdbtnConfirmar = new JRadioButton("Confirmar");
		rdbtnConfirmar.setBounds(140, 56, 150, 20);
		rdbtnConfirmar.setSelected(true);
		contentPanel.add(rdbtnConfirmar);
		
		JRadioButton rdbtnCancelar = new JRadioButton("Cancelar");
		rdbtnCancelar.setBounds(140, 86, 150, 20);
		contentPanel.add(rdbtnCancelar);
		
		ButtonGroup grupo1 = new ButtonGroup();
		grupo1.add(rdbtnConfirmar);
		grupo1.add(rdbtnCancelar);
		
		JLabel lblMsg = new JLabel("");
		lblMsg.setBounds(10, 120, 300, 20);
		contentPanel.add(lblMsg);
		
		JButton btnAceptar = new JButton("Aceptar");
		contentPanel.add(btnAceptar);
		btnAceptar.setBounds(65, 140, 100, 20);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean indicacion = true;
					lblMsg.setText("");
					int numVenta = Integer.parseInt(tfCodVenta.getText());
					if(rdbtnCancelar.isSelected()){
						indicacion = false;
					}
					miControlador.procesarVenta(numVenta, indicacion);
					lblMsg.setForeground(Color.GREEN);
					lblMsg.setText("Venta procesada con exito");
					tfCodVenta.setText("");
					rdbtnConfirmar.setSelected(true);
				}catch(VentasException ve) {
					lblMsg.setForeground(Color.RED);
					lblMsg.setText(ve.getMensajeVentaException());
				}catch(NumberFormatException nfe) {
					lblMsg.setForeground(Color.RED);
					lblMsg.setText("Valor no permitido");
				}catch(Exception ex) {
					lblMsg.setForeground(Color.RED);
					lblMsg.setText(ex.getMessage());
				}
			}});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(170, 140, 100, 20);
		contentPanel.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

	}
}
