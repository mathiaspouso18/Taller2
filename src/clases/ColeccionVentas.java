package clases;

import java.util.ArrayList;

public class ColeccionVentas {
	private ArrayList<Venta> Ventas;
	
	public ColeccionVentas() {
		Ventas = new ArrayList<Venta>();
	}
	
	public void insertarVenta(Venta _venta) {
		Ventas.add(_venta);
	}
	
	public Venta buscarVenta(int numeroVenta) {
		return Ventas.get(numeroVenta);
	}
	
	public boolean existeVenta(int numeroVenta) {
		return buscarVenta(numeroVenta) != null;
	}
}
