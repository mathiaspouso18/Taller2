package excepciones;

public class PersistenciaException extends Exception {

	private static final long serialVersionUID = 1L;
	private int codigoError;

	public PersistenciaException(int cod) {
		codigoError = cod;
	}

	public String getMensajePersistenciaExcep() {
		String mensaje = "";

		switch (codigoError) {
		case 1:
			mensaje = "Error al generar el respaldo";
			break;
		case 2:
			mensaje = "Error al recuperar el archivo";
			break;
		default:
			mensaje = "Error no especificado";
		}

		return mensaje;

	}
}
