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
			
			
			
			/*CapaLogica cp = new CapaLogica();
			
			VOViandaVeg _via = new VOViandaVeg("ACS", "Arroz con Seitan", 150, true, "Nada raro");
			cp.altaVianda(_via);
			
			LocalDate ld = LocalDate.of(2021, 02, 20);
			VOVenta _v = new VOVenta(ld, "Calle 134", true);
			cp.altaVenta(_v);
			cp.listarVentas();			
			
			
			//VOVianda _via2 = new VOVianda("ACP", "Arroz con pollo", 230);
			//cp.altaVianda(_via2);
			cp.listarViandas();*/
			
			//capalogica.altaViandaxVenta("ACS", 1, 1);
			//capalogica.altaViandaxVenta("ACP", 1, 3);
			
			//capalogica.respaldarInfo();
			
			//capalogica.reducirCantVianda("S", 5, 1);
			

			ArrayList<VOVianda> listaViandas = capalogica.listarViandas();
			ArrayList<VOVenta> listaVentas = capalogica.listarVentas();
			ArrayList<VOVianda> listaViandasEnVenta = capalogica.listarViandasVenta(1);
			
			for(VOVianda vi : listaViandas) {
				if(vi instanceof VOViandaVeg) {
					System.out.println(((VOViandaVeg)vi).getCodVianda() + " - " + ((VOViandaVeg)vi).getDescripcion() + " - $" + ((VOViandaVeg)vi).getPrecio() + " - " + ((VOViandaVeg)vi).getEsOvo()  + " - " + ((VOViandaVeg)vi).getDescAdic());
				}else {
					System.out.println("Soy no veg");
					System.out.println(vi.getCodVianda() + " - " + vi.getDescripcion() + " - $" + vi.getPrecio());
				}
			}
			
			for(VOVenta v : listaVentas) {
				System.out.println(v.getNumero() + " - " + v.getDirEntrega() + " - " + v.getFecha() + " - $" + v.getMontoTotal()  + " - " + (v.getEnProc() ? "Si" : "No"));
			}
			
			for(VOVianda vi : listaViandasEnVenta) {
				if(vi instanceof VOViandaVeg) {
					System.out.println(((VOViandaVeg)vi).getCodVianda() + " - " + ((VOViandaVeg)vi).getDescripcion() + " - $" + ((VOViandaVeg)vi).getPrecio() + " - " + ((VOViandaVeg)vi).getEsOvo()  + " - " + ((VOViandaVeg)vi).getDescAdic());
				}else {
					System.out.println(vi.getCodVianda() + " - " + vi.getDescripcion() + " - $" + vi.getPrecio());
				}
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
		catch (ViandasException e) {
			System.out.println(e.getMensajeViandaException());
		}
	}
}
