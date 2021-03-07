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

import excepciones.ViandasException;
import logica.controladores.ControladorListadoViandas;

public class PanelListadoViandas extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	JTable table;
	private PanelListadoViandas vista;
	
	public PanelListadoViandas() throws Exception{
		ControladorListadoViandas miControlador = new ControladorListadoViandas(vista);
		contentPanel = new JPanel();
		contentPanel.setBorder(new TitledBorder(null, "Listado viandas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPanel);
		
		setTitle("Listados");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/3, screenSize.height/3, 800, 300);
		contentPanel.setLayout(null);
		
		JLabel lblMsg = new JLabel();
		lblMsg.setBounds(6, 18, 637, 22);
		contentPanel.add(lblMsg);
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
		
		ArrayList<String []> datos = new ArrayList<String []>();
		
		try {
			lblMsg.setText("");
			datos = miControlador.listadoViandas();
			for(String [] d: datos) {
				model.addRow(d);
			}
	        JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setBounds(16, 46, 754, 200);
			contentPanel.add(scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
			table.setModel(model);
			table.setFillsViewportHeight(true);
		}catch(ViandasException vi) {
			lblMsg.setForeground(Color.RED);
			lblMsg.setText(vi.getMensajeViandaException());
		}
	}
}
