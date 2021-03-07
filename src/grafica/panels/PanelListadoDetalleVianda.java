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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import excepciones.ViandasException;
import logica.controladores.ControladorListadoDetalleVianda;

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
		contentPanel.setBorder(new TitledBorder(null, "Listado detalle vianda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.setLayout(new GridLayout(1, 1, 0, 0));
		setResizable(false);
		setContentPane(contentPanel);
		setTitle("Listados");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/3, screenSize.height/3, 800, 300);
		
		table = new JTable();
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
		table.setModel(model);
		
		JScrollPane scrollPane;
        table.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(table);
		
		JPanel contentPanel2 = new JPanel();
		contentPanel2.setLayout(new FlowLayout(0));
		JLabel lblCodigoDeLa = new JLabel("Codigo de la vianda:");
		contentPanel2.add(lblCodigoDeLa);
		tfCodVenta = new JTextField();
		contentPanel2.add(tfCodVenta, BorderLayout.NORTH);
		tfCodVenta.setColumns(10);
		
		JButton btnListar = new JButton("Listar");
		JLabel lblMsg = new JLabel();
		contentPanel2.add(btnListar);
		contentPanel2.add(lblMsg);
		contentPanel.add(contentPanel2);
		
		JPanel contentPanel3 = new JPanel();
		contentPanel3.setBorder(new TitledBorder(null, "Detalle", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel3.add(scrollPane);
		contentPanel3.setVisible(false);
		contentPanel2.add(contentPanel3, BorderLayout.SOUTH);
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
