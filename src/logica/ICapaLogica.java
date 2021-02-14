package logica;

import java.io.IOException;
import java.rmi.Remote;

import excepciones.PersistenciaException;
import excepciones.VentasException;
import excepciones.ViandasException;
import logica.ventas.VOVenta;
import logica.viandas.VOVianda;

public interface ICapaLogica extends Remote {
	
	public void altaVianda(VOVianda _vianda) throws ViandasException, InterruptedException;
	public void altaVenta(VOVenta _voventa) throws VentasException;
	public void altaViandaxVenta(String codVianda, int numVenta, int cant) throws VentasException, ViandasException;
	public void reducirCantVianda(String codVianda, int cant, int numVenta) throws VentasException, ViandasException;
	public void procesarVenta(int numVenta, boolean indicacion) throws VentasException;
	public void listarVentas();
	public void listarViandasVenta(int numVenta) throws VentasException;
	public void respaldarInfo() throws PersistenciaException, IOException;
	public void restaurarInfo() throws ClassNotFoundException, IOException, PersistenciaException;
	public void listarViandas();
	public void listarDatosVianda(String codVianda) throws ViandasException;
	public void listarViandaxDescripcion(String descripcion);
}
