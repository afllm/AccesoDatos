package ejemplos;

import java.io.*;


public class EscribirFichBytes {
	
	public void EscribirFBy() throws IOException{
		
		File f= new File("FichBytes.dat");
		//Crea flujo de salida hacia el fichero:
		FileOutputStream fos=new FileOutputStream(f,true);
		//Crea flujo de entrada:
		FileInputStream fis=new FileInputStream(f);
		
		int i;
		
		for (i=1;i<100;i++){
			fos.write(i+100);//Escribe datos en el flujo de salida.
		}
		fos.close();//Ciera el flujo de salida.
		
		//Visualiza los datos del fichero:
		while((i=fis.read())!=-1){//Lee datos del flujo de entrada.
			System.out.println(i);
		}
		fis.close();//Cerrar flujo de entrada.
	}
	
	

	public static void main(String[] args) throws IOException {
		EscribirFichBytes efb= new EscribirFichBytes();
		efb.EscribirFBy();

	}

}
