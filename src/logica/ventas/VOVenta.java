package logica.ventas;

import java.util.Date;

public class VOVenta {

	private static int _contador = 0;
	private int numeroVenta;
	private Date fecha;
	private String dirEntrega;
	
	public VOVenta(Date _fecha, String _dirEntrega) {
		_contador++;
		numeroVenta = _contador;
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
}
