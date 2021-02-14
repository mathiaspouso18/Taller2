package logica;
import logica.ventas.*;
import logica.viandas.*;
import persistencia.Respaldo;

import java.io.IOException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;

import monitor.*;

import excepciones.*;

//public class CapaLogica extends UnicastRemoteObject implements ICapaLogica {
public class CapaLogica{
		
	ColeccionViandas viandas;
	ColeccionVentas ventas;
	Respaldo respaldo;
	Monitor monitor;
	
	private static CapaLogica instance = null;
	
	public static CapaLogica getInstance() throws ClassNotFoundException, IOException, PersistenciaException {
		if (instance == null) {
			instance = new CapaLogica();
		}
		return instance;
	}
	
	public CapaLogica() throws ClassNotFoundException, IOException, PersistenciaException{
		respaldo = new Respaldo();
		viandas = new ColeccionViandas();
		ventas = new ColeccionVentas();
		
		viandas = respaldo.recuperar(respaldo.GetNombreArchivo());
		monitor = new Monitor();
	}

	public void altaVianda(VOVianda _vovianda) throws ViandasException, InterruptedException {
		String _codVianda = _vovianda.getCodVianda();
		if(!viandas.existeVianda(_codVianda)) {
			String _descripcion = _vovianda.getDescripcion();
			int _precio = _vovianda.getPrecio();
			if(_vovianda instanceof VOViandaVeg){
				boolean _esOvo = ((VOViandaVeg)_vovianda).getEsOvo();
				String _descAdic = ((VOViandaVeg)_vovianda).getDescAdic();
				ViandaVeg vv = new ViandaVeg(_codVianda, _descripcion, _precio, _esOvo, _descAdic);
				viandas.insertarVianda(vv);
			}
			else {
				Vianda v = new Vianda(_codVianda, _descripcion, _precio);
				viandas.insertarVianda(v);
			}
		}else {
			throw new ViandasException(1);
		}	
	}
	
	public void altaVenta(VOVenta _voventa) throws VentasException {
		int numeroVenta = _voventa.getNumero();
		String dir = _voventa.getDirEntrega();
		LocalDate fecha = _voventa.getFecha();
		if(ventas.esVacio()) {
			Venta ve = new Venta(numeroVenta, fecha, dir);
			ventas.insertarVenta(ve);
		}else {
			Venta ulventa = ventas.obtenerUltimaVenta();
			LocalDate ulfecha = ulventa.getFecha();
			if(fecha.compareTo(ulfecha)>0) {
				Venta ve = new Venta(numeroVenta, fecha, dir);
				ventas.insertarVenta(ve);
			}else {
				throw new VentasException(3);
			}
		}
	}
	
	public void altaViandaxVenta(String codVianda, int numVenta, int cant) throws VentasException, ViandasException {
		if(ventas.existeVenta(numVenta)){
				if(viandas.existeVianda(codVianda)) {
				Venta v = ventas.buscarVenta(numVenta);
				if(v.getEnProc()) {
					if(v.getTotalViandas() < 30){
						if(v.existeViandaxVenta(codVianda)) {
							v.aumentarCantidad(codVianda, cant);
						}else {
							Vianda v1 = viandas.buscarVianda(codVianda); 
							CantVianda cv = new CantVianda(v1, cant);
							v.insertCantVianda(cv);
						}
					}else {
						throw new VentasException(4);
					}
				}else {
					throw new VentasException(2);
				}
			}else {
				throw new ViandasException(2);
			}
		}else {
			throw new VentasException(5);
		}
	}
	
	public void reducirCantVianda(String codVianda, int cant, int numVenta) throws VentasException, ViandasException {
		if(ventas.existeVenta(numVenta)){
			Venta v = ventas.buscarVenta(numVenta);
			if(v.getEnProc()) {
				if(v.getTotalViandas() < 30){
						if(v.existeViandaxVenta(codVianda)) {
							v.reducirCantidad(codVianda, cant);
							if(v.getTotalViandas() == 0) {
								ventas.eliminarVenta(v);
							}
						}else {
							throw new VentasException(6);
						}
					}else {
						throw new VentasException(4);
					}
				}else {
					throw new VentasException(2);
				}
		}else {
			throw new VentasException(5);
		}
	}
	
	/*public void procesarVenta(int numVenta, boolean indicacion) throws VentasException { ORIGINAL
		if(ventas.existeVenta(numVenta)) {
			Venta v = ventas.buscarVenta(numVenta);
			if(v.getTotalViandas() == 0) {
				ventas.eliminarVenta(v);
			}else {
				ventas.procesarVenta(numVenta, indicacion);
			}
		}else {
			throw new VentasException(5);
		}
	}*/
	
	public void procesarVenta(int numVenta, boolean indicacion) throws VentasException {
		if(ventas.existeVenta(numVenta)) {
			ventas.procesarVenta(numVenta, indicacion);
		}else {
			throw new VentasException(5);
		}
	}
	
	public void confirmarCancelar() {
		
	}
	
	public void listarVentas() {
		if(!ventas.esVacio()) {
			System.out.println(ventas.ToString());
		}else {
			System.out.println("No hay ventas ingresadas en el sistema"); 
		}
	}
	
	public void listarViandasVenta(int numVenta) throws VentasException {
		if(ventas.existeVenta(numVenta)) {
			Venta v = ventas.buscarVenta(numVenta);
			if(v.getTotalViandas()> 0)
				System.out.println(v.listarViandasVenta());
			else
				System.out.println("No hay viandas en esa venta"); 
		}
		else {
			throw new VentasException(5);
		}
		
	}
	
	public void respaldarInfo() throws PersistenciaException, IOException {
		
		respaldo.respaldar(respaldo.GetNombreArchivo(), viandas);
	}
	
	public void restaurarInfo() throws ClassNotFoundException, IOException, PersistenciaException {
		viandas = new ColeccionViandas();
		viandas = respaldo.recuperar(respaldo.GetNombreArchivo());
		
	}
	
	public void listarViandas() {
		if(!viandas.esVacio()) {
			System.out.println(viandas.ToString());
		}else {
			System.out.println("No hay viandas ingresadas en el sistema"); 
		}
	}
	
	public void listarDatosVianda(String codVianda) throws ViandasException {
		if(!viandas.esVacio()) {
			if(viandas.existeVianda(codVianda)) {
				viandas.ListarDatosVianda(codVianda);
			}else {
				throw new ViandasException(2);
			}
		}else {
			System.out.println("No hay viandas ingresadas en el sistema"); 
		}
	}
	
	public void listarViandaxDescripcion(String descripcion) {
		if(!viandas.esVacio()) {
			viandas.ListarxDescripcion(descripcion);
		}else {
			System.out.println("No hay viandas ingresadas en el sistema"); 
		}
	}
}
