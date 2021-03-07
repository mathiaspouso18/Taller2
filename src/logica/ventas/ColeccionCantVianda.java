package logica.ventas;

import java.io.Serializable;

public class ColeccionCantVianda implements Serializable {
	private static final long serialVersionUID = 1L; //Esto va?
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
				if(cv.getCantidad() <= 0) {
					eliminarCantViandas(_codVianda);
				}
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
	
	public void eliminarCantViandas(String _codVianda) {
		int i = 0, j = 0;
		boolean encontre = false;
		while(i < tope && !encontre) {
			if(CantViandas[i].getVianda().getCodVianda().toLowerCase().equals(_codVianda.toLowerCase())) {
				encontre = true;
				i++;
			}
		}
		
		if(encontre) {
			j = i;
			while(j < tope - 1) {
				CantViandas[j] = CantViandas[j+1];
				j++;
			}
			tope--;
		}
	}
	
	public CantVianda [] getViandas() {
		return CantViandas;
	}
	
	public int getLargo() {
		return tope;
	}
	
	public int getMontoTotal() {
		int total = 0;
		int i = 0;
		while(i < tope) {
			int precioVianda = CantViandas[i].getVianda().getPrecio();
			int cantidad = CantViandas[i].getCantidad();
			total = total + (precioVianda * cantidad);
			i++;
		}
		return total;
	}

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
