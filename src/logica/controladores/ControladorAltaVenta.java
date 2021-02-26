package logica.controladores;

import java.io.FileInputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.Properties;

import excepciones.VentasException;
import excepciones.ViandasException;
import grafica.panels.PanelNuevaVenta;
import logica.ICapaLogica;
import logica.ventas.VOVenta;

public class ControladorAltaVenta {
	private static ICapaLogica cap;
	
	public ControladorAltaVenta(PanelNuevaVenta pnv) throws Exception {
		Properties p = new Properties();
		String nomArch = "src/config/config.properties";
		p.load (new FileInputStream (nomArch));
		String ip = p.getProperty("ipServidor");
		String puerto = p.getProperty("puertoServidor");
		String ruta = "//" + ip + ":" + puerto + "/fachada";
		
		ICapaLogica capalogica = (ICapaLogica) Naming.lookup(ruta);
	}
	
	public void altaVenta(LocalDate fecha, String dir) throws RemoteException, VentasException, InterruptedException  {
		VOVenta _v;
		_v = new VOVenta(fecha,dir,true);
		
		cap.altaVenta(_v);
		cap.listarVentas();
	}
}