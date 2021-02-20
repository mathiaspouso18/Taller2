package logica.ventas;
import java.io.Serializable;
import java.time.LocalDate;

public class VOVenta implements Serializable {

	private static final long serialVersionUID = 1L;
	private static int _contador = 0;
	private int numeroVenta;
	private LocalDate fecha;
	private String dirEntrega;
	
	public VOVenta(LocalDate _fecha, String _dirEntrega) {
		_contador++;
		numeroVenta = _contador;
		fecha = _fecha;
		dirEntrega = _dirEntrega;
	}

	public int getNumero() {
		return numeroVenta;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public String getDirEntrega() {
		return dirEntrega;
	}
}
