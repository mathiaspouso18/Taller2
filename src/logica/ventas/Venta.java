package logica.ventas;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Venta implements Serializable {
	private static final long serialVersionUID = 1L;
	private int numeroVenta;
	private LocalDateTime fecha;
	private String dirEntrega;
	private boolean enProc;
	private ColeccionCantVianda cantViandas;

	public Venta() {
		cantViandas = new ColeccionCantVianda();
	}

	public Venta(int _numeroVenta, LocalDateTime fecha2, String _dirEntrega) {
		numeroVenta = _numeroVenta;
		fecha = fecha2;
		dirEntrega = _dirEntrega;
		enProc = true;
		cantViandas = new ColeccionCantVianda();
	}

	public int getNumeroVenta() {
		return numeroVenta;
	}

	public LocalDateTime getFecha() {
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
	
	public int getMontoTotal() {
		return cantViandas.getMontoTotal();
	}
	
	public void setNumero(int _numero) {
		numeroVenta = _numero;
	}
	
	public ColeccionCantVianda getCantViandas() {
		return cantViandas;
	}
	public boolean esVacioCantViandas() {
		boolean esVacio = false;
		if(cantViandas.totalViandas() == 0) {
			esVacio= true;
		}
		return esVacio;
	}

	public void setFecha(LocalDateTime _fecha) {
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
	
	public String listarViandasVenta() { 
		return cantViandas.ToString();
	}
	
	public String ToString() {
		return "Numero: " + numeroVenta + "\nFecha: " + fecha.toString() + "\nDireccion de entrega: " + dirEntrega
				+ "\nEn proceso: " + (enProc ? "si" : "no") 
				+ "\nViandas: " + (cantViandas.esVacio() ? "No hay viandas" : cantViandas.ToString());
	}
}
