package grafica.panels;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

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
		contentPanel.setLayout(new GridLayout(1, 0));
		
		setTitle("Listados");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/3, screenSize.height/3, 800, 300);
		
		String[] columnNames = {"Codigo",
                "Descripcion",
                "Precio",
                "Vegetariana",
                "Ovolacto vegetariana",
                "Descripcion adicional"};

		MyJTable abstractTable = new MyJTable();
		abstractTable.setColumns(columnNames);
		table = new JTable(abstractTable);
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
		try {
			Object[][] data = miControlador.listadoViandas();
			abstractTable.setData(data);
			contentPanel.add(scrollPane);
		}catch(Exception ex) {
			//mensaje de error; dialog
		}
	}
}
