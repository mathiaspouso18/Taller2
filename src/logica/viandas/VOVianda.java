package logica.viandas;

public class VOVianda {
	private String codVianda;
	private String descripcion;
	private int precio;

	public VOVianda(String _codVianda, String _descripcion, int _precio) {
		codVianda = _codVianda;
		descripcion = _descripcion;
		precio = _precio;
	}
	
	public String getCodVianda() {
		return codVianda;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getPrecio() {
		return precio;
	}
}
