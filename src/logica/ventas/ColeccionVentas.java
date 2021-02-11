package logica.ventas;
import excepciones.VentasException;
import logica.viandas.ViandaVeg;

import java.time.LocalDate;
import java.util.LinkedList;

public class ColeccionVentas {
	private LinkedList<Venta> Ventas;

	public ColeccionVentas() {
		Ventas = new LinkedList<Venta>();
	}

	public void insertarVenta(VOVenta _voventa) throws VentasException  {
		int numeroVenta = _voventa.getNumero();
		String dir = _voventa.getDirEntrega();
		LocalDate fecha = _voventa.getFecha();
		if(Ventas.size() == 0) {
			Venta ve = new Venta(numeroVenta, fecha, dir);
			Ventas.add(ve);
		}
		else {
			Venta ulventa = Ventas.getLast();
			if(ulventa != null) {
				LocalDate ulfecha = ulventa.getFecha();
				if(fecha.compareTo(ulfecha)>0) {
					Venta ve = new Venta(numeroVenta, fecha, dir);
					Ventas.add(ve);
				}else {
					throw new VentasException(3);
				}
			}
		}
	}

	public Venta buscarVenta(int numeroVenta) {
		return Ventas.get(numeroVenta - 1);
	}

	public boolean existeVenta(int numeroVenta) {
		return buscarVenta(numeroVenta) != null;
	}
	
	public void reducirCantViandas(int _numeroVenta, String _codVianda, int _cant) {
		Venta ve = this.buscarVenta(_numeroVenta);
		if(ve.getEnProc()) {
			ve.reducirCantidad(_codVianda, _cant);
		}else {
			
		}
	}
	
	public void procesarVenta(int _numeroVenta, boolean _indicacion) {
		Venta ve = Ventas.get(_numeroVenta-1);
		if(ve.getTotalViandas() == 0) {
			Ventas.remove(ve);
		}else{
			if(_indicacion) {
				ve.setEnProc(false);
			}else {
				Ventas.remove(ve);
			}
		}
	}
	
	public boolean esVacio() {
		return Ventas.size() == 0;
	}
	
	public int largoColeccion() {
		return Ventas.size();
	}
	

	public void ToString() {
		for (Venta v : Ventas) {
			System.out.println(v.ToString());
			System.out.println();
		}
	}
}
