import java.net.BindException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.time.*;
import java.util.Properties;
import java.io.*;
import excepciones.PersistenciaException;
import excepciones.VentasException;
import excepciones.ViandasException;
import logica.CapaLogica;
import logica.ICapaLogica;
import logica.ventas.*;
import logica.viandas.*;


public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException, VentasException, InterruptedException, NotBoundException, PersistenciaException {
		try
		{ 
			Properties p = new Properties();
			String nomArch = "src/config/config.properties";
			p.load (new FileInputStream (nomArch));
			String ip = p.getProperty("ipServidor");
			String puerto = p.getProperty("puertoServidor");
			String ruta = "//" + ip + ":" + puerto + "/fachada";
			
			ICapaLogica capalogica = (ICapaLogica) Naming.lookup(ruta);
			
			LocalDate ld = LocalDate.of(2021,02,20);
			VOVenta _voventa = new VOVenta(ld, "calle 7740");
			capalogica.altaVenta(_voventa);
			capalogica.respaldarInfo();
		}
		catch (RemoteException e){ 
			e.printStackTrace(); 
		}
		catch(BindException b) {
			b.printStackTrace();
		}
		catch (MalformedURLException e){ 
			e.printStackTrace(); 
		}
		catch (VentasException e) {
			System.out.println(e.getMensajeVentaException());
		}
	}
}
