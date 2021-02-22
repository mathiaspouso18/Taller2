package servidor;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.BindException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Properties;

import excepciones.PersistenciaException;
import logica.CapaLogica;

public class MainServidor {
	public static void main(String[] args) throws ClassNotFoundException, IOException, PersistenciaException{
		try
		{ 
			Properties p = new Properties();
			String nomArch = "src/config/Config.properties";
			p.load (new FileInputStream (nomArch));
			String ip = p.getProperty("ipServidor");
			String puerto = p.getProperty("puertoServidor");
			int port = Integer.parseInt(puerto);
		
			//pongo a correr el rmiregistry
			LocateRegistry.createRegistry(port);
		
			//publico el objeto remoto en dicha ip y puerto
			String ruta = "//" + ip + ":" + puerto + "/fachada";
			CapaLogica fachada = new CapaLogica();
			System.out.println("Antes de publicar");
			Naming.rebind(ruta, fachada);
			System.out.println("Luego de publicar");
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
	}
}
