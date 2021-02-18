package persistencia;
import java.io.*;
import java.util.Properties;
import java.util.TreeMap;
import excepciones.PersistenciaException;
import logica.ventas.ColeccionVentas;
import logica.viandas.*;

public class Respaldo
{	
	private void respaldarColeccionViandas (String nomArch, ColeccionViandas cv) throws IOException{
		FileOutputStream f = new FileOutputStream(nomArch);
		ObjectOutputStream o = new ObjectOutputStream(f);
		o.writeObject(cv);
		o.close();
		f.close();
	}
	
	private void respaldarColeccionVentas(String nomArch, ColeccionVentas cve) throws IOException {
		FileOutputStream f = new FileOutputStream(nomArch);
		ObjectOutputStream o = new ObjectOutputStream(f);
		o.writeObject(cve);
		o.close();
		f.close();
	}
	
	public void respaldar(String nomArch, ColeccionVentas cve, ColeccionViandas cv) throws IOException, PersistenciaException {
		
		FileOutputStream f = new FileOutputStream(nomArch);
		ObjectOutputStream o = new ObjectOutputStream(f);
		o.writeObject(cv);
		o.writeObject(cve);
		o.close();
		f.close();
		
		//respaldarColeccionViandas(nomArch, cv);
		//respaldarColeccionVentas(nomArch, cve);
	}
	
	
	public ColeccionViandas recuperarViandas (String nomArch) throws IOException, ClassNotFoundException {
		ColeccionViandas cv = new ColeccionViandas();
		try{ 
			FileInputStream f = new FileInputStream(nomArch);
			ObjectInputStream o = new ObjectInputStream(f);
			if(o.readObject() instanceof ColeccionViandas) {
				cv = (ColeccionViandas)o.readObject();
			}
			o.close();
			f.close();
		}
		catch (IOException e)
		{ 
			e.printStackTrace();
		}
		return cv;
	}
	
	public ColeccionVentas recuperarVentas (String nomArch) throws IOException, ClassNotFoundException {
		ColeccionVentas cve = new ColeccionVentas();
		try{ 
			FileInputStream f = new FileInputStream(nomArch);
			ObjectInputStream o = new ObjectInputStream(f);
			if(o.readObject() instanceof ColeccionVentas) {
				cve = (ColeccionVentas)o.readObject();
			}
			o.close();
			f.close();
		}
		catch (IOException e)
		{ 
			e.printStackTrace();
		}
		return cve;
	}
	
	public String GetNombreArchivo() throws IOException, PersistenciaException {
		File file = new File(AuxGetArchivo());
		if (!file.exists()) {
			file.createNewFile();
		}
		return AuxGetArchivo();
	}
	
	private String AuxGetArchivo() throws PersistenciaException {
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