package grafica.panels;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import javax.swing.border.TitledBorder;

import excepciones.VentasException;
import logica.controladores.ControladorAltaVenta;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class PanelNuevaVenta extends JFrame {
	private static final long serialVersionUID = 1L;
	private JComboBox cbFechaDia;
	private JComboBox cbFechaMes;
	private JComboBox cbFechaAño;
	private JComboBox cbFechaHora;
	private JComboBox cbFechaMin;
	private JTextArea taDirEntrega;
	private JPanel contentPanel;
	private PanelNuevaVenta vista;
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public PanelNuevaVenta() throws Exception {
		ControladorAltaVenta miControlador = new ControladorAltaVenta(vista);
		
		contentPanel = new JPanel();
		contentPanel.setBorder(new TitledBorder(null, "Datos de la venta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);

		setResizable(false);
		setTitle("Gestion de Ventas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/3, screenSize.height/3, 422, 270);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setForeground(Color.BLACK);
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFecha.setHorizontalAlignment(SwingConstants.LEADING);
		lblFecha.setBounds(10, 10, 70, 40);
		contentPanel.add(lblFecha);
		
		cbFechaDia = new JComboBox<>();
		for(int i=1;i<=31;i++){
			cbFechaDia.addItem(i);
		}
		cbFechaDia.setBounds(140, 23, 40, 20);
		contentPanel.add(cbFechaDia);
		
		cbFechaMes = new JComboBox<>();
		for(int i=1;i<=12;i++){
			cbFechaMes.addItem(i);
		}
		cbFechaMes.setBounds(177, 23, 40, 20);
		contentPanel.add(cbFechaMes);
		
		cbFechaAño = new JComboBox<>();
		int añoActual = LocalDateTime.now().getYear();
		for(int i=añoActual;i<=añoActual+50;i++){
			cbFechaAño.addItem(i);
		}
		cbFechaAño.setBounds(215, 23, 70, 20);
		contentPanel.add(cbFechaAño);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setForeground(Color.BLACK);
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHora.setHorizontalAlignment(SwingConstants.LEADING);
		lblHora.setBounds(10, 45, 70, 40);
		contentPanel.add(lblHora);
		
		cbFechaHora = new JComboBox<>();
		for(int i=0;i<=23;i++){
			cbFechaHora.addItem(i);
		}
		cbFechaHora.setBounds(140, 55, 50, 20);
		contentPanel.add(cbFechaHora);
		
		cbFechaMin = new JComboBox<>();
		for(int i=0;i<=59;i++){
			cbFechaMin.addItem(i);
		}
		cbFechaMin.setBounds(195, 55, 50, 20);
		contentPanel.add(cbFechaMin);
		
		JLabel lblDir = new JLabel("Direcci\u00F3n");
		lblDir.setForeground(Color.BLACK);
		lblDir.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDir.setHorizontalAlignment(SwingConstants.LEADING);
		lblDir.setBounds(10, 80, 70, 40);
		contentPanel.add(lblDir);
		
		taDirEntrega = new JTextArea();
		taDirEntrega.setLineWrap(true);
		taDirEntrega.setColumns(10);
		taDirEntrega.setBounds(140, 92, 150, 48);
		contentPanel.add(taDirEntrega);
		
		JLabel lblMsg = new JLabel();
		lblMsg.setBounds(10, 156, 500, 20);
		contentPanel.add(lblMsg);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(69, 189, 100, 20);
		btnAceptar.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				try{
					int dia = (int) cbFechaDia.getSelectedItem();
					int mes = (int) cbFechaMes.getSelectedItem();
					int año = (int) cbFechaAño.getSelectedItem();
					int hora = (int) cbFechaHora.getSelectedItem();
					int min = (int) cbFechaMin.getSelectedItem();
					LocalDateTime fecha = LocalDateTime.of(año, mes, dia, hora, min);
					String dir = taDirEntrega.getText();
					if(!dir.isEmpty()) {
						miControlador.altaVenta(fecha, dir);
						lblMsg.setForeground(Color.GREEN);
						lblMsg.setText("Venta ingresada con exito");
						cbFechaDia.setSelectedIndex(0);
						cbFechaMes.setSelectedIndex(0);
						cbFechaAño.setSelectedIndex(0);
						cbFechaHora.setSelectedIndex(0);
						cbFechaMin.setSelectedIndex(0);
						taDirEntrega.setText("");
					}else {
						lblMsg.setForeground(Color.GRAY);
						lblMsg.setText("Debe ingresar una dirección");
					}
				}
				catch(VentasException ve) {
					lblMsg.setForeground(Color.RED);
					lblMsg.setText(ve.getMensajeVentaException());
				}
				catch(DateTimeException de) {
					lblMsg.setForeground(Color.RED);
					lblMsg.setText("Fecha incorrecta: febrero no tiene 29 dias");
				}
				catch(Exception ex) {
					lblMsg.setForeground(Color.RED);
					lblMsg.setText("Error");
				}
			}
		});
		contentPanel.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(174, 189, 100, 20);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		contentPanel.add(btnCancelar);
	}
}
