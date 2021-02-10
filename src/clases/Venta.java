package clases;

import java.util.Date;

public class Venta {


	private int numeroVenta;
	private Date fecha;
	private String dirEntrega;
	private boolean enProc;
	private ColeccionCantVianda cantViandas;

	public Venta() {
		cantViandas = new ColeccionCantVianda();
	}

	public Venta(int _numeroVenta, Date _fecha, String _dirEntrega) {
		numeroVenta = _numeroVenta;
		fecha = _fecha;
		dirEntrega = _dirEntrega;
		enProc = false;
		cantViandas = new ColeccionCantVianda();
	}

	public int getNumero() {
		return numeroVenta;
	}

	public Date getFecha() {
		return fecha;
	}

	public String getDirEntrega() {
		return dirEntrega;
	}

	public boolean getEnProc() {
		return enProc;
	}
	
	/*public cantViandas getCantViandas(){
		return cantViandas.getCantViandas();
	}*/
	
	public int getTotalViandas() {
		return cantViandas.totalViandas();
	}

	public void setFecha(Date _fecha) {
		fecha = _fecha;
	}

	public void setDirEntrega(String _dirEntrega) {
		dirEntrega = _dirEntrega;
	}

	public void setEnProc(boolean _enProc) {
		enProc = _enProc;
	}
	
	public void aumentarCantidad(String codVianda, int cantidad) {
		//cantViandas.
	}
	
	public String ToString() {
		return ("Numero: " + numeroVenta + "\nFecha: " + fecha.toString() + "\nDireccion de entrega: " + dirEntrega
				+ "\nEn proceso: " + enProc);
	}
}
