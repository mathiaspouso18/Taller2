package logica.ventas;

import java.util.Date;
import java.util.LinkedList;

public class ColeccionVentas {
	private LinkedList<Venta> Ventas;

	public ColeccionVentas() {
		Ventas = new LinkedList<Venta>();
	}

	public void insertarVenta(VOVenta _voventa) {
		int numeroVenta = _voventa.getNumero();
		String dir = _voventa.getDirEntrega();
		Date fecha = _voventa.getFecha();
		Date ulventa = Ventas.getLast().getFecha();
		if(fecha.compareTo(ulventa)<0) {
			Venta ve = new Venta(numeroVenta, fecha, dir);
			Ventas.add(ve);
		}else {
			//excepcion: La fecha no puede ser menor a la ultima venta ingresada
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
			//excepcion: La venta no esta en proceso
		}
	}
	
	public void procesarVenta(int _numeroVenta, String _indicacion) {
		Venta ve = Ventas.get(_numeroVenta-1);
		if(ve.getTotalViandas() == 0) {
			Ventas.remove(ve);
		}else{
			if(_indicacion=="confirmar") {
				ve.setEnProc(false);
			}else {
				Ventas.remove(ve);
			}
		}
	}
	

	public void ToString() {
		for (Venta v : Ventas) {
			System.out.println(v.ToString());
			System.out.println();
		}
	}
}
