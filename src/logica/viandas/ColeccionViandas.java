package logica.viandas;

import java.util.*;

public class ColeccionViandas {
	private TreeMap<String, Vianda> Viandas;

	public ColeccionViandas() {
		Viandas = new TreeMap<String, Vianda>();
	}

	public void insertarVianda(Vianda _vovianda) {
		String key = _vovianda.getCodVianda();
		String desc = _vovianda.getDescripcion();
		int prec = _vovianda.getPrecio();
		if(_vovianda instanceof ViandaVeg){
			boolean esOvo = ((ViandaVeg)_vovianda).getEsOvo();
			String descAdic = ((ViandaVeg)_vovianda).getDescAdic();
			ViandaVeg v = new ViandaVeg(key, desc, prec, esOvo, descAdic);
			Viandas.put(key, v);
		}
		else {
			Vianda v = new Vianda(key, desc, prec);
			Viandas.put(key, v);
		}
	}

	public Vianda buscarVianda(String _codVianda) {
		Vianda _v;
		_v = Viandas.get(_codVianda);
		return _v;
	}

	public boolean existeVianda(String _codVianda) {
		return buscarVianda(_codVianda) != null;
	}
	
	public boolean esVacio() {
		return Viandas.size() == 0;
	}
	
	public int largoColeccion() {
		return Viandas.size();
	}
	
	public void ListarDatosVianda(String _codVianda) {
		Vianda v = Viandas.get(_codVianda);
		System.out.println(v.ToString());
	}
	
	public void ListarxDescripcion(String _descripcion) {		
		for(Vianda v : Viandas.values()) {
			String desc = v.getDescripcion();
			if(desc.contains(_descripcion)) {
				System.out.println(v.ToString());
				System.out.println();
			}
		}
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
