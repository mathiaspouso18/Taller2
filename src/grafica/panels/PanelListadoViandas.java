package grafica.panels;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

public class PanelListadoViandas extends JFrame{

	private JFrame frame;
	private JPanel contentPanel;
	private Toolkit t = Toolkit.getDefaultToolkit();
	JTable table;
	
	public PanelListadoViandas(){
		contentPanel = new JPanel();
		contentPanel.setBorder(new TitledBorder(null, "Listado viandas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPanel);
		contentPanel.setLayout(new GridLayout(1, 0));
		
		//setResizable(false);
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

		Object[][] data = {
			{"ACP150", "Arroz con pollo","$150", "No", "No", "-----"},
			{"ACS170", "Arroz con seitan","$170", "Si", "Si", "Nada raro"},
		};
		
		MyJTable abstractTable = new MyJTable();
		abstractTable.setData(data);
		abstractTable.setColumns(columnNames);
		table = new JTable(abstractTable);
        table.setFillsViewportHeight(true);
        
        JScrollPane scrollPane = new JScrollPane(table);
		
		contentPanel.add(scrollPane);
	}
}
