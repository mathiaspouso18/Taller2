package grafica;
import java.util.Date;

import clases.*;

public class Main {
	
	public static void main(String[] args) {
		ColeccionViandas viandas = new ColeccionViandas();
		ColeccionVentas ventas = new ColeccionVentas();
		
		Vianda v = new Vianda();
		v.setCodVianda("ACP15");
		v.setDescripcion("Arroz con pollo");
		v.setPrecio(15);
		//System.out.println(v.ToString());
		viandas.insertarVianda(v);
		
		Date fecha = new Date();
		Venta ve = new Venta(fecha, "Calle 123");
		//System.out.println("");
		//System.out.println(ve.ToString());
		ventas.insertarVenta(ve);
		
		Date fecha2 = new Date();
		Venta ve2 = new Venta(fecha2, "Calle 456");
		//System.out.println("");
		//System.out.println(ve2.ToString());
		ventas.insertarVenta(ve2);
		
		ventas.ToString();
		
		if(ventas.existeVenta(2))
			System.out.print("Si");
		else
			System.out.print("No");
		
		//Venta v2 = ventas.buscarVenta(2);
		//v2.setEnProc(true);
		
	}
}
