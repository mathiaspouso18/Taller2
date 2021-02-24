package grafica.panels;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Font;

public class PanelNuevaVenta extends JFrame {
	private JTextField tfFecha;
	private JTextField tfHora;
	private JFrame frame;
	private JPanel contentPanel;
	private Toolkit t = Toolkit.getDefaultToolkit();

	/**
	 * Create the panel.
	 */
	public PanelNuevaVenta() {
		contentPanel = new JPanel();
		contentPanel.setBorder(new TitledBorder(null, "Datos de la venta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPanel);
		contentPanel.setLayout(new GridLayout(4, 2, 5, 5));

		setResizable(false);
		setTitle("Registrar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/3, screenSize.height/3, 350, 238);
		
		JLabel lblNewLabel = new JLabel("Fecha");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblNewLabel);
		
		tfFecha = new JTextField();
		tfFecha.setColumns(10);
		contentPanel.add(tfFecha);
		
		JLabel lblNewLabel_1 = new JLabel("Hora");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblNewLabel_1);
		
		tfHora = new JTextField();
		tfHora.setColumns(10);
		contentPanel.add(tfHora);
		
		JLabel lblNewLabel_2 = new JLabel("Direccion de entrega:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblNewLabel_2);
		
		JTextArea taDirEntrega = new JTextArea();
		contentPanel.add(taDirEntrega);
		
		JButton btnAceptar = new JButton("Aceptar");
		contentPanel.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		contentPanel.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
	}
}
