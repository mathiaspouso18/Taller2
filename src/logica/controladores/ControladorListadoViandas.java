package logica.controladores;

import java.io.FileInputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Properties;

import excepciones.VentasException;
import excepciones.ViandasException;
import grafica.panels.MyJTable;
import grafica.panels.PanelListadoViandas;
import logica.ICapaLogica;
import logica.viandas.VOVianda;
import logica.viandas.VOViandaVeg;

public class ControladorListadoViandas {
	private ICapaLogica cap;
	
	public ControladorListadoViandas(PanelListadoViandas pnv) throws Exception {
		Properties p = new Properties();
		String nomArch = "src/config/config.properties";
		p.load (new FileInputStream (nomArch));
		String ip = p.getProperty("ipServidor");
		String puerto = p.getProperty("puertoServidor");
		String ruta = "//" + ip + ":" + puerto + "/fachada";
		
		cap = (ICapaLogica) Naming.lookup(ruta);
	}
	
	public ArrayList<String []> listadoViandas() throws RemoteException, ViandasException, InterruptedException {
		ArrayList<String []> arre = new ArrayList<String []>();
		try {
			ArrayList<VOVianda> arr = cap.listarViandas();
			for(VOVianda v: arr) {
				String [] data = new String[6];
				String codVianda="", desc = "", precio="", veg="No", ovo="No", descAdic="---";
				codVianda = v.getCodVianda();
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
				data[0] = codVianda;
				data[1] = desc;
				data[2] = precio;
				data[3] = veg;
				data[4] = ovo;
				data[5] = descAdic;
				arre.add(data);
			}	
		}catch(ViandasException ve) {
			throw ve;
		}
		
		return arre;
	}
}
