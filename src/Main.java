import java.net.BindException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.time.*;
import java.util.ArrayList;
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

	public static void main(String[] args) throws FileNotFoundException, IOException, VentasException, InterruptedException, NotBoundException, PersistenciaException, ClassNotFoundException, ViandasException {
		try
		{ 
			Properties p = new Properties();
			String nomArch = "src/config/config.properties";
			p.load (new FileInputStream (nomArch));
			String ip = p.getProperty("ipServidor");
			String puerto = p.getProperty("puertoServidor");
			String ruta = "//" + ip + ":" + puerto + "/fachada";
			
			ICapaLogica capalogica = (ICapaLogica) Naming.lookup(ruta);
			
			//LocalDate ld = LocalDate.of(2021, 02, 20);
			//VOVenta _v = new VOVenta(ld, "Calle 134", true);
			//capalogica.altaVenta(_v);
			
			//VOVianda _via = new VOVianda("ACP", "Arroz con pollo", 150);
			//capalogica.altaVianda(_via);
			
			//capalogica.altaViandaxVenta("ACP", 1, 5);
			
			capalogica.respaldarInfo();
			
			ArrayList<VOVenta> listaVentas = capalogica.listarVentas();
			
			for(VOVenta v : listaVentas) {
				System.out.println(v.getNumero() + " - " + v.getDirEntrega() + " - " + v.getFecha() + " - $" + v.getMontoTotal()  + " - " + (v.getEnProc() ? "Si" : "No"));
			}
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
		/*catch (ViandasException e) {
			System.out.println(e.getMensajeViandaException());
		}*/
	}
}
