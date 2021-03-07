package grafica.panels;

import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;

import excepciones.VentasException;
import excepciones.ViandasException;
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
		
		tfCodVianda = new JTextField();
		tfCodVianda.setColumns(10);
		tfCodVianda.setBounds(140, 25, 150, 20);
		contentPanel.add(tfCodVianda);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setForeground(Color.BLACK);
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCantidad.setHorizontalAlignment(SwingConstants.LEADING);
		lblCantidad.setBounds(10, 45, 70, 40);
		contentPanel.add(lblCantidad);
		
		tfCant = new JTextField();
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
		
		JLabel lblMsg = new JLabel("");
		lblMsg.setBounds(10, 120, 300, 20);
		contentPanel.add(lblMsg);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(65, 160, 100, 20);
		contentPanel.add(btnEliminar);
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean todoOK = true;
					String codVianda = tfCodVianda.getText();
					if(codVianda.isEmpty()) {
						todoOK= false;
						lblMsg.setForeground(Color.GRAY);
						lblMsg.setText("Debe ingresar el codigo de vianda");
					}
					
					if(todoOK) {
						int cant = Integer.parseInt(tfCant.getText());
						int numVenta = Integer.parseInt(tfCodVenta.getText());
						if(cant > 0 && numVenta > 0) {
							miControlador.eliminarVianda(codVianda, cant, numVenta);
							lblMsg.setForeground(Color.GREEN);
							lblMsg.setText("Vianda reducida con éxito");
							tfCodVianda.setText("");
							tfCant.setText("");
							tfCodVenta.setText("");
						}else {
							lblMsg.setForeground(Color.GRAY);
							lblMsg.setText("Los campos 'Cantidad' y 'Codigo de venta' no pueden tener ese valor");
						}
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
					lblMsg.setForeground(Color.RED);
					lblMsg.setText(ex.getMessage());
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
