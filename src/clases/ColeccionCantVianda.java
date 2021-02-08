package clases;
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
	
	public void setCantViandas(LinkedList<CantVianda> _cantViandas){
		CantViandas = _cantViandas;
	}
	
	public void ToString() {
		for(CantVianda cv : CantViandas) {
			System.out.println(cv.ToString());
			System.out.println();
		}
	}
}
