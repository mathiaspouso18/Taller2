package logica.viandas;

public class VOViandaVeg extends VOVianda {

	private boolean esOvo;
	private String descAdic;
	
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
