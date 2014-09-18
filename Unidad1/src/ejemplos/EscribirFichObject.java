package ejemplos;

import java.io.*;

public class EscribirFichObject {
	
	Persona persona;//Define variable persona.
	File f;
	FileOutputStream fos;
	ObjectOutputStream obos;
	
	
	public void escribir() throws FileNotFoundException, IOException{
		
		f=new File("FichPersona.dat");
		fos=new FileOutputStream(f);//Crea el flujo de salida.
		obos=new ObjectOutputStream(fos);//Conecta el flujo de bytes al flujo de datos.
		String nombres[]={"Alejandro","Begoña","Lucía"};
		int edades[]={43,39,1};
		
		for(int i=0;i<edades.length;i++){
			persona=new Persona(nombres[i],edades[i]);//Crea la pesona.
			obos.writeObject(persona);//Escribe la persona en el fichero.
		}
		obos.close();//Cierra el flujo de salida.
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		EscribirFichObject efo= new EscribirFichObject();
		efo.escribir();

	}

}
