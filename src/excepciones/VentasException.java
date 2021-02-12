package excepciones;

public class VentasException extends Exception {
	private static final long serialVersionUID = 1L;
	private int codigoError;

	public VentasException(int cod) {
		codigoError = cod;
	}
	
	public String getMensajeVentaException() {
		String error = "";

		switch (codigoError) {
		case 1:
			error = "La venta ya fue ingresada.";
			break;
		case 2:
			error = "La venta no esta en proceso.";
			break;
		case 3:
			error = "La fecha de la nueva venta no puede ser anterior a la ultima ingresada.";
			break;
		case 4:
			error = "Se llegó al limite de viandas en la venta.";
			break;
		case 5:
			error = "No existe la venta con el codigo especificado.";
			break;
		case 6:
			error = "No existe la vianda especificada en la venta";
			break;
		default:
			error = "Error no especificado";
		}

		return error;

	}

}
