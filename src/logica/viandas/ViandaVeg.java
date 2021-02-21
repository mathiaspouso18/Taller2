package logica.viandas;

import java.io.Serializable;

public class ViandaVeg extends Vianda implements Serializable {

	private static final long serialVersionUID = 1L;
	private boolean esOvo;
	private String descAdic;

	public ViandaVeg() {
		super();
	}

	public ViandaVeg(String _codVianda, String _descripcion, int _precio, boolean _esOvo, String _descAdic) {
		super(_codVianda, _descripcion, _precio);
		esOvo = _esOvo;
		descAdic = _descAdic;
	}

	public boolean getEsOvo() {
		return esOvo;
	}

	public String getDescAdic() {
		return descAdic;
	}

	public void setEsOvo(boolean _esOvo) {
		esOvo = _esOvo;
	}

	public void setDescAdic(String _descAdic) {
		descAdic = _descAdic;
	}

	public String ToString() {
		String retorno = super.ToString();
		return retorno = retorno  + "\nEs ovo: " + (esOvo ? "si" : "no") + "\nDescripcion Adicional: " + descAdic;
	}
}
