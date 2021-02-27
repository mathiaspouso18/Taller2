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

public class PanelListadoViandaxDesc extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	JTable table;

	/**
	 * Create the panel.
	 */
	public PanelListadoViandaxDesc() {
		contentPanel = new JPanel();
		contentPanel.setBorder(new TitledBorder(null, "Listado detalle vianda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.setLayout(new GridLayout(1, 1, 0, 0));
		setResizable(false);
		setContentPane(contentPanel);
		setTitle("Listados");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/3, screenSize.height/3, 600, 300);
		
		JPanel contentPanel3 = new JPanel();
		contentPanel3.setBorder(new TitledBorder(null, "Viandas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
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

		JScrollPane scrollPane;
		MyJTable abstractTable = new MyJTable();
		abstractTable.setData(data);
		abstractTable.setColumns(columnNames);
		table = new JTable(abstractTable);
        table.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(table);
        contentPanel3.setVisible(false);

		JLabel lblError = new JLabel();
		JPanel contentPanel2 = new JPanel();
		contentPanel2.setLayout(new FlowLayout(0));
		JLabel lblCodigoDeLa = new JLabel("Descripcion:");
		contentPanel2.add(lblCodigoDeLa);
		JTextField tfCodVenta = new JTextField();
		contentPanel2.add(tfCodVenta, BorderLayout.NORTH);
		tfCodVenta.setColumns(10);
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent b) {
				if(tfCodVenta.getText().toLowerCase().equals("arr")) {
					lblError.setText("");
					contentPanel3.setVisible(true);
				}else {
					if(tfCodVenta.getText().equals("")) {
						lblError.setText("Debe ingresar una descripcion");
						lblError.setForeground(Color.red);
					}else{
						lblError.setText("Sin resultados");
						lblError.setForeground(Color.red);
					}
					contentPanel3.setVisible(false);
				}
			}
		});
		contentPanel2.add(btnListar);
		contentPanel2.add(lblError);
		
        contentPanel3.add(scrollPane);
        
		contentPanel2.add(contentPanel3, BorderLayout.SOUTH);
		
		contentPanel.add(contentPanel2);
	}
}
