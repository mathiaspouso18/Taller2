//import java.net.BindException;
//import java.net.MalformedURLException;
//import java.rmi.Naming;
import java.rmi.NotBoundException;
//import java.rmi.RemoteException;
//import java.rmi.registry.LocateRegistry;
//import java.time.*;
//import java.util.ArrayList;
//import java.util.Properties;

//import javax.swing.JFrame;

//import java.awt.EventQueue;
import java.io.*;
import excepciones.PersistenciaException;
import excepciones.VentasException;
import excepciones.ViandasException;
//import logica.CapaLogica;
//import logica.ICapaLogica;
//import logica.ventas.*;
//import logica.viandas.*;
import grafica.views.Principal;


public class Main {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, VentasException, InterruptedException, NotBoundException, PersistenciaException, ClassNotFoundException, ViandasException {	 
		try {
			Principal window = new Principal();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
