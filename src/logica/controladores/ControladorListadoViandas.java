package logica.controladores;

import java.io.FileInputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Properties;

import excepciones.ViandasException;
import grafica.panels.PanelListadoViandas;
import logica.ICapaLogica;
import logica.viandas.VOVianda;
import logica.viandas.VOViandaVeg;

public class ControladorListadoViandas {
	private static ICapaLogica cap;
	
	public ControladorListadoViandas(PanelListadoViandas pnv) throws Exception {
		Properties p = new Properties();
		String nomArch = "src/config/config.properties";
		p.load (new FileInputStream (nomArch));
		String ip = p.getProperty("ipServidor");
		String puerto = p.getProperty("puertoServidor");
		String ruta = "//" + ip + ":" + puerto + "/fachada";
		
		ICapaLogica capalogica = (ICapaLogica) Naming.lookup(ruta);
	}
	
	public Object[][] listadoViandas() throws RemoteException, ViandasException, InterruptedException {
		Object[][] data = {};
		String desc = "", precio="", veg="No", ovo="No", descAdic="---";
		ArrayList<VOVianda> arr = cap.listarViandas();
		for(VOVianda v: arr) {
			desc = v.getDescripcion();
			precio = "$ "+v.getPrecio();
			if(v instanceof VOViandaVeg) {
				VOViandaVeg vveg = (VOViandaVeg) v;
				veg = "Si";
				if(vveg.getEsOvo()){
					ovo="Si";
					descAdic = vveg.getDescAdic();
				}
			}
			//data[0][0] = {codVianda, desc, precio, veg, descAdic};
		}	
		return data;
	}
}
