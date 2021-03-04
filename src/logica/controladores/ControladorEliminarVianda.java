package logica.controladores;

import java.io.FileInputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Properties;

import excepciones.VentasException;
import excepciones.ViandasException;
import grafica.panels.PanelEliminarVianda;
import logica.ICapaLogica;

public class ControladorEliminarVianda {
	private ICapaLogica cap;
	
	public ControladorEliminarVianda(PanelEliminarVianda pnv) throws Exception {
		Properties p = new Properties();
		String nomArch = "src/config/config.properties";
		p.load (new FileInputStream (nomArch));
		String ip = p.getProperty("ipServidor");
		String puerto = p.getProperty("puertoServidor");
		String ruta = "//" + ip + ":" + puerto + "/fachada";
		
		cap = (ICapaLogica) Naming.lookup(ruta);
	}
	
	public void eliminarVianda(String codVianda, int cant, int numVenta) throws RemoteException, VentasException, InterruptedException, ViandasException {
		try {
			cap.reducirCantVianda(codVianda, cant, numVenta);
		}catch(VentasException | ViandasException ve) {
			throw ve;
		}
	}
}
