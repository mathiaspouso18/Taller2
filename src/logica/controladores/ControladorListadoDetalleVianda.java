package logica.controladores;

import java.io.FileInputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Properties;

import excepciones.ViandasException;
import grafica.panels.PanelListadoDetalleVianda;
import logica.ICapaLogica;
import logica.viandas.VOVianda;
import logica.viandas.VOViandaVeg;

public class ControladorListadoDetalleVianda {
	private static ICapaLogica cap;
	
	public ControladorListadoDetalleVianda(PanelListadoDetalleVianda pnv) throws Exception {
		Properties p = new Properties();
		String nomArch = "src/config/config.properties";
		p.load (new FileInputStream (nomArch));
		String ip = p.getProperty("ipServidor");
		String puerto = p.getProperty("puertoServidor");
		String ruta = "//" + ip + ":" + puerto + "/fachada";
		
		ICapaLogica capalogica = (ICapaLogica) Naming.lookup(ruta);
	}
	
	public void listadoDetalleVianda(String codVianda) throws RemoteException, ViandasException, InterruptedException {
		cap.listarDatosVianda(codVianda);		
	}
}
