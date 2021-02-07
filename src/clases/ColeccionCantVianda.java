package clases;
import java.util.*;

public class ColeccionCantVianda {
	private LinkedList<CantVianda> CantViandas;
	
	public ColeccionCantVianda() {
		CantViandas = new LinkedList<CantVianda>();
	}
	
	public LinkedList<CantVianda> getCantViandas() {
		return CantViandas;
	}
	
	public void setCantViandas(LinkedList<CantVianda> _cantViandas){
		CantViandas = _cantViandas;
	}
}
