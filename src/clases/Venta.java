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
	
	public Venta(Date fecha, String dirEntrega) {
	}
	
	public int GetNumero() {
		return numeroVenta;
	}
	
	public Date GetFecha() {
		return fecha;
	}
	
	public String GetDirEntrega() {
		return dirEntrega;
	}
	
	public boolean GetEnProc() {
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
