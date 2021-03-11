package logica.ventas;
import java.io.Serializable;
import java.time.LocalDateTime;

public class VOVenta implements Serializable {

	private static final long serialVersionUID = 1L;
	private int numeroVenta;
	private LocalDateTime fecha;
	private String dirEntrega;
	private boolean enProc;
	private int montoTotal;
	
	public VOVenta() {
		
	}
	
	public VOVenta(LocalDateTime fecha2, String _dirEntrega, boolean _enProc) {
		fecha = fecha2;
		dirEntrega = _dirEntrega;
		enProc = _enProc;
		montoTotal = 0;
	}
	
	public void setNumero(int _numero) {
		numeroVenta = _numero;
	}
	
	public void setMontoTotal(int _montoTotal) {
		montoTotal = _montoTotal;
	}

	public int getNumero() {
		return numeroVenta;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public String getDirEntrega() {
		return dirEntrega;
	}
	
	public void setDirEntrega(String _dirEntrega) {
		dirEntrega = _dirEntrega;
	}
	
	public boolean getEnProc() {
		return enProc;
	}
	
	public void setEnProc(boolean _enProc) {
		enProc = _enProc;
	}
	
	public int getMontoTotal() {
		return montoTotal;
	}
	
	public void setFecha(LocalDateTime _fecha) {
		fecha = _fecha;
	}
}
