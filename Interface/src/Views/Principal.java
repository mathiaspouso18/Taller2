package Views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Panels.PanelNuevaVenta;

import java.awt.BorderLayout;

public class Principal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 892, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnGestionDeVentas = new JMenu("Gestion de Ventas");
		menuBar.add(mnGestionDeVentas);
		
		JMenuItem mntmNuevaVenta = new JMenuItem("Nueva Venta");
		mntmNuevaVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//panelNuevaVenta.setVisible(true);
			}
		});
		mnGestionDeVentas.add(mntmNuevaVenta);
		
		JMenuItem mntmIngresoDeVianda = new JMenuItem("Ingreso de Vianda");
		mnGestionDeVentas.add(mntmIngresoDeVianda);
		
		JMenuItem mntmQuitarVianda = new JMenuItem("Quitar Vianda");
		mnGestionDeVentas.add(mntmQuitarVianda);
		
		JMenuItem mntmProcesarVenta = new JMenuItem("Procesar Venta");
		mnGestionDeVentas.add(mntmProcesarVenta);
		
		JMenu mnGestionDeViandas = new JMenu("Gestion de Viandas");
		menuBar.add(mnGestionDeViandas);
		
		JMenuItem mntmNuevaVianda = new JMenuItem("Nueva Vianda");
		mnGestionDeViandas.add(mntmNuevaVianda);
		
		JMenu mnListados = new JMenu("Listados");
		menuBar.add(mnListados);
		
		JMenuItem mntmListadoGeneralDe = new JMenuItem("Listado general de ventas");
		mnListados.add(mntmListadoGeneralDe);
		
		JMenuItem mntmListadoDeViandas = new JMenuItem("Listado de viandas de una venta");
		mnListados.add(mntmListadoDeViandas);
		
		JMenuItem mntmListadoGeneralDe_1 = new JMenuItem("Listado general de viandas");
		mnListados.add(mntmListadoGeneralDe_1);
		
		JMenuItem mntmListadoDetalladoDe = new JMenuItem("Listado detallado de una vianda");
		mnListados.add(mntmListadoDetalladoDe);
		
		JMenuItem mntmListadoDeViandas_1 = new JMenuItem("Listado de viandas por descripci\u00F3n");
		mnListados.add(mntmListadoDeViandas_1);
		
		
	}

}
