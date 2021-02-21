package logica.viandas;

import java.io.Serializable;

public class VOViandaVeg extends VOVianda implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private boolean esOvo;
	private String descAdic;
	
	public VOViandaVeg() {
		super();
	}
	
	public VOViandaVeg(String _codVianda, String _descripcion, int _precio, boolean _esOvo, String _descAdic) {
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
}
