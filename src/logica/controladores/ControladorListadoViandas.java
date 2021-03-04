package logica.controladores;

import java.io.FileInputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Properties;

import excepciones.VentasException;
import excepciones.ViandasException;
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
	
	public Object[][] listadoViandas() throws RemoteException, ViandasException, InterruptedException {
		Object[][] data = {};
		String codVianda="", desc = "", precio="", veg="No", ovo="No", descAdic="---";
		try {
			ArrayList<VOVianda> arr = cap.listarViandas();
			int row = 0;
			for(VOVianda v: arr) {
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
				data[row][0] = codVianda;
				data[row][1] = desc;
				data[row][2] = precio;
				data[row][3] = veg;
				data[row][4] = ovo;
				data[row][2] = descAdic;
				row++;
			}	
		}catch(ViandasException ve) {
			throw ve;
		}
		
		return data;
	}
}
