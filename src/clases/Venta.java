package clases;

import java.util.Date;

public class Venta {
	
	private int numeroVenta;
	private Date fecha;
	private String dirEntrega;
	private boolean enProc;
	//private CantViandas cantViandas;
	
	public Venta() {
	}
	
	public Venta(Date _fecha, String _dirEntrega) {
		fecha = _fecha;
		dirEntrega = _dirEntrega;
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
	
	public void SetFecha(Date _fecha) {
		fecha = _fecha;
	}
	
	public void SetDirEntrega(String _dirEntrega) {
		dirEntrega = _dirEntrega;
	}
	
	public void SetEnProc(boolean _enProc) {
		enProc = _enProc;
	}
	
	//public void SetCantViandas(CantViandas _cantViandas) {
	//	cantViandas = _cantViandas;
	//}
}
