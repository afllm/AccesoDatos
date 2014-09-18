package ejemplos;

import java.io.*;

public class EscribirFichData {
	
	public void escribir() throws IOException{
		File f=new File("FichData.dat");
		FileOutputStream fos= new FileOutputStream(f);
		DataOutputStream dos= new DataOutputStream(fos);
		String nombres[]={"Ana","Luis Miguel","Begoña","Alejandro","Lucía"};
		int edades[]={14,15,39,43,1};
		
		for (int i=0;i<edades.length;i++){
			dos.writeUTF(nombres[i]);//Inserta nombre.
			dos.writeInt(edades[i]);//Inserta edad.
		}
		dos.close();//Cierra flujo(stream).
	}

	public static void main(String[] args) throws IOException {
		EscribirFichData efd=new EscribirFichData();
		efd.escribir();

	}

}
