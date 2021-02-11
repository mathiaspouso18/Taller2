package logica;
import logica.ventas.*;
import logica.viandas.*;
import excepciones.*;
//import java.util.*;

public class CapaLogica {
	ColeccionViandas viandas;
	ColeccionVentas ventas;
	
	private static CapaLogica instance = null;
	
	public static CapaLogica getInstance() {
		if (instance == null) {
			instance = new CapaLogica();
		}
		return instance;
	}
	
	public CapaLogica(){
		viandas = new ColeccionViandas();
		ventas = new ColeccionVentas();
	}

	public void AltaVianda(VOVianda _vovianda) throws ViandasException {
		if(!viandas.existeVianda(_vovianda.getCodVianda())) {
			viandas.insertarVianda(_vovianda);
		}else {
			throw new ViandasException(1);
		}	
	}
	
	public void AltaVenta(VOVenta _voventa) throws VentasException{
		ventas.insertarVenta(_voventa);
	}
	
	public void AltaViandaxVenta(String codVianda, int numVenta, int cant) throws VentasException, ViandasException {
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
		}
		else {
			throw new VentasException(5);
		}
	}
	
	public void ReducirCantVianda(String codVianda, int cant, int numVenta) throws VentasException {
		if(ventas.existeVenta(numVenta)) {
			ventas.reducirCantViandas(numVenta, codVianda, cant);
		}else {
			throw new VentasException(5);
		}
	}
	
	public void ProcesarVenta(int numVenta, boolean indicacion) throws VentasException {
		if(ventas.existeVenta(numVenta)) {
			ventas.procesarVenta(numVenta, indicacion);
		}else {
			throw new VentasException(5);
		}
	}
	
	public void ListarVentas() {
		if(!ventas.esVacio())
			ventas.ToString();
	}
	
	public void  ListarViandasVenta(int numVenta) {
		
	}
	
	public void RespaldarInfo() {
		
	}
	
	public void RestaurarInfo() {
		
	}
	
	public void ListarViandas() {
		if(!viandas.esVacio())
			viandas.ToString();
	}
	
	public void ListarDatosVianda(String codVianda) throws ViandasException {
		if(!viandas.esVacio()) {
			if(viandas.existeVianda(codVianda)) {
				viandas.ListarDatos(codVianda);
			}else {
				throw new ViandasException(2);
			}
		}
	}
	
	public void ListarViandaxDescripcion(String descripcion) {
		if(!viandas.esVacio())
			viandas.ListarxDescripcion(descripcion);
	}
}
