package logica.controladores;

import java.io.FileInputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Properties;

import excepciones.VentasException;
import excepciones.ViandasException;
import grafica.panels.PanelIngresoVianda;
import logica.ICapaLogica;

public class ControladorIngresoVianda {
	private ICapaLogica cap;
	
	public ControladorIngresoVianda(PanelIngresoVianda pnv) throws Exception {
		Properties p = new Properties();
		String nomArch = "src/config/config.properties";
		p.load (new FileInputStream (nomArch));
		String ip = p.getProperty("ipServidor");
		String puerto = p.getProperty("puertoServidor");
		String ruta = "//" + ip + ":" + puerto + "/fachada";
		
		cap = (ICapaLogica) Naming.lookup(ruta);
	}
	
	public void ingresoVianda(String codVianda, int numVenta, int cant) throws RemoteException, VentasException, InterruptedException, ViandasException {
		try {
			cap.altaViandaxVenta(codVianda.toUpperCase(), numVenta, cant);
		}catch(VentasException ve) {
			throw ve;
		}
		catch(ViandasException v) {
			throw v;
		}
	}
}
