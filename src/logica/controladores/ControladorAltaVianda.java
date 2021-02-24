package logica.controladores;

import java.io.FileInputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Properties;

import excepciones.ViandasException;
import grafica.panels.PanelNuevaVianda;
import grafica.views.Principal;
import logica.ICapaLogica;
import logica.viandas.VOVianda;
import logica.viandas.VOViandaVeg;

public class ControladorAltaVianda {
	ICapaLogica cap;
	private PanelNuevaVianda pnv;
	
	public ControladorAltaVianda(PanelNuevaVianda pnv) throws Exception {
		Properties p = new Properties();
		String nomArch = "src/config/config.properties";
		p.load (new FileInputStream (nomArch));
		String ip = p.getProperty("ipServidor");
		String puerto = p.getProperty("puertoServidor");
		String ruta = "//" + ip + ":" + puerto + "/fachada";
		
		ICapaLogica capalogica = (ICapaLogica) Naming.lookup(ruta);
	}
	
	public void altaVianda(String codVianda, String desc, int precio, boolean veg, boolean ovo, String descAdic) throws RemoteException, ViandasException, InterruptedException {
		VOVianda _vo;
		
		if(veg) {
			_vo = new VOViandaVeg(codVianda, desc, precio, ovo, descAdic);
		}
		else {
			_vo = new VOVianda(codVianda, desc, precio);
		}
		
		cap.altaVianda(_vo);
		cap.listarViandas();
		
	}
}
