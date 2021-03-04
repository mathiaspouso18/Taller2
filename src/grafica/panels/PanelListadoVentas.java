package grafica.panels;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import excepciones.VentasException;
import logica.controladores.ControladorListadoDetalleVianda;
import logica.controladores.ControladorListadoVentas;

public class PanelListadoVentas extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	JTable table;
	PanelListadoVentas vista;
	
	public PanelListadoVentas() throws Exception{
		ControladorListadoVentas miControlador = new ControladorListadoVentas(vista);
		contentPanel = new JPanel();
		contentPanel.setBorder(new TitledBorder(null, "Listado ventas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPanel);
		contentPanel.setLayout(new GridLayout(1, 0));
		
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
		
		model.addColumn("Numero");
		model.addColumn("Fecha");
		model.addColumn("Direccion de entrega");
		model.addColumn("Monto total");
		model.addColumn("Estado");
		table.setModel(model);
		
		ArrayList<String []> datos = new ArrayList<String []>();
		
		try {
			datos = miControlador.listadoVentas();
			for(String [] d: datos) {
				model.addRow(d);
			}
			table.setFillsViewportHeight(true);
	        JScrollPane scrollPane = new JScrollPane(table);
			contentPanel.add(scrollPane);
		}catch(Exception ex) {
			//mensaje de error; dialog
		}
	}
}
