package logica.ventas;
import java.io.Serializable;
import java.time.LocalDateTime;

import logica.viandas.VOVianda;

public class VOViandasxVentas implements Serializable {

	private static final long serialVersionUID = 1L;
	private VOVianda vovianda;
	private int cant;
	
	public VOViandasxVentas() {
		
	}
	
	public VOViandasxVentas(VOVianda _vovianda, int _cant) {
		vovianda = _vovianda;
		cant = _cant;
	}
	
	public VOVianda getVOVianda() {
		return vovianda;
	}

	public int getCant() {
		return cant;
	}
}
