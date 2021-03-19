package grafica.panels;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import excepciones.VentasException;
import excepciones.ViandasException;
import logica.controladores.ControladorViandasxVenta;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ScrollPaneConstants;

public class PanelViandasxVenta extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField tfCodVenta;
	private JPanel contentPanel;
	JTable table;
	PanelViandasxVenta vista;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public PanelViandasxVenta() throws Exception {
		ControladorViandasxVenta miControlador = new ControladorViandasxVenta(vista);
		contentPanel = new JPanel();
		contentPanel.setBorder(new TitledBorder(null, "Listado de viandas de una venta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setResizable(false);
		setContentPane(contentPanel);
		setTitle("Listados");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/3, screenSize.height/3, 800, 300);
		
		JScrollPane scrollPane;
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;
			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		
		model.addColumn("Código");
		model.addColumn("Descripción");
		model.addColumn("Precio");
		model.addColumn("Vegetariana");
		model.addColumn("Ovolacto vegetariana");
		model.addColumn("Descripción adicional");
		model.addColumn("Cantidad");
		table.setModel(model);
		
		JPanel contentPanel3 = new JPanel();
		contentPanel3.setBorder(new TitledBorder(null, "Viandas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel3.setBounds(0,30,772,218);
		table.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(11, 21, 750, 190);
		contentPanel3.setVisible(false);
		contentPanel.setLayout(null);

		
		JPanel contentPanel2 = new JPanel();
		contentPanel2.setBounds(6, 16, 782, 248);
		contentPanel2.setLayout(null);
		JLabel lblNumVenta = new JLabel("N\u00B0 de venta:");
		lblNumVenta.setBounds(10, 10, 90, 14);
		contentPanel2.add(lblNumVenta);
		tfCodVenta = new JTextField();
		tfCodVenta.setBounds(79, 7, 86, 20);
		contentPanel2.add(tfCodVenta);
		tfCodVenta.setColumns(10);
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(175, 6, 90, 23);
		JLabel lblMsg = new JLabel();
		lblMsg.setBounds(280, 5, 300, 25);
		contentPanel2.add(btnListar);
		contentPanel2.add(lblMsg);
		contentPanel3.setLayout(null);
		contentPanel3.add(scrollPane);
		contentPanel2.add(contentPanel3);
		contentPanel.add(contentPanel2);
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent b) {
				String numVenta = tfCodVenta.getText();
				if(numVenta.equals("")) {
					lblMsg.setText("Debe ingresar el codigo de la venta");
					lblMsg.setForeground(Color.GRAY);
					contentPanel3.setVisible(false);
				}else {
					try {
						lblMsg.setText("");
						if (model.getRowCount() > 0) {
						    for (int i = model.getRowCount() - 1; i > -1; i--) {
						        model.removeRow(i);
						    }
						}
						ArrayList<String []> datos = new ArrayList<String []>();
						datos = miControlador.listadoViandasxVenta(Integer.parseInt(numVenta));
						for(String [] d: datos) {
							model.addRow(d);
						}
						contentPanel3.setVisible(true);
					}catch(VentasException ve) {
						lblMsg.setForeground(Color.RED);
						lblMsg.setText(ve.getMensajeVentaException());
						contentPanel3.setVisible(false);
					}catch(ViandasException  vi) {
						lblMsg.setForeground(Color.RED);
						lblMsg.setText(vi.getMensajeViandaException());
						contentPanel3.setVisible(false);
					}catch(NumberFormatException nfe) {
						lblMsg.setForeground(Color.RED);
						lblMsg.setText("Valor no permitido");
						contentPanel3.setVisible(false);
					}catch(Exception ex) {
						lblMsg.setForeground(Color.RED);
						lblMsg.setText(ex.getMessage());
						contentPanel3.setVisible(false);
					}
				}
			}});
	}
}
