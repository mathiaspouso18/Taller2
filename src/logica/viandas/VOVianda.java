package logica.viandas;

import java.io.Serializable;

public class VOVianda implements Serializable {
	private static final long serialVersionUID = 1L;
	private String codVianda;
	private String descripcion;
	private int precio;

	public VOVianda() {
	}
	
	public VOVianda(String _codVianda, String _descripcion, int _precio) {
		codVianda = _codVianda;
		descripcion = _descripcion;
		precio = _precio;
	}
	
	public String getCodVianda() {
		return codVianda;
	}
	
	public void setCodVianda(String _codVianda) {
		codVianda = _codVianda;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String _descripcion) {
		descripcion = _descripcion;
	}

	public int getPrecio() {
		return precio;
	}
	
	public void setPrecio(int _precio) {
		precio = _precio;
	}
}
