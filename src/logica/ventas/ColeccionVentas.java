package logica.ventas;
import java.util.Iterator;
import java.util.LinkedList;

public class ColeccionVentas {
	private LinkedList<Venta> Ventas;

	public ColeccionVentas() {
		Ventas = new LinkedList<Venta>();
	}

	public void insertarVenta(Venta _venta) {
			Ventas.add(_venta);
	}

	public Venta buscarVenta(int numeroVenta) {
		return Ventas.get(numeroVenta - 1);
	}

	public boolean existeVenta(int numeroVenta) {
		boolean existe = false;
		if(numeroVenta-1 < Ventas.size()) {
			if(Ventas.get(numeroVenta - 1) != null)
				existe = true;
		}
		return existe;
	}
	
	/*public void reducirCantViandas(int _numeroVenta, String _codVianda, int _cant) throws VentasException {
		Venta ve = this.buscarVenta(_numeroVenta);
		if(ve.getEnProc()) {
			ve.reducirCantidad(_codVianda, _cant);
		}else {
			throw new VentasException(2);
		}
	}*/
	
	public void procesarVenta(int _numeroVenta, boolean _indicacion) {
		boolean encontre = false;
		Iterator<Venta> iter = Ventas.iterator();
		while(iter.hasNext() && !encontre) {
			Venta v = iter.next();
			if(v.getNumeroVenta() == (_numeroVenta)) {
				if(_indicacion) {
					v.setEnProc(true);
				}else {
					Ventas.remove(v);
				}
				encontre = true;
			}
		}
	}
	
	public boolean esVacio() {
		return Ventas.size() == 0;
	}
	
	/*public int largoColeccion() {
		return Ventas.size();
	}*/
	
	public Venta obtenerUltimaVenta() {
		return Ventas.getLast();
	}
	
	public void eliminarVenta(Venta v) {
		Ventas.remove(v);
	}

	public String ToString() {
		String retorno = "";
		Iterator<Venta> iter = Ventas.iterator();
		while(iter.hasNext()) {
			retorno = retorno + iter.next().ToString();
			retorno = retorno + "\n\n";
		}
		return retorno;
	}
}
