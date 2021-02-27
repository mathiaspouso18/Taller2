package logica.viandas;

import java.io.Serializable;

public class Vianda implements Serializable {

	private static final long serialVersionUID = 1L;//Esto va?
	private String codVianda;
	private String descripcion;
	private int precio;

	public Vianda() {
	}

	public Vianda(String _codVianda, String _descripcion, int _precio) {
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

	public void setCodVianda(String _codVianda) {
		codVianda = _codVianda;
	}

	public void setDescripcion(String _descripcion) {
		descripcion = _descripcion;
	}

	public void setPrecio(int _precio) {
		precio = _precio;
	}

	public String ToString() {
		return "Codigo: " + codVianda + "\nDescripcion: " + descripcion + "\nPrecio: " + precio;
	}
}
