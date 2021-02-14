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
		int i = 0;
		
		while(i < tope) {
			total += CantViandas[i].getCantidad();
			i++;
		}
		return total;
	}

	public boolean existeCantVianda(String _codVianda) {
		boolean encontre = false;
		int i = 0;
		
		while(i < tope && !encontre) {
			CantVianda cv = CantViandas[i];
			encontre = cv.getVianda().getCodVianda().equals(_codVianda);
			i++;
		}
		return encontre;
	}
	
	public void reducirCant(String _codVianda, int _cantidad) {
		boolean encontre = false;
		int i = 0;
		
		while(i < tope && !encontre) {
			CantVianda cv = CantViandas[i];
			if(cv.getVianda().getCodVianda().equals(_codVianda)) {
				int cant = cv.getCantidad();
				cant = cant - _cantidad;
				cv.setCantidad(cant);
				encontre = true;
			}
			i++;
		}
	}
	
	public void aumentarCant(String _codVianda, int _cantidad) {
		boolean encontre = false;
		int i = 0;
		
		while(i < tope && !encontre) {
			CantVianda cv = CantViandas[i];
			if(cv.getVianda().getCodVianda().equals(_codVianda)) {
				int cant = cv.getCantidad();
				cant = cant + _cantidad;
				cv.setCantidad(cant);
				encontre = true;
			}
			i++;
		}
	}
	
	public CantVianda buscarCantVianda(String _codVianda) {
		boolean encontre = false;
		int i = 0;
		CantVianda cv = null;
		while(i < tope && !encontre) {
			cv = CantViandas[i];
			if(cv.getVianda().getCodVianda().equals(_codVianda)) {
				encontre = true;
			}
			i++;
		}
		return cv;
	}
	
	public boolean esVacio() {
		return tope == 0;
	}
	
	
	/*public void eliminarCantViandas(CantVianda cv) {
		CantViandas.remove(cv);
	}*/

	public String ToString() {
		String retorno = "";
		int i = 0;
		
		while(i < tope) {
			CantVianda cv = CantViandas[i];
			retorno = retorno + cv.ToString();
			retorno = retorno + "\n\n";
			i++;
		}
		return retorno;
	}
}
