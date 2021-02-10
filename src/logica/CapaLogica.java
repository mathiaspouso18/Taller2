package logica;
import java.io.IOException;
import clases.ColeccionVentas;
import clases.ColeccionViandas;
import clases.*;
import java.util.*;

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
	
	public void AltaVenta(VOVenta v) {
		int numeroVenta = v.getNumero();
		Date fecha = v.getFecha();
		Venta ulventa = ventas.ultimaVenta();
		if(fecha.compareTo(ulventa.getFecha())<0) {
			String dir = v.getDirEntrega();
			Venta ve = new Venta(numeroVenta, fecha, dir);
			ventas.insertarVenta(ve);
		}else {
			//excepcion: La fecha no puede ser menor a la ultima venta ingresada
		}
	}
	
	public void AltaViandaxVenta(String codVianda, int numVenta, int cant) {
		if(ventas.existeVenta(numVenta)){
			Venta v = ventas.buscarVenta(numVenta);
			if(v.getEnProc()) {
				if(v.getTotalViandas() < 30){
					if(viandas.existeVianda(codVianda)) {
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
		}else {
			//excepcion: no existe vianda
		}
	}
	
	
	
	
}
