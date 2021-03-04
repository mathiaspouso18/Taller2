package grafica.panels;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;

import excepciones.VentasException;
import excepciones.ViandasException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import logica.CapaLogica;
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
		contentPanel.setLayout(null);
		
		setResizable(false);
		setTitle("Registrar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/3, screenSize.height/3, 500, 238);
		
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
		
		JLabel lblMsg = new JLabel();
		lblMsg.setBounds(10, 120, 500, 20);
		contentPanel.add(lblMsg);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(65, 160, 100, 20);
		contentPanel.add(btnAgregar);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					String codVianda = tfCodVianda.getText();
					String tfcant = tfCant.getText();
					String tfnumVenta = tfCodVenta.getText();
					if(!codVianda.isEmpty() && !tfcant.isEmpty() && !tfnumVenta.isEmpty()) {
						int numVenta = Integer.parseInt(tfnumVenta);
						int cant = Integer.parseInt(tfcant);
						if(cant > 0 && numVenta > 0) {
							//CapaLogica cp = new CapaLogica();
							//cp.altaViandaxVenta(codVianda, numVenta, cant);
							miControlador.ingresoVianda(codVianda, numVenta, cant);
							lblMsg.setForeground(Color.GREEN);
							lblMsg.setText("Vianda agregada con éxito a la venta");
							tfCodVianda.setText("");
							tfCodVenta.setText("");
							tfCant.setText("");
						}else {
							lblMsg.setText("Los campos 'Cantidad' y 'Codigo de venta' no pueden tener ese valor");
							lblMsg.setForeground(Color.GRAY);
						}
					}else {
						lblMsg.setText("Los campos 'Codigo', 'Cantidad' y 'Codigo de venta' deben estar completos");
						lblMsg.setForeground(Color.GRAY);
					}
				}catch(VentasException ve){
					lblMsg.setForeground(Color.RED);
					lblMsg.setText(ve.getMensajeVentaException());
				}catch(ViandasException v){
					lblMsg.setForeground(Color.RED);
					lblMsg.setText(v.getMensajeViandaException());
				}catch(NumberFormatException nfe) {
					lblMsg.setForeground(Color.RED);
					lblMsg.setText("Valor no permitido");
				}catch(Exception ex) {
					
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
