package grafica.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
import logica.controladores.ControladorListadoViandaxDesc;

public class PanelListadoViandaxDesc extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	JTable table;
	PanelListadoViandaxDesc vista;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public PanelListadoViandaxDesc() throws Exception {
		ControladorListadoViandaxDesc miControlador = new ControladorListadoViandaxDesc(vista);
		contentPanel = new JPanel();
		contentPanel.setBorder(new TitledBorder(null, "Listado de vianda por descripci�n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.setLayout(new GridLayout(1, 1, 0, 0));
		setResizable(false);
		setContentPane(contentPanel);
		setTitle("Listados");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/3, screenSize.height/3, 600, 300);
		
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;
			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		
		model.addColumn("C�digo");
		model.addColumn("Descripci�n");
		model.addColumn("Precio");
		model.addColumn("Vegetariana");
		model.addColumn("Ovolacto vegetariana");
		model.addColumn("Descripci�n adicional");
		table.setModel(model);

		JScrollPane scrollPane;
        table.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(table);
        
        JPanel contentPanel2 = new JPanel();
		contentPanel2.setLayout(new FlowLayout(0));
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n:");
		contentPanel2.add(lblDescripcion);
		JTextField tfDesc = new JTextField();
		contentPanel2.add(tfDesc, BorderLayout.NORTH);
		tfDesc.setColumns(10);
		
		JButton btnListar = new JButton("Listar");
		JLabel lblMsg = new JLabel();
		contentPanel2.add(btnListar);
		contentPanel2.add(lblMsg);
		contentPanel.add(contentPanel2);
		
		JPanel contentPanel3 = new JPanel();
		contentPanel3.setBorder(new TitledBorder(null, "Viandas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        contentPanel3.add(scrollPane);
		contentPanel2.add(contentPanel3, BorderLayout.SOUTH);
		contentPanel3.setVisible(false);
		
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent b) {
				lblMsg.setText("");
				String descripcion = tfDesc.getText();
				if(descripcion.equals("")) {
					lblMsg.setForeground(Color.RED);
					lblMsg.setText("Debe ingresar alguna descripci�n");
					contentPanel3.setVisible(false);
				}else {
					ArrayList<String []> datos = new ArrayList<String []>();
					try {
						lblMsg.setText("");
						datos = miControlador.listadoViandaxDesc(descripcion);
						for(String [] d: datos) {
							model.addRow(d);
						}
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
