package logica;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import excepciones.PersistenciaException;
import excepciones.VentasException;
import excepciones.ViandasException;
import logica.ventas.VOVenta;
import logica.viandas.VOVianda;

public interface ICapaLogica extends Remote {
	
	public void altaVianda(VOVianda _vianda) throws ViandasException, InterruptedException, RemoteException;
	public void altaVenta(VOVenta _voventa) throws VentasException, InterruptedException, RemoteException;
	public void altaViandaxVenta(String codVianda, int numVenta, int cant) throws VentasException, ViandasException, InterruptedException, RemoteException;
	public void reducirCantVianda(String codVianda, int cant, int numVenta) throws VentasException, ViandasException, RemoteException;
	public void procesarVenta(int numVenta, boolean indicacion) throws VentasException, RemoteException;
	public void listarVentas() throws InterruptedException, VentasException, RemoteException;
	public void listarViandasVenta(int numVenta) throws VentasException, InterruptedException, RemoteException;
	public void respaldarInfo() throws PersistenciaException, IOException, RemoteException;
	public void restaurarInfo() throws ClassNotFoundException, IOException, PersistenciaException, RemoteException;
	public void listarViandas() throws ViandasException, InterruptedException, RemoteException;
	public void listarDatosVianda(String codVianda) throws ViandasException, InterruptedException, RemoteException;
	public void listarViandaxDescripcion(String descripcion) throws ViandasException, InterruptedException, RemoteException;
}
