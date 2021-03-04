package logica.controladores;

import java.io.FileInputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Properties;

import excepciones.VentasException;
import excepciones.ViandasException;
import grafica.panels.PanelListadoVentas;
import logica.ICapaLogica;
import logica.ventas.VOVenta;

public class ControladorListadoVentas {
	private ICapaLogica cap;
	
	public ControladorListadoVentas(PanelListadoVentas pnv) throws Exception {
		Properties p = new Properties();
		String nomArch = "src/config/config.properties";
		p.load (new FileInputStream (nomArch));
		String ip = p.getProperty("ipServidor");
		String puerto = p.getProperty("puertoServidor");
		String ruta = "//" + ip + ":" + puerto + "/fachada";
		
		cap = (ICapaLogica) Naming.lookup(ruta);
	}
	
	public ArrayList<String []> listadoVentas() throws RemoteException, VentasException, InterruptedException {
		ArrayList<String []> arre = new ArrayList<String []>();
		int numVenta = 0, montoTotal = 0;
		LocalDateTime fecha;
		String dir = "", estado="";
		try {
			ArrayList<VOVenta> arr = cap.listarVentas();
			for(VOVenta v: arr) {
				String [] data = new String[5];
				numVenta = v.getNumero();
				fecha = v.getFecha();
				dir = v.getDirEntrega();
				montoTotal = v.getMontoTotal();
				if(v.getEnProc()) {
					estado ="En Proceso";
				}else {
					estado = "Finalizada";
				}
				
				data[0] = String.valueOf(numVenta);
				data[1] = fecha.toString();
				data[2] = dir;
				data[3] = String.valueOf(montoTotal);
				data[4] = estado;
				arre.add(data);
			}	
		}catch(VentasException ve) {
			throw ve;
		}
		
		return arre;
	}
}
