package logica.controladores;

import java.io.FileInputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Properties;

import excepciones.VentasException;
import grafica.panels.PanelProcesarVenta;
import logica.ICapaLogica;

public class ControladorProcesarVenta {
	private ICapaLogica cap;
	
	public ControladorProcesarVenta(PanelProcesarVenta pnv) throws Exception {
		Properties p = new Properties();
		String nomArch = "src/config/config.properties";
		p.load (new FileInputStream (nomArch));
		String ip = p.getProperty("ipServidor");
		String puerto = p.getProperty("puertoServidor");
		String ruta = "//" + ip + ":" + puerto + "/fachada";
		
		cap = (ICapaLogica) Naming.lookup(ruta);
	}
	
	public void procesarVenta(int numVenta, boolean indicacion) throws RemoteException, VentasException, InterruptedException  {
		try {
			cap.procesarVenta(numVenta, indicacion);
		}catch(VentasException ve) {
			throw ve;
		}	
	}
}
