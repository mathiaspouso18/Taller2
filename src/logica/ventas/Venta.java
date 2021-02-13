package logica.ventas;

import java.time.LocalDate;

public class Venta {


	private int numeroVenta;
	private LocalDate fecha;
	private String dirEntrega;
	private boolean enProc;
	private ColeccionCantVianda cantViandas;

	public Venta() {
		cantViandas = new ColeccionCantVianda();
	}

	public Venta(int _numeroVenta, LocalDate _fecha, String _dirEntrega) {
		numeroVenta = _numeroVenta;
		fecha = _fecha;
		dirEntrega = _dirEntrega;
		enProc = false;
		cantViandas = new ColeccionCantVianda();
	}

	public int getNumeroVenta() {
		return numeroVenta;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public String getDirEntrega() {
		return dirEntrega;
	}

	public boolean getEnProc() {
		return enProc;
	}
	
	public int getTotalViandas() {
		return cantViandas.totalViandas();
	}

	public void setFecha(LocalDate _fecha) {
		fecha = _fecha;
	}

	public void setDirEntrega(String _dirEntrega) {
		dirEntrega = _dirEntrega;
	}

	public void setEnProc(boolean _enProc) {
		enProc = _enProc;
	}
	
	public void aumentarCantidad(String _codVianda, int _cantidad) {
		cantViandas.aumentarCant(_codVianda, _cantidad);
	}
	
	public void insertCantVianda(CantVianda _cv) {
		cantViandas.insertarCantVianda(_cv);
	}
	
	public boolean existeViandaxVenta(String _codVianda) {
		return cantViandas.existeCantVianda(_codVianda);
	}
	
	public void reducirCantidad(String _codVianda, int _cantidad) {
		cantViandas.reducirCant(_codVianda, _cantidad);
	}
	
	public String listarViandasVenta() { //1
		return cantViandas.ToString();
	}
	
	public String ToString() {
		return "Numero: " + numeroVenta + "\nFecha: " + fecha.toString() + "\nDireccion de entrega: " + dirEntrega
				+ "\nEn proceso: " + (enProc ? "si" : "no") 
				+ "\nViandas: " + (cantViandas.esVacio() ? "No hay viandas" : cantViandas.ToString());
	}
}
