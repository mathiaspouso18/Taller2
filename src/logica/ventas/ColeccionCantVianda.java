package logica.ventas;

import java.util.*;

public class ColeccionCantVianda {
	private LinkedList<CantVianda> CantViandas;

	public ColeccionCantVianda() {
		CantViandas = new LinkedList<CantVianda>();
	}

	public void insertarVianda(CantVianda _cantVianda) {
		CantViandas.addLast(_cantVianda);
	}

	public LinkedList<CantVianda> getCantViandas() {
		return CantViandas;
	}

	public void setCantViandas(LinkedList<CantVianda> _cantViandas) {
		CantViandas = _cantViandas;
	}
	
	public int totalViandas() {
		int total = 0;
		for (CantVianda cv : CantViandas) {
			total+=cv.getCantidad();
		}
		return total;
	}

	public boolean existeCantVianda(String _codVianda) {
		for(CantVianda cv: CantViandas) {
			if(cv.getVianda().getCodVianda().equals(_codVianda) ) {
				return true;
			}
		}
		return false;
	}
	
	
	public void eliminarCantViandas() {
		
	}

	public void ToString() {
		for (CantVianda cv : CantViandas) {
			System.out.println(cv.ToString());
			System.out.println();
		}
	}
}
