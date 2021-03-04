package grafica.panels;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logica.controladores.ControladorListadoViandas;
import logica.viandas.VOVianda;

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
		
		model.addColumn("Código");
		model.addColumn("Descripción");
		model.addColumn("Precio");
		model.addColumn("Vegetariana");
		model.addColumn("Ovolacto vegetariana");
		model.addColumn("Descripción adicional");
		table.setModel(model);
		
		ArrayList<String []> datos = new ArrayList<String []>();
		
		try {
			datos = miControlador.listadoViandas();
			for(String [] d: datos) {
				model.addRow(d);
			}
	        table.setFillsViewportHeight(true);
	        JScrollPane scrollPane = new JScrollPane(table);
			contentPanel.add(scrollPane);
		}catch(Exception ex) {
			System.out.println(ex);
			//mensaje de error; dialog
		}
	}
}
