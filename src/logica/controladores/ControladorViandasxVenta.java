package logica.controladores;

import java.io.FileInputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Properties;

import excepciones.VentasException;
import excepciones.ViandasException;
import grafica.panels.PanelViandasxVenta;
import logica.ICapaLogica;
import logica.viandas.VOVianda;
import logica.viandas.VOViandaVeg;

public class ControladorViandasxVenta {
	private ICapaLogica cap;
	
	public ControladorViandasxVenta(PanelViandasxVenta pnv) throws Exception {
		Properties p = new Properties();
		String nomArch = "src/config/config.properties";
		p.load (new FileInputStream (nomArch));
		String ip = p.getProperty("ipServidor");
		String puerto = p.getProperty("puertoServidor");
		String ruta = "//" + ip + ":" + puerto + "/fachada";
		
		cap = (ICapaLogica) Naming.lookup(ruta);
	}
	
	public ArrayList<String []> listadoViandasxVenta(int numVenta) throws RemoteException, ViandasException, VentasException, InterruptedException {
		ArrayList<String []> arre = new ArrayList<String []>();
		try {
			ArrayList<VOVianda> arr = cap.listarViandasVenta(numVenta);
			for(VOVianda vi: arr) {
				String [] data = new String[6];
				String codVianda="", desc = "", precio="", veg="No", ovo="No", descAdic="---";
				desc = vi.getDescripcion();
				precio = "$ "+vi.getPrecio();
				if(vi instanceof VOViandaVeg) {
					VOViandaVeg vveg = (VOViandaVeg) vi;
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
		}catch(VentasException ve) {
			throw ve;
		}
		return arre;
	}
}
