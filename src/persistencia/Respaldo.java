package persistencia;
import java.io.*;
import java.util.Properties;
import java.util.TreeMap;

import excepciones.PersistenciaException;
import logica.ventas.ColeccionVentas;
import logica.viandas.*;

public class Respaldo
{
	public void respaldar (String nomArch, ColeccionViandas v) throws PersistenciaException, IOException{
		FileOutputStream f = new FileOutputStream(nomArch);
		ObjectOutputStream o = new ObjectOutputStream(f);
		o.writeObject(v);
		o.close();
		f.close();
		
	}
	public ColeccionViandas recuperar (String nomArch) throws IOException, ClassNotFoundException {
		ColeccionViandas cv = new ColeccionViandas();
		try{ 
			FileInputStream f = new FileInputStream(nomArch);
			ObjectInputStream o = new ObjectInputStream(f);
			cv = (ColeccionViandas)o.readObject();
			o.close();
			f.close();
		}
		catch (IOException e)
		{ 
			e.printStackTrace();
		}
		return cv;
	}
	
	public String GetNombreArchivo() throws IOException, PersistenciaException {
		File file = new File(AuxGetArchivo());
		if (!file.exists()) {
			file.createNewFile();
			ColeccionViandas cv = new ColeccionViandas();
			ColeccionVentas cve = new ColeccionVentas();
			respaldar(AuxGetArchivo(), cv);
		}
		return AuxGetArchivo();
	}
	
	public String AuxGetArchivo() throws PersistenciaException {
		try {
			Properties p = new Properties();
			String name = "src/config/Respaldo.properties";
			p.load(new FileInputStream(name));
			String nomArch = p.getProperty("ruta");
			return nomArch;
		} catch (FileNotFoundException e) {
			throw new PersistenciaException(3);
		} catch (IOException e) {
			throw new PersistenciaException(4);
		}
	}
}