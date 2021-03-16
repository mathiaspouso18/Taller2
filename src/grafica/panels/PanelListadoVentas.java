package grafica.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import excepciones.VentasException;
import logica.controladores.ControladorListadoVentas;

public class PanelListadoVentas extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	JTable table;
	PanelListadoVentas vista;
	
	public PanelListadoVentas() throws Exception{
		ControladorListadoVentas miControlador = new ControladorListadoVentas(vista);
		contentPanel = new JPanel();
		contentPanel.setBorder(new TitledBorder(null, "Listado general de ventas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPanel);
		
		setTitle("Listados");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/3, screenSize.height/3, 800, 300);
		contentPanel.setLayout(null);
		
		JLabel lblMsg = new JLabel();
		lblMsg.setBounds(6, 18, 627, 22);
		contentPanel.add(lblMsg);

		table = new JTable();
		DefaultTableModel model = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;
			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		
		model.addColumn("Numero");
		model.addColumn("Fecha");
		model.addColumn("Direccion de entrega");
		model.addColumn("Monto total");
		model.addColumn("Estado");
		table.setModel(model);
		
		ArrayList<String []> datos = new ArrayList<String []>();
		
		try {
			lblMsg.setText("");
			datos = miControlador.listadoVentas();
			for(String [] d: datos) {
				model.addRow(d);
			}
			table.setFillsViewportHeight(true);
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(16, 46, 754, 200);
			contentPanel.add(scrollPane);
		}catch(VentasException ve) {
			lblMsg.setForeground(Color.RED);
			lblMsg.setText(ve.getMensajeVentaException());
		}
	}
}
