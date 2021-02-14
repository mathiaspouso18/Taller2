 package logica.ventas;
 import logica.viandas.*;

public class CantVianda {
	private Vianda vianda;
	private int cantidad;

	public CantVianda() {
		cantidad = 0;
	}

	public CantVianda(Vianda _vianda, int _cantidad) {
		vianda = _vianda;
		cantidad = _cantidad;
	}

	public Vianda getVianda() {
		return vianda;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setVianda(Vianda _vianda) {
		vianda = _vianda;
	}

	public void setCantidad(int _cantidad) {
		cantidad = _cantidad;
	}


	public String ToString() {
		return (vianda.ToString() + "\nCantidad: " + cantidad);
	}
}
