package excepciones;

public class ViandasException extends Exception {
	private static final long serialVersionUID = 1L;
	private int codigoError;

	public ViandasException(int cod) {
		codigoError = cod;
	}
	
	public String getMensajeViandaException() {
		String error = "";

		switch (codigoError) {
		case 1:
			error = "La vianda ya fue ingresada.";
			break;
		case 2: 
			error = "No existe la vianda con el codigo especificado.";
			break;
		case 3:
			error = "No hay viandas ingresadas en el sistema";
			break;
		default:
			error = "Error no especificado";
		}

		return error;

	}
}
