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
	private static ICapaLogica cap;
	
	public ControladorViandasxVenta(PanelViandasxVenta pnv) throws Exception {
		Properties p = new Properties();
		String nomArch = "src/config/config.properties";
		p.load (new FileInputStream (nomArch));
		String ip = p.getProperty("ipServidor");
		String puerto = p.getProperty("puertoServidor");
		String ruta = "//" + ip + ":" + puerto + "/fachada";
		
		ICapaLogica capalogica = (ICapaLogica) Naming.lookup(ruta);
	}
	
	public Object[][] listadoViandasxVenta(int numVenta) throws RemoteException, ViandasException, VentasException, InterruptedException {
		Object[][] data = {};
		String desc = "", precio="", veg="No", ovo="No", descAdic="---";
		ArrayList<VOVianda> arre = cap.listarViandasVenta(numVenta);
		for(VOVianda vi: arre) {
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
			//data[0][0] = {codVianda, desc, precio, veg, descAdic};
		}
				
		return data;
	}
}
