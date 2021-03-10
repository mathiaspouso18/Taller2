package logica.viandas;

import java.io.Serializable;
import java.util.*;

public class ColeccionViandas implements Serializable {

	private static final long serialVersionUID = 1L;
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
	
	public TreeMap<String, Vianda> getViandas(){
		return Viandas;
	}
	
	public boolean esVacio() {
		return Viandas.size() == 0;
	}
	
	public String ToString() {
		String retorno = "";
		for (Vianda v : Viandas.values()) {
			if(v instanceof Vianda) {
				retorno = retorno +  v.ToString();
				retorno = retorno + "\n\n";
			}
			else {
				retorno = retorno + ((ViandaVeg)v).ToString();
				retorno = retorno + "\n\n";
			}
		}
		return retorno;
	}
}
