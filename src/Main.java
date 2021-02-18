import java.io.IOException;
import java.time.*;
import java.util.Properties;

import java.io.*;

import excepciones.PersistenciaException;
import excepciones.VentasException;
import excepciones.ViandasException;
import logica.CapaLogica;
import logica.ventas.*;
import logica.viandas.*;


public class Main {

	public static void main(String[] args) throws VentasException, ViandasException, IOException, ClassNotFoundException, PersistenciaException, InterruptedException {
		//Comentar y descomentar para hacer pruebas
		try {
			CapaLogica cp = new CapaLogica();
			
			//Creo ventas
			//LocalDate fecha = LocalDate.now();
			//LocalDate fecha2 = LocalDate.of(2021, 02, 19);
			//VOVenta _voventa = new VOVenta(fecha, "calle 123");
			//VOVenta _voventa2 = new VOVenta(fecha2, "calle 456");
			
			//Doy de alta ventas en coleccion
			//cp.altaVenta(_voventa);
			//cp.altaVenta(_voventa2);
			
			//Listo ventas
			cp.listarVentas();
			
			//Creo viandas
			//VOVianda _vovianda = new VOVianda("ACP", "Arroz con pollo", 300);
			//cp.altaVianda(_vovianda);
			//VOVianda _voviandaveg = new VOViandaVeg("S", "Seitan", 159, true, "Nada que agregar");
			//cp.altaVianda(_voviandaveg);
			
			//Listo viandas
			cp.listarViandas();
			
			//Respaldo info
			//cp.respaldarInfo();

			//Agrego vianda a una venta
			//cp.altaViandaxVenta("ACP", 1, 2);
			
			//Respaldo info
			//cp.respaldarInfo();
			
			//Verifico si ingreso la vianda en la venta
			//cp.listarViandasVenta(1);
			
			//Aumento cantidad de vianda en la venta
			//cp.altaViandaxVenta("ACP", 1, 5);
			
			//Bajo cantidad de viandas en la venta
			//cp.reducirCantVianda("ACP", 2, 1);

		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch(PersistenciaException p) {
			System.out.println(p);
		}
		catch(ViandasException v) {
			System.out.println(v.getMensajeViandaException());
		}
		catch(ClassNotFoundException c) {
			System.out.println(c);
		}
		catch(VentasException ve) {
			System.out.println(ve.getMensajeVentaException());
		}
	}
}
