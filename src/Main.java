import java.time.*;

import excepciones.VentasException;
import excepciones.ViandasException;
import logica.CapaLogica;
import logica.ventas.*;
import logica.viandas.*;


public class Main {

	public static void main(String[] args) throws VentasException, ViandasException {
		
		try {
			CapaLogica cp = new CapaLogica();
			
			LocalDate fecha = LocalDate.now();
			LocalDate fecha2 = LocalDate.of(2021, 02, 13);
			VOVenta _voventa = new VOVenta(fecha, "calle 123");
			VOVenta _voventa2 = new VOVenta(fecha2, "calle 456");
			
			//cp.ListarVentas();
			cp.AltaVenta(_voventa);
			cp.AltaVenta(_voventa2);
			
			cp.ListarVentas();
			
			VOVianda _vovianda = new VOVianda("ACP", "Arroz con pollo", 300);
			//cp.ListarViandas();
			cp.AltaVianda(_vovianda);
			
			VOVianda _voviandaveg = new VOViandaVeg("S", "Seitan", 159, true, "Nada que agregar");
			cp.AltaVianda(_voviandaveg);
			
			VOVianda _voviandaveg2 = new VOVianda("S", "Seitan", 174);
			cp.AltaVianda(_voviandaveg2);
			//cp.AltaVianda(_vovianda);
			cp.ListarViandas();
		}
		catch(VentasException e) {
			System.out.println(e.getMensajeVentaException());
		}
		catch(ViandasException ve) {
			System.out.println(ve.getMensajeViandaException());
		}
		
		
		//ColeccionViandas viandas = new ColeccionViandas();
		//ColeccionVentas ventas = new ColeccionVentas();
		//ColeccionCantVianda viandasEnVenta = new ColeccionCantVianda();

		//Vianda v3 = new Vianda("ZPM123", "Para probar la insercion", 115);
		//viandas.insertarVianda(v3);
		// System.out.println(v3.ToString());
		// System.out.println();

		//Vianda vv = new ViandaVeg("ACS770", "Arroz con Seitan", 770, true, "No tiene nada raro");
		//viandas.insertarVianda(vv);
		// System.out.println(vv.ToString());
		// System.out.println();

		//Vianda v = new Vianda();
		//v.setCodVianda("ACP15");
		//v.setDescripcion("Arroz con pollo");
		//v.setPrecio(15);
		// System.out.println(v.ToString());
		//viandas.insertarVianda(v);

		//System.out.println("Viandas");
		//CantVianda _cv = new CantVianda(v, 3);
		//CantVianda _cv2 = new CantVianda(v3, 4);
		//CantVianda _cv3 = new CantVianda(vv, 20);
		//viandasEnVenta.insertarVianda(_cv);
		//viandasEnVenta.insertarVianda(_cv2);
		//viandasEnVenta.insertarVianda(_cv3);
		//viandasEnVenta.ToString();

		//Date fecha = new Date();
		//Venta ve = new Venta(fecha, "Calle 123");
		// System.out.println("");
		// System.out.println(ve.ToString());
		//ventas.insertarVenta(ve);

		//Date fecha2 = new Date();
		//Venta ve2 = new Venta(fecha2, "Calle 456");
		// System.out.println("");
		// System.out.println(ve2.ToString());
		//ventas.insertarVenta(ve2);

		// ventas.ToString();

		// if(ventas.existeVenta(2))
		// System.out.print("Si");
		// else
		// System.out.print("No");

		// viandas.ToString();

	}
}
