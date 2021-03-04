package logica;
import logica.ventas.*;
import logica.viandas.*;
import persistencia.Respaldo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

import monitor.*;

import excepciones.*;

public class CapaLogica extends UnicastRemoteObject implements ICapaLogica {
	private static final long serialVersionUID = 1L;
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
		monitor = new Monitor();
		
		restaurarInfo();
	}

	public void altaVianda(VOVianda _vovianda) throws ViandasException, InterruptedException {
		monitor.comienzoEscritura();
		String _codVianda = _vovianda.getCodVianda();
		if(!viandas.existeVianda(_codVianda)) {
			String _descripcion = _vovianda.getDescripcion();
			int _precio = _vovianda.getPrecio();
			if(_vovianda instanceof VOViandaVeg){
				boolean _esOvo = ((VOViandaVeg)_vovianda).getEsOvo();
				String _descAdic = ((VOViandaVeg)_vovianda).getDescAdic();
				ViandaVeg vv = new ViandaVeg(_codVianda, _descripcion, _precio, _esOvo, _descAdic);
				viandas.insertarVianda(vv);
				monitor.terminoEscritura();
			}
			else {
				Vianda v = new Vianda(_codVianda, _descripcion, _precio);
				viandas.insertarVianda(v);
				monitor.terminoEscritura();
			}
		}else {
			monitor.terminoEscritura();
			throw new ViandasException(1);
		}	
	}
	
	public void altaVenta(VOVenta _voventa) throws VentasException, InterruptedException {
		monitor.comienzoEscritura();
		int numeroVenta = _voventa.getNumero();
		String dir = _voventa.getDirEntrega();
		LocalDateTime fecha = _voventa.getFecha();
		if(ventas.esVacio()) {
			Venta ve = new Venta(numeroVenta, fecha, dir);
			ventas.insertarVenta(ve);
			monitor.terminoEscritura();
		}else {
			Venta ulventa = ventas.obtenerUltimaVenta();
			LocalDateTime ulfecha = ulventa.getFecha();
			if(fecha.compareTo(ulfecha)>0) {
				Venta ve = new Venta(numeroVenta, fecha, dir);
				ventas.insertarVenta(ve);
				monitor.terminoEscritura();
			}else {
				monitor.terminoEscritura();
				throw new VentasException(3);
			}
		}
	}
	
	public void altaViandaxVenta(String codVianda, int numVenta, int cant) throws VentasException, ViandasException, InterruptedException {
		monitor.comienzoEscritura();
		if(ventas.existeVenta(numVenta)){
				if(viandas.existeVianda(codVianda)) {
				Venta v = ventas.buscarVenta(numVenta);
				if(v.getEnProc()) {
					if(v.getTotalViandas() < 30){
						if(v.existeViandaxVenta(codVianda)) {
							v.aumentarCantidad(codVianda, cant);
							monitor.terminoEscritura();
						}else {
							Vianda v1 = viandas.buscarVianda(codVianda); 
							CantVianda cv = new CantVianda(v1, cant);
							v.insertCantVianda(cv);
							monitor.terminoEscritura();
						}
					}else {
						monitor.terminoEscritura();
						throw new VentasException(4);
					}
				}else {
					monitor.terminoEscritura();
					throw new VentasException(2);
				}
			}else {
				monitor.terminoEscritura();
				throw new ViandasException(2);
			}
		}else {
			monitor.terminoEscritura();
			throw new VentasException(5);
		}
	}
	
	public void reducirCantVianda(String codVianda, int cant, int numVenta) throws VentasException, ViandasException, InterruptedException {
		monitor.comienzoEscritura();
		if(ventas.existeVenta(numVenta)){
			Venta v = ventas.buscarVenta(numVenta);
			if(v.getEnProc()) {
				if(v.getTotalViandas() < 30){
						if(v.existeViandaxVenta(codVianda)) {
							v.reducirCantidad(codVianda, cant);
							if(v.getTotalViandas() == 0) {
								ventas.eliminarVenta(v);
							}
							monitor.terminoEscritura();
						}else {
							monitor.terminoEscritura();
							throw new VentasException(6);
						}
					}else {
						monitor.terminoEscritura();
						throw new VentasException(4);
					}
				}else {
					monitor.terminoEscritura();
					throw new VentasException(2);
				}
		}else {
			monitor.terminoEscritura();
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
	
	public void procesarVenta(int numVenta, boolean indicacion) throws VentasException, InterruptedException {
		monitor.comienzoEscritura();
		if(ventas.existeVenta(numVenta)) {
			ventas.procesarVenta(numVenta, indicacion);
			monitor.terminoEscritura();
		}else {
			monitor.terminoEscritura();
			throw new VentasException(5);
		}
	}
	
	public ArrayList<VOVenta> listarVentas() throws InterruptedException, VentasException {
		monitor.comienzoLectura();
		ArrayList<VOVenta> listaVentas = new ArrayList<>();
		if(!ventas.esVacio()) {
			Iterator<Venta> iterador = ventas.getVentas().iterator();
			
			while(iterador.hasNext()) {
				Venta _v = iterador.next();
				VOVenta _vo = new VOVenta(_v.getFecha(), _v.getDirEntrega(), _v.getEnProc());
				_vo.setNumero(_v.getNumeroVenta());
				_vo.setMontoTotal(_v.getMontoTotal());
				listaVentas.add(_vo);
			}
			monitor.terminoLectura();
		}else {
			monitor.terminoLectura();
			throw new VentasException(8);
		}
		
		return listaVentas;
	}
	
	public ArrayList<VOVianda> listarViandasVenta(int numVenta) throws VentasException, InterruptedException {
		monitor.comienzoLectura();
		ArrayList<VOVianda> listaViandas;
		if(ventas.existeVenta(numVenta)) {
			Venta v = ventas.buscarVenta(numVenta);
			if(v.getTotalViandas()> 0) {
				listaViandas = new ArrayList<>();
				CantVianda[] viandas = v.getCantViandas().getViandas();
				int i = 0;
				int tope = v.getCantViandas().getLargo();
				
				while(i < tope) {
					Vianda vi = viandas[i].getVianda();
					if(vi instanceof ViandaVeg) {
						ViandaVeg vv = (ViandaVeg) vi;
						VOViandaVeg _vv = new VOViandaVeg(vv.getCodVianda(), vv.getDescripcion(), vv.getPrecio(), vv.getEsOvo(), vv.getDescAdic());
						listaViandas.add(_vv);
					}
					else {
						VOVianda _v = new VOVianda(vi.getCodVianda(), vi.getDescripcion(), vi.getPrecio());
						listaViandas.add(_v);
					}
					i++;
				}
				
				monitor.terminoLectura();
			}
			else {
				monitor.terminoLectura();
				throw new VentasException(7);
			}
		}
		else {
			monitor.terminoLectura();
			throw new VentasException(5);
		}
		return listaViandas;
	}
	
	public void respaldarInfo() throws PersistenciaException, IOException {
		respaldo.respaldar(respaldo.GetNombreArchivo(), ventas, viandas);
	}
	
	public void restaurarInfo() throws ClassNotFoundException, IOException, PersistenciaException {
		try {
			
			FileInputStream f = new FileInputStream(respaldo.GetNombreArchivo());
			ObjectInputStream o = new ObjectInputStream(f);
			viandas = (ColeccionViandas)o.readObject();
			ventas = (ColeccionVentas)o.readObject();
			o.close();
			f.close();
		}
		catch(IOException ioe){
			ventas = new ColeccionVentas();
			viandas = new ColeccionViandas();
		}
	}
	
	public ArrayList<VOVianda> listarViandas() throws ViandasException, InterruptedException {
		monitor.comienzoLectura();
		ArrayList<VOVianda> listaViandas;
		if(!viandas.esVacio()) {
			listaViandas = new ArrayList<>();
			Iterator<Vianda> iterador = viandas.getViandas().values().iterator();
			
			while(iterador.hasNext()) {
				Vianda v = iterador.next();
				if(v instanceof ViandaVeg) {
					ViandaVeg vv = (ViandaVeg)v;
					VOViandaVeg _vv = new VOViandaVeg(vv.getCodVianda(), vv.getDescripcion(), vv.getPrecio(), vv.getEsOvo(), vv.getDescAdic());
					listaViandas.add(_vv);
				}
				else {
					VOVianda _v = new VOVianda(v.getCodVianda(), v.getDescripcion(), v.getPrecio());
					listaViandas.add(_v);
				}
			}
			monitor.terminoLectura();
		}else {
			monitor.terminoLectura();
			throw new ViandasException(3);
		}
		return listaViandas;
	}
	
	public VOVianda listarDatosVianda(String codVianda) throws ViandasException, InterruptedException {
		monitor.comienzoLectura();
		VOVianda vo;
		if(!viandas.esVacio()) {
			if(viandas.existeVianda(codVianda)) {
				Vianda v = viandas.buscarVianda(codVianda);
				if(v instanceof ViandaVeg) {
					vo = new VOViandaVeg(v.getCodVianda(), v.getDescripcion(), v.getPrecio(), ((ViandaVeg) v).getEsOvo(), ((ViandaVeg) v).getDescAdic());
				}else {
					vo = new VOVianda(v.getCodVianda(), v.getDescripcion(), v.getPrecio());
				}
				monitor.terminoLectura();
			}else {
				monitor.terminoLectura();
				throw new ViandasException(2);
			}
		}else {
			monitor.terminoLectura();
			throw new ViandasException(3);
		}
		return vo;
	}
	
	public ArrayList<VOVianda> listarViandaxDescripcion(String descripcion) throws ViandasException, InterruptedException {
		monitor.comienzoLectura();
		ArrayList<VOVianda> listaViandas;
		if(!viandas.esVacio()) {
			listaViandas = new ArrayList<>();
			Iterator<Vianda> iterador = viandas.getViandas().values().iterator();
			while(iterador.hasNext()) {
				Vianda v = iterador.next();
				if(v.getDescripcion().toLowerCase().contains(descripcion.toLowerCase())) {
					if(v instanceof ViandaVeg) {
						ViandaVeg vv = (ViandaVeg)v;
						VOViandaVeg _vv = new VOViandaVeg(vv.getCodVianda(), vv.getDescripcion(), vv.getPrecio(), vv.getEsOvo(), vv.getDescAdic());
						listaViandas.add(_vv);
					}
					else {
						VOVianda _v = new VOVianda(v.getCodVianda(), v.getDescripcion(), v.getPrecio());
						listaViandas.add(_v);
					}
				}
			}
			monitor.terminoLectura();
		}else {
			monitor.terminoLectura();
			throw new ViandasException(3);
		}
		
		return listaViandas;
	}
}
