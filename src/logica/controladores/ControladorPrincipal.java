package logica.controladores;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.Naming;
import java.util.Properties;

import excepciones.PersistenciaException;
import grafica.views.Principal;
import logica.ICapaLogica;

public class ControladorPrincipal {
	private ICapaLogica cap;
	
	public ControladorPrincipal(Principal pnv) throws Exception {
		Properties p = new Properties();
		String nomArch = "src/config/config.properties";
		p.load (new FileInputStream (nomArch));
		String ip = p.getProperty("ipServidor");
		String puerto = p.getProperty("puertoServidor");
		String ruta = "//" + ip + ":" + puerto + "/fachada";
		
		cap = (ICapaLogica) Naming.lookup(ruta);
	}
	
	public void restaurarInfo() throws ClassNotFoundException, IOException, PersistenciaException  {
		try {
			cap.restaurarInfo();
		}catch(Exception ex) {
			throw ex;
		}
	}
	
	public void respaldarInfo() throws PersistenciaException, IOException  {
		try {
			cap.respaldarInfo();
		}catch(Exception ex) {
			throw ex;
		}
	}
}
