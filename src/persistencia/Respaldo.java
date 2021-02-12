package persistencia;
import java.io.*;
import java.util.TreeMap;

import logica.viandas.*;

public class Respaldo
{
	public void respaldar (String nomArch, TreeMap<String,Vianda> treeMap) {
		try
		{ // Abro el archivo y creo un flujo de comunicaci�n hacia �l
			FileOutputStream f = new FileOutputStream(nomArch);
			ObjectOutputStream o = new ObjectOutputStream(f);
			// Escribo el arreglo de veh�culos en el archivo a trav�s del flujo
			o.writeObject(treeMap);
			o.close();
			f.close();
		}
		catch (IOException e)
		{ 
			e.printStackTrace();
			//throw new PersistenciaException(�error respaldar�);
		}
	}
	public TreeMap<String, Vianda> recuperar (String nomArch) {
		TreeMap<String, Vianda> treeMap = new TreeMap<>();
		try
		{ // Abro el archivo y creo un flujo de comunicaci�n hacia �l
			FileInputStream f = new FileInputStream(nomArch);
			ObjectInputStream o = new ObjectInputStream(f);
			// Leo el arreglo de veh�culos desde el archivo a trav�s del flujo
			treeMap = (TreeMap<String, Vianda>)o.readObject();
			o.close();
			f.close();
		}
		catch (IOException e)
		{ 
			e.printStackTrace();
			//throw new PersistenciaException(�error recuperar�);
		}
		return treeMap;
	}
}