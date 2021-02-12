import java.io.IOException;
import java.time.*;
import java.util.Properties;
import java.io.*;

import excepciones.VentasException;
import excepciones.ViandasException;
import logica.CapaLogica;
import logica.ventas.*;
import logica.viandas.*;


public class Main {

	public static void main(String[] args) throws VentasException, ViandasException, IOException {
		
		try {
			
			Properties p = new Properties();
			String nomArch = "config/Config.properties";
			// Abro el archivo properties y leo los datos de configuración
			p.load (new FileInputStream (nomArch));
			String ip = p.getProperty("ipServidor");
			String puerto = p.getProperty("puertoServidor");
			
			
			
			
			//CapaLogica cp = new CapaLogica();
			
			//LocalDate fecha = LocalDate.now();
			//LocalDate fecha2 = LocalDate.of(2021, 02, 13);
			//VOVenta _voventa = new VOVenta(fecha, "calle 123");
			//VOVenta _voventa2 = new VOVenta(fecha2, "calle 456");
			
			//cp.AltaVenta(_voventa);
			//cp.AltaVenta(_voventa2);
			//cp.ListarVentas();
			
			
			//VOVianda _vovianda = new VOVianda("ACP", "Arroz con pollo", 300);
			//cp.AltaVianda(_vovianda);
			//VOVianda _voviandaveg = new VOViandaVeg("S", "Seitan", 159, true, "Nada que agregar");
			//cp.AltaVianda(_voviandaveg);
			//cp.ListarViandas();
			
			//cp.ProcesarVenta(1, true);
			//cp.ListarVentas();
			//cp.AltaViandaxVenta("ACP", 1, 2);
			//cp.ListarVentas();
			//cp.ListarViandasVenta(2);
			//cp.AltaViandaxVenta("ACP", 1, 5);
			//cp.ListarViandasVenta(1);
			//cp.ReducirCantVianda("ACP", 2, 1);
			//cp.ListarViandasVenta(1);
			//cp.ListarDatosVianda("S");
			//cp.ListarViandaxDescripcion("n");
			//cp.ListarVentas();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
