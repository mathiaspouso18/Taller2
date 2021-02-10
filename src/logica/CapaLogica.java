package logica;
import java.io.IOException;
import clases.ColeccionVentas;
import clases.ColeccionViandas;
import clases.ColeccionCantVianda;
import clases.*;
import java.util.*;

public class CapaLogica {
	ColeccionViandas viandas;
	ColeccionVentas ventas;
	ColeccionCantVianda viandasEnVenta;
	
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
		viandasEnVenta = new ColeccionCantVianda();
	}

	public void AltaVianda(VOVianda _vovianda) {
		String cod = _vovianda.getCodVianda();
		String desc = _vovianda.getDescripcion();
		int prec = _vovianda.getPrecio();
		Vianda v = new Vianda(cod, desc, prec);
		
		if(!viandas.existeVianda(cod))
			viandas.insertarVianda(v);
		//else
			//aca lanzo excepcion
	}
	
	public void AltaVenta(VOVenta v) {
		int numeroVenta = v.getNumero();
		Date fecha = v.getFecha();
		String dir = v.getDirEntrega();
		Venta ve = new Venta(numeroVenta, fecha, dir);
		ventas.insertarVenta(ve);
	}
	
	public void AltaViandaxVenta(String codVianda, int numVenta, int cant) {
		if(ventas.existeVenta(numVenta)){
			Venta v = ventas.buscarVenta(numVenta);
			if(v.getEnProc()) {
				if(v.getTotalViandas() < 30){
					if(v.)
				}
			}
		}
	}
	
	
}
