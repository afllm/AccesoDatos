package ejemplos;

import java.io.*;


public class LeerFichObject {
	
	public void leer() {//throws FileNotFoundException, IOException, ClassNotFoundException{
		
		Persona persona;
		File f=new File("FichPersona.dat");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//Crea el flujo de Entrada.
		//Conecta el flujo de bytes al flujo de datos:
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(fis);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try{
			while(true){//Lectura del fichero.
				persona = (Persona) ois.readObject();//Lee una persona.
				System.out.println("Nombre: "+persona.getNombre()+", edad: "+persona.getEdad());
				
			}
		}catch(EOFException eof){
			eof.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		LeerFichObject lfo= new LeerFichObject();
		lfo.leer();
	}

}
