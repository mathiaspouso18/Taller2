package logica.ventas;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class ColeccionVentas implements Serializable{

	private static final long serialVersionUID = 1L;
	private static int _contador = 0;
	private LinkedList<Venta> Ventas;

	public ColeccionVentas() {
		Ventas = new LinkedList<Venta>();
		if(Ventas.size() > 0) {
			Venta ultimaVenta = Ventas.getLast();
			_contador = ultimaVenta.getNumeroVenta();
		}
	}

	public void insertarVenta(Venta _venta) {
		_contador++;
		_venta.setNumero(_contador);
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
	
	public void procesarVenta(int _numeroVenta, boolean _indicacion) {
		boolean encontre = false;
		Iterator<Venta> iter = Ventas.iterator();
		while(iter.hasNext() && !encontre) {
			Venta v = iter.next();
			if(v.getNumeroVenta() == (_numeroVenta)) {
				if(v.getCantViandas()!=null) {
					if(_indicacion) {
						v.setEnProc(!_indicacion);//enProc = false, por lo tanto está finalizada
					}else {
						this.eliminarVenta(v);
					}
				}else {
					this.eliminarVenta(v);
				}
				encontre = true;
			}
		}
	}
	
	public boolean esVacio() {
		return Ventas.size() == 0;
	}
	
	public Venta obtenerUltimaVenta() {
		return Ventas.getLast();
	}
	
	public void eliminarVenta(Venta v) {
		Ventas.remove(v);
	}

	public LinkedList<Venta> getVentas(){
		return Ventas;
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
