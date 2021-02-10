package clases;

import java.util.*;

public class ColeccionViandas {
	private TreeMap<String, Vianda> Viandas;

	public ColeccionViandas() {
		Viandas = new TreeMap<String, Vianda>();
	}

	public void insertarVianda(Vianda _vianda) {
		String key = _vianda.getCodVianda();
		Viandas.put(key, _vianda);
	}

	public Vianda buscarVianda(String _codVianda) {
		Vianda _v;
		_v = Viandas.get(_codVianda);
		return _v;
	}

	public boolean existeVianda(String _codVianda) {
		return buscarVianda(_codVianda) != null;
	}

	public void ToString() {
		for (Vianda v : Viandas.values()) {
			System.out.println(v.ToString());
			System.out.println();
		}
	}

	// Faltan los metodos que utilizan value objects
}
