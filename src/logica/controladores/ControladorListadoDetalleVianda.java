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
	private ICapaLogica cap;
	
	public ControladorListadoDetalleVianda(PanelListadoDetalleVianda pnv) throws Exception {
		Properties p = new Properties();
		String nomArch = "src/config/config.properties";
		p.load (new FileInputStream (nomArch));
		String ip = p.getProperty("ipServidor");
		String puerto = p.getProperty("puertoServidor");
		String ruta = "//" + ip + ":" + puerto + "/fachada";
		
		cap = (ICapaLogica) Naming.lookup(ruta);
	}
	
	public String [] listadoDetalleVianda(String codVianda) throws RemoteException, ViandasException, InterruptedException {
		String [] data = new String[5];
		String desc = "", precio="", veg="No", ovo="No", descAdic="---";
		try {
			VOVianda vi = cap.listarDatosVianda(codVianda);
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
			data[0] = desc;
			data[1] = precio;
			data[2] = veg;
			data[3] = ovo;
			data[4] = descAdic;
		}catch(ViandasException ve) {
			throw ve;
		}
		
		return data;
	}
}
