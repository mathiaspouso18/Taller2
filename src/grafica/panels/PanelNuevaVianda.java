package grafica.panels;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;

import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import excepciones.ViandasException;
import logica.controladores.ControladorAltaVianda;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Dimension;
import java.awt.Font;

public class PanelNuevaVianda extends JFrame {
	private JTextField tfCodVianda;
	private JTextField tfPrecio;
	private JTextField tfDescAdic;
	private JFrame frame;
	private JPanel contentPanel;
	private Toolkit t = Toolkit.getDefaultToolkit();
	//private ControladorAltaVianda controlador;
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public PanelNuevaVianda() throws Exception {
		
		//controlador = new ControladorAltaVianda(this);
		
		contentPanel = new JPanel();
		contentPanel.setBorder(new TitledBorder(null, "Nueva vianda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPanel);
		contentPanel.setLayout(new GridLayout(7, 2, 5, 5));
		
		setResizable(false);
		setTitle("Gestion de viandas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/3, screenSize.height/3, 350, 238);
		
		JLabel lblCodigoDeVianda = new JLabel("Codigo de Vianda:");
		lblCodigoDeVianda.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblCodigoDeVianda);
		
		tfCodVianda = new JTextField();
		contentPanel.add(tfCodVianda);
		tfCodVianda.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblDescripcin);
		
		JTextArea taDescripcion = new JTextArea();
		contentPanel.add(taDescripcion);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblPrecio);
		
		tfPrecio = new JTextField();
		contentPanel.add(tfPrecio);
		tfPrecio.setColumns(10);
		
		JLabel label = new JLabel("Vegetariana");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(label);
		
		JCheckBox chckbxOvo = new JCheckBox("");
		JCheckBox chckbxVegana = new JCheckBox("");
		chckbxVegana.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) {
					chckbxOvo.setEnabled(true);
					tfDescAdic.setEnabled(true);
				}else {
					chckbxOvo.setSelected(false);
					tfDescAdic.setText("");
					chckbxOvo.setEnabled(false);
					tfDescAdic.setEnabled(false);
				}
		        System.out.println(e.getStateChange());
		    }
		});
		contentPanel.add(chckbxVegana);
		
		JLabel label2 = new JLabel("Ovolacto vegetariana");
		label2.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(label2);
		
		chckbxOvo.setEnabled(false);
		contentPanel.add(chckbxOvo);
		
		JLabel labelDescAdic = new JLabel("Descripcion adicional");
		labelDescAdic.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(labelDescAdic);
		
		tfDescAdic = new JTextField();
		tfDescAdic.setEnabled(false);
		contentPanel.add(tfDescAdic);
		tfPrecio.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		contentPanel.add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codVianda = tfCodVianda.getText();
				String desc = taDescripcion.getText();
				int precio = Integer.parseInt(tfPrecio.getText());
				Boolean veg = chckbxVegana.isSelected();
				Boolean ovo = chckbxOvo.isSelected();
				String descAdic = tfDescAdic.getText();
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		contentPanel.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}

}
