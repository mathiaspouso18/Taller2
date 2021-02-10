package logica.viandas;

import java.util.*;

public class ColeccionViandas {
	private TreeMap<String, Vianda> Viandas;

	public ColeccionViandas() {
		Viandas = new TreeMap<String, Vianda>();
	}

	public void insertarVianda(VOVianda _vovianda) {
		String key = _vovianda.getCodVianda();
		String desc = _vovianda.getDescripcion();
		int prec = _vovianda.getPrecio();
		Vianda v = new Vianda(key, desc, prec);
		Viandas.put(key, v);
	}

	public Vianda buscarVianda(String _codVianda) {
		Vianda _v;
		_v = Viandas.get(_codVianda);
		return _v;
	}

	public boolean existeVianda(String _codVianda) {
		return buscarVianda(_codVianda) != null;
	}
	
	public void ListarDatos(String _codVianda) {
		Vianda v = Viandas.get(_codVianda);
		v.ToString();
	}
	
	public void ListarxDescripcion(String _descripcion) {
		Iterator<Vianda> iter = Viandas.values().iterator();
		while (iter.hasNext()) {
			Vianda v = iter.next();
			String desc = v.getDescripcion();
			if(desc.contains(_descripcion)) {
				v.toString();
				System.out.println();
			}
		}
	}

	public void ToString() {
		for (Vianda v : Viandas.values()) {
			System.out.println(v.ToString());
			System.out.println();
		}
	}

	// Faltan los metodos que utilizan value objects
}
