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
		
		try {
			CapaLogica cp = new CapaLogica();
			
			LocalDate fecha = LocalDate.now();
			LocalDate fecha2 = LocalDate.of(2021, 02, 19);
			VOVenta _voventa = new VOVenta(fecha, "calle 123");
			VOVenta _voventa2 = new VOVenta(fecha2, "calle 456");
			
			cp.altaVenta(_voventa);
			cp.altaVenta(_voventa2);
			cp.listarVentas();
			
			
			VOVianda _vovianda = new VOVianda("ACP", "Arroz con pollo", 300);
			cp.altaVianda(_vovianda);
			VOVianda _voviandaveg = new VOViandaVeg("S", "Seitan", 159, true, "Nada que agregar");
			cp.altaVianda(_voviandaveg);
			cp.listarViandas();
			
			//cp.respaldarInfo();
			
			
			
			//cp.procesarVenta(1, true);
			//cp.ListarVentas();
			cp.altaViandaxVenta("ACP", 1, 2);
			cp.listarVentas();
			cp.listarViandasVenta(1);
			//cp.altaViandaxVenta("ACP", 1, 5);
			//cp.listarViandasVenta(1);
			//cp.reducirCantVianda("ACP", 2, 1);
			//cp.listarViandasVenta(1);
			//cp.ListarDatosVianda("S");
			//cp.listarViandaxDescripcion("n");
			//cp.ListarVentas();
			//}catch(VentasException ve) {
			//System.out.println(ve);
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
