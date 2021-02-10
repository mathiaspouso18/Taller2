package logica.viandas;

public class ViandaVeg extends Vianda {

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
		return (super.ToString() + "\nEs ovo: " + esOvo + "\nDescripcion Adicional: " + descAdic);
	}
}
