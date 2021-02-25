package grafica.panels;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

public class PanelListadoVentas extends JFrame {
	private JFrame frame;
	private JPanel contentPanel;
	private Toolkit t = Toolkit.getDefaultToolkit();
	JTable table;
	
	public PanelListadoVentas(){
		contentPanel = new JPanel();
		contentPanel.setBorder(new TitledBorder(null, "Listado ventas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPanel);
		contentPanel.setLayout(new GridLayout(1, 0));
		
		//setResizable(false);
		setTitle("Listados");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/3, screenSize.height/3, 800, 300);
		
		String[] columnNames = {"Numero",
	            "Fecha",
	            "Direccion de entrega",
	            "Monto total",
	            "Estado"};
	
		Object[][] data = {
			{"1", "20-02-2021 15:07","Calle 123", "$150", "En proceso"},
			{"2", "21-02-2021 16:00","Calle 456", "$250", "Finalizada"},
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
