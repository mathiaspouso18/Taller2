package grafica.views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.sun.nio.file.SensitivityWatchEventModifier;

import grafica.panels.PanelEliminarVianda;
import grafica.panels.PanelIngresoVianda;
import grafica.panels.PanelListadoVentas;
import grafica.panels.PanelListadoViandas;
import grafica.panels.PanelNuevaVenta;
import grafica.panels.PanelNuevaVianda;
import grafica.panels.PanelViandasxVenta;
import logica.controladores.ControladorAltaVianda;

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
	 * @throws Exception 
	 */
	public Principal() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setBounds(100, 100, 892, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		
		JMenu mnGestionDeVentas = new JMenu("Gestion de Ventas");
		menuBar.add(mnGestionDeVentas);
		
		JMenuItem mntmNuevaVenta = new JMenuItem("Nueva Venta");
		mnGestionDeVentas.add(mntmNuevaVenta);
		mntmNuevaVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelNuevaVenta pnv = new PanelNuevaVenta();
				pnv.setVisible(true);
			}
		});
		
		JMenuItem mntmIngresoDeVianda = new JMenuItem("Ingreso de Vianda");
		mnGestionDeVentas.add(mntmIngresoDeVianda);
		mntmIngresoDeVianda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent b) {
				PanelIngresoVianda pnvi = new PanelIngresoVianda();
				pnvi.setVisible(true);
			}
		});
		
		JMenuItem mntmQuitarVianda = new JMenuItem("Quitar Vianda");
		mnGestionDeVentas.add(mntmQuitarVianda);
		mntmQuitarVianda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent b) {
				PanelEliminarVianda pnev = new PanelEliminarVianda();
				pnev.setVisible(true);
			}
		});
		
		JMenuItem mntmProcesarVenta = new JMenuItem("Procesar Venta");
		mnGestionDeVentas.add(mntmProcesarVenta);
		
		JMenu mnGestionDeViandas = new JMenu("Gestion de Viandas");
		menuBar.add(mnGestionDeViandas);
		
		JMenuItem mntmNuevaVianda = new JMenuItem("Nueva Vianda");
		mnGestionDeViandas.add(mntmNuevaVianda);
		mntmNuevaVianda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent b) {
				try {
					PanelNuevaVianda pnv = new PanelNuevaVianda();
					pnv.setVisible(true);
				}
				catch(Exception ex) {
					
				}
			}
		});
		
		JMenu mnListados = new JMenu("Listados");
		menuBar.add(mnListados);
		
		JMenuItem mntmListadoGeneralDe = new JMenuItem("Listado general de ventas");
		mnListados.add(mntmListadoGeneralDe);
		mntmListadoGeneralDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent b) {
				PanelListadoVentas plv = new PanelListadoVentas();
				plv.setVisible(true);
			}
		});
		
		JMenuItem mntmListadoDeViandas = new JMenuItem("Listado de viandas de una venta");
		mnListados.add(mntmListadoDeViandas);
		mntmListadoDeViandas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent b) {
				PanelViandasxVenta pvxv = new PanelViandasxVenta();
				pvxv.setVisible(true);
			}
		});
		
		JMenuItem mntmListadoGeneralDe_1 = new JMenuItem("Listado general de viandas");
		mnListados.add(mntmListadoGeneralDe_1);
		mntmListadoGeneralDe_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent b) {
				PanelListadoViandas plv = new PanelListadoViandas();
				plv.setVisible(true);
			}
		});
		
		JMenuItem mntmListadoDetalladoDe = new JMenuItem("Listado detallado de una vianda");
		mnListados.add(mntmListadoDetalladoDe);
		
		JMenuItem mntmListadoDeViandas_1 = new JMenuItem("Listado de viandas por descripci\u00F3n");
		mnListados.add(mntmListadoDeViandas_1);
		
		frame.setVisible(true);
	}

}
