package logica.ventas;

import java.util.*;

public class ColeccionCantVianda {
	private CantVianda [] CantViandas;
	private int tope;

	public ColeccionCantVianda() {
		CantViandas = new CantVianda[30];
		tope = 0;
	}

	public void insertarCantVianda(CantVianda _cantVianda) {
		CantViandas[tope] = _cantVianda;
		tope++;
	}

	/*public void setCantViandas(LinkedList<CantVianda> _cantViandas) {
		CantViandas = _cantViandas;
	}*/
	
	public int totalViandas() {
		int total = 0;
		for (CantVianda cv : CantViandas) {
			total+=cv.getCantidad();
		}
		return total;
	}

	public boolean existeCantVianda(String _codVianda) {
		boolean encontre = false;
		Iterator<CantVianda> iter = CantViandas.iterator();
		while(iter.hasNext() && !encontre) {
			CantVianda cv = iter.next();
			encontre = cv.getVianda().getCodVianda().equals(_codVianda);
		}
		return encontre;
	}
	
	public void reducirCant(String _codVianda, int _cantidad) {
		boolean encontre = false;
		Iterator<CantVianda> iter = CantViandas.iterator();
		while(iter.hasNext() && !encontre) {
			CantVianda cv = iter.next();
			if(cv.getVianda().getCodVianda().equals(_codVianda)) {
				int cant = cv.getCantidad();
				cant = cant - _cantidad;
				cv.setCantidad(cant);
				encontre = true;
			}
		}
	}
	
	public void aumentarCant(String _codVianda, int _cantidad) {
		boolean encontre = false;
		Iterator<CantVianda> iter = CantViandas.iterator();
		while(iter.hasNext() && !encontre) {
			CantVianda cv = iter.next();
			if(cv.getVianda().getCodVianda().equals(_codVianda)) {
				int cant = cv.getCantidad();
				cant = cant + _cantidad;
				cv.setCantidad(cant);
				encontre = true;
			}
		}
	}
	
	/*public CantVianda buscarCantVianda(String _codVianda) {
		boolean encontre = false;
		CantVianda cv = null;
		Iterator<CantVianda> iter = CantViandas.iterator();
		while(iter.hasNext() && !encontre) {
			cv = iter.next();
			encontre = cv.getVianda().getCodVianda().equals(_codVianda);
		}
		return cv;
	}*/
	
	public boolean esVacio() {
		return CantViandas.size() == 0;
	}
	
	
	/*public void eliminarCantViandas(CantVianda cv) {
		CantViandas.remove(cv);
	}*/

	public String ToString() {
		String retorno = "";
		for (CantVianda cv : CantViandas) {
			retorno = retorno + cv.ToString();
			retorno = retorno + "\n\n";
		}
		return retorno;
	}
}
