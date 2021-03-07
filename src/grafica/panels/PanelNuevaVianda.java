package grafica.panels;

import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.border.TitledBorder;

import excepciones.ViandasException;
import logica.controladores.ControladorAltaVianda;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class PanelNuevaVianda extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField tfCodVianda;
	private JTextField tfPrecio;
	private JTextField tfDescAdic;
	private JPanel contentPanel;
	private PanelNuevaVianda vista;
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public PanelNuevaVianda() throws Exception {
		
		ControladorAltaVianda miControlador = new ControladorAltaVianda(vista);
		
		contentPanel = new JPanel();
		contentPanel.setBorder(new TitledBorder(null, "Nueva vianda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		setResizable(false);
		setTitle("Gestion de viandas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/3, screenSize.height/3, 350, 300);
		
		JLabel lblCodigoDeVianda = new JLabel("Código");
		lblCodigoDeVianda.setForeground(Color.BLACK);
		lblCodigoDeVianda.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCodigoDeVianda.setHorizontalAlignment(SwingConstants.LEADING);
		lblCodigoDeVianda.setBounds(10, 10, 50, 40);
		contentPanel.add(lblCodigoDeVianda);
		
		tfCodVianda = new JTextField();
		tfCodVianda.setBounds(180, 23, 120, 20);
		contentPanel.add(tfCodVianda);
		
		JLabel lblDescripcin = new JLabel("Descripción");
		lblDescripcin.setForeground(Color.BLACK);
		lblDescripcin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDescripcin.setHorizontalAlignment(SwingConstants.LEADING);
		lblDescripcin.setBounds(10, 38, 90, 40);
		contentPanel.add(lblDescripcin);
		
		JTextField taDescripcion = new JTextField();
		taDescripcion.setBounds(180, 48, 120, 20);
		contentPanel.add(taDescripcion);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(Color.BLACK);
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrecio.setBounds(10, 73, 40, 20);
		contentPanel.add(lblPrecio);
		
		tfPrecio = new JTextField();
		tfPrecio.setBounds(180, 73,120, 20);
		contentPanel.add(tfPrecio);
		tfPrecio.setColumns(10);
		
		JLabel lblchkVeg = new JLabel("Vegetariana");
		lblchkVeg.setForeground(Color.BLACK);
		lblchkVeg.setBounds(10, 100, 80, 20);
		lblchkVeg.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblchkVeg);
		
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
		chckbxVegana.setBounds(177, 100, 80, 20);
		contentPanel.add(chckbxVegana);
		
		JLabel lblOvoVeg = new JLabel("Ovolacto vegetariana");
		lblOvoVeg.setForeground(Color.BLACK);
		lblOvoVeg.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOvoVeg.setBounds(10, 125, 150, 20);
		contentPanel.add(lblOvoVeg);
		
		chckbxOvo.setEnabled(false);
		chckbxOvo.setBounds(177, 127, 80, 20);
		contentPanel.add(chckbxOvo);
		
		JLabel labelDescAdic = new JLabel("Descripcion adicional");
		labelDescAdic.setForeground(Color.BLACK);
		labelDescAdic.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelDescAdic.setBounds(10, 150, 150, 20);
		contentPanel.add(labelDescAdic);
		
		tfDescAdic = new JTextField();
		tfDescAdic.setEnabled(false);
		tfDescAdic.setBounds(180, 150, 120, 20);
		tfDescAdic.setColumns(10);
		contentPanel.add(tfDescAdic);
		
		JLabel lblMsg = new JLabel();
		lblMsg.setBounds(10, 180, 300, 20);
		contentPanel.add(lblMsg);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(50, 220, 120, 20);
		contentPanel.add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean todoOK = true;
				int precio = 0;
				String codVianda = tfCodVianda.getText();
				String desc = taDescripcion.getText();
				String sPrecio = tfPrecio.getText();
				Boolean veg = chckbxVegana.isSelected();
				Boolean ovo = chckbxOvo.isSelected();
				String descAdic = tfDescAdic.getText();
				try {
					if(codVianda.isEmpty()) {
						todoOK = false;
						lblMsg.setForeground(Color.GRAY);
						lblMsg.setText("Debe ingresar el codigo de vianda");
					}else if(desc.isEmpty()) {
						todoOK = false;
						lblMsg.setForeground(Color.GRAY);
						lblMsg.setText("Debe ingresar una descripcion");
					}else if(sPrecio.isEmpty()) {
						todoOK = false;
						lblMsg.setForeground(Color.GRAY);
						lblMsg.setText("Debe ingresar el precio");	
					}
					
					if(todoOK) {
						precio = Integer.parseInt(tfPrecio.getText());
						miControlador.altaVianda(codVianda, desc, precio, veg, ovo, descAdic);
						lblMsg.setForeground(Color.GREEN);
						lblMsg.setText("Vianda ingresada con exito");
						tfCodVianda.setText("");
						tfPrecio.setText("");
						taDescripcion.setText("");
						chckbxVegana.setSelected(false);
						chckbxOvo.setSelected(false);
						chckbxOvo.setEnabled(false);
						tfDescAdic.setText("");
						tfDescAdic.setEnabled(false);
					}
				}catch(ViandasException ve){
					lblMsg.setForeground(Color.RED);
					lblMsg.setText(ve.getMensajeViandaException());
				}catch(NumberFormatException nfe) {
					lblMsg.setForeground(Color.RED);
					lblMsg.setText("Precio debe ser un valor numerico y entero");
				}catch(Exception ex){
					lblMsg.setForeground(Color.RED);
					lblMsg.setText(ex.getMessage());
				}
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(175, 220, 120, 20);
		contentPanel.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
}
