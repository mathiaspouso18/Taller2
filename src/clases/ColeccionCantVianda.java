package clases;

import java.util.*;

import java.util.ListIterator;

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

	public void ToString() {
		for (CantVianda cv : CantViandas) {
			System.out.println(cv.ToString());
			System.out.println();
		}
	}
}
