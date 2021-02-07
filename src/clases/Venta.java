package clases;

import java.util.Date;

public class Venta {
	
	private static int _contador = 0;
	
	private int numeroVenta;
	private Date fecha;
	private String dirEntrega;
	private boolean enProc;
	//private CantViandas cantViandas;
	
	public Venta() {
		_contador++;
		numeroVenta = _contador;
		//cantViandas = new cantViandas();
	}
	
	public Venta(Date _fecha, String _dirEntrega) {
		_contador++;
		numeroVenta = _contador;
		fecha = _fecha;
		dirEntrega = _dirEntrega;
		enProc = false;
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
	
	//public CantViandas GetCantViandas() {
	//	return cantViandas;
	//}
	
	public void setFecha(Date _fecha) {
		fecha = _fecha;
	}
	
	public void setDirEntrega(String _dirEntrega) {
		dirEntrega = _dirEntrega;
	}
	
	public void setEnProc(boolean _enProc) {
		enProc = _enProc;
	}
	
	//public void SetCantViandas(CantViandas _cantViandas) {
	//	cantViandas = _cantViandas;
	//}
	
	public String ToString() {
		return ("Numero: " + numeroVenta + "\nFecha: " + fecha.toString() + "\nDireccion de entrega: " + dirEntrega + "\nEn proceso: " + enProc );
	}
}
