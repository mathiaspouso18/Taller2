package logica.ventas;

import java.util.*;

public class ColeccionCantVianda {
	private LinkedList<CantVianda> CantViandas;

	public ColeccionCantVianda() {
		CantViandas = new LinkedList<CantVianda>();
	}

	public void insertarCantVianda(CantVianda _cantVianda) {
		CantViandas.addLast(_cantVianda);
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
				if(cant <= 0) {
					CantViandas.remove(cv);
				}else {
					cv.setCantidad(cant);
				}
				encontre = true;
			}
		}
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
