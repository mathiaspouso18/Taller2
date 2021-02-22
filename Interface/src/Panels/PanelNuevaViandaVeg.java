package Panels;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import java.awt.Font;

public class PanelNuevaViandaVeg extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelNuevaViandaVeg() {
		setBorder(new TitledBorder(null, "Vegana", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(2, 2, 5, 5));
		
		JLabel label = new JLabel("");
		add(label);
		
		JCheckBox chckbxOvolacteovegetariana = new JCheckBox("Ovolacteo-vegetariana");
		add(chckbxOvolacteovegetariana);
		
		JLabel lblDescripcinAdicional = new JLabel("Descripci\u00F3n adicional:");
		lblDescripcinAdicional.setFont(new Font("Tahoma", Font.BOLD, 13));
		add(lblDescripcinAdicional);
		
		JTextArea taDescAdic = new JTextArea();
		add(taDescAdic);

	}

}
