package logica;
import logica.ventas.*;
import logica.viandas.*;
import java.io.IOException;

import java.util.*;
//import logica.ventas.ColeccionVentas;
//import logica.ventas.VOVenta;
//import logica.ventas.Venta;
//import logica.viandas.ColeccionViandas;
//import logica.viandas.VOVianda;

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

	public void AltaVianda(VOVianda _vovianda) {
		//String cod = _vovianda.getCodVianda();
		//String desc = _vovianda.getDescripcion();
		//int prec = _vovianda.getPrecio();
		//Vianda v = new Vianda(cod, desc, prec);
		if(!viandas.existeVianda(_vovianda.getCodVianda())) {
			viandas.insertarVianda(_vovianda);
		}else {
			//excepcion: ya existe la vianda
		}	
	}
	
	public void AltaVenta(VOVenta _voventa) {
		//int numeroVenta = _voventa.getNumero();
		//Date fecha = _voventa.getFecha();
		//Date ulventa = ventas.ultimaVenta().getFecha();
		//if(fecha.compareTo(ulventa)<0) {
			//String dir = _voventa.getDirEntrega();
			//Venta ve = new Venta(numeroVenta, fecha, dir);
		ventas.insertarVenta(_voventa);
		//}else {
			//excepcion: La fecha no puede ser menor a la ultima venta ingresada
		//}
	}
	
	public void AltaViandaxVenta(String codVianda, int numVenta, int cant) {
		if(ventas.existeVenta(numVenta)){
			Venta v = ventas.buscarVenta(numVenta);
			if(v.getEnProc()) {
				if(v.getTotalViandas() < 30){
					
						if(true) {
							//Ingreso la venta
						}else {
							Vianda v1 =viandas.buscarVianda(codVianda);
							//La agrego con la cant que ingresó el usuario
						}
						
					}else {
						//excepcion: No existe vianda con ese codigo
					}
				}else {
					//excepcion: se llego al maximo de viandas por venta
				}
			}else {
				//excepcion: la venta no esta en proceso
			}
	}
	
	public void ReducirCantVianda(String codVianda, int cant, int numVenta) {
		if(ventas.existeVenta(numVenta)) {
			ventas.reducirCantViandas(numVenta, codVianda, cant);
		}else {
			//excepcion: no existe una venta con ese numero
		}
	}
	
	public void ProcesarVenta(int numVenta, boolean indicacion) {
		if(ventas.existeVenta(numVenta)) {
			ventas.procesarVenta(numVenta, indicacion);
		}else {
			//excepcion: no existe una venta con ese numero
		}
	}
	
	public void ListarVentas() {
		ventas.ToString();
	}
	
	public void  ListarViandasVenta(int numVenta) {
		
	}
	
	public void RespaldarInfo() {
		
	}
	
	public void RestaurarInfo() {
		
	}
	
	public void ListarViandas() {
		viandas.toString();
	}
	
	public void ListarDatosVianda(String codVianda) {
		if(viandas.existeVianda(codVianda)) {
			viandas.ListarDatos(codVianda);
		}else {
			//excepcion: No existe la vianda a listar
		}
	}
	
	public void ListarViandaxDescripcion(String codVianda) {
		
	}
	
	
	
	
	
}
