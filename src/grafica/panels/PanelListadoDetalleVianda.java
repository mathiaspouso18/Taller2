package grafica.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import excepciones.ViandasException;
import logica.controladores.ControladorListadoDetalleVianda;
import java.awt.Rectangle;
import java.awt.Component;

public class PanelListadoDetalleVianda extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField tfCodVenta;
	private JPanel contentPanel;
	JTable table;
	private PanelListadoDetalleVianda vista;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public PanelListadoDetalleVianda() throws Exception {
		ControladorListadoDetalleVianda miControlador = new ControladorListadoDetalleVianda(vista);
		contentPanel = new JPanel();
		contentPanel.setBorder(new TitledBorder(null, "Listado detalle de vianda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.setLayout(null);
		setResizable(false);
		setContentPane(contentPanel);
		setTitle("Listados");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/3, screenSize.height/3, 800, 300);
		DefaultTableModel model = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;
			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		
		model.addColumn("Descripción");
		model.addColumn("Precio");
		model.addColumn("Vegetariana");
		model.addColumn("Ovolacto vegetariana");
		model.addColumn("Descripción adicional");
		
		JScrollPane scrollPane;
        scrollPane = new JScrollPane();
        scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        scrollPane.setBounds(new Rectangle(5, 0, 0, 0));
        scrollPane.setBounds(20, 22, 710, 165);
		
		JPanel contentPanel2 = new JPanel();
		contentPanel2.setLayout(null);
		contentPanel2.setBounds(10, 20, 764, 230);
		JLabel lblCodigoDeLa = new JLabel("Codigo de la vianda:");
		lblCodigoDeLa.setHorizontalAlignment(SwingConstants.LEADING);
		lblCodigoDeLa.setBounds(5, 5, 120, 25);
		contentPanel2.add(lblCodigoDeLa);
		tfCodVenta = new JTextField();
		tfCodVenta.setSize(100, 25);
		tfCodVenta.setLocation(120, 5);
		contentPanel2.add(tfCodVenta);
		tfCodVenta.setColumns(10);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setSize(70, 25);
		btnListar.setLocation(226, 5);
		JLabel lblMsg = new JLabel();
		lblMsg.setLocation(300, 5);
		lblMsg.setSize(300, 25);
		contentPanel2.add(btnListar);
		contentPanel2.add(lblMsg);
		contentPanel.add(contentPanel2);
		
		JPanel contentPanel3 = new JPanel();
		contentPanel3.setSize(745, 195);
		contentPanel3.setLocation(5, 35);
		contentPanel3.setBorder(new TitledBorder(null, "Detalle", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel3.setLayout(null);
		contentPanel3.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setModel(model);
		table.setFillsViewportHeight(true);
		contentPanel3.setVisible(false);
		contentPanel2.add(contentPanel3);
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent b) {
				lblMsg.setText("");
				String codVianda = tfCodVenta.getText();
				if(codVianda.equals("")) {
					lblMsg.setForeground(Color.RED);
					lblMsg.setText("Debe ingresar el codigo de la vianda");
					contentPanel3.setVisible(false);
				}else {
					try {
						lblMsg.setText("");
						String [] d = miControlador.listadoDetalleVianda(codVianda);
						model.addRow(d);
						contentPanel3.setVisible(true);
					}catch(ViandasException vi) {
						lblMsg.setForeground(Color.RED);
						lblMsg.setText(vi.getMensajeViandaException());
					}catch(Exception ex) {
						lblMsg.setForeground(Color.RED);
						lblMsg.setText(ex.getMessage());
					}
				}
			}
		});
	}
}
