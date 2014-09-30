package ejemplos;

import java.io.*;

public class LeerFichData {
	
	File f;
	FileInputStream fis;
	DataInputStream dis;

	public void leer() throws IOException{
		this.f=new File("FichData.dat");
		this.fis = new FileInputStream(f);
		this.dis= new DataInputStream(fis);
		
		String n;
		int e;

		try{
			while(true){//¿¿¿???
				n=this.dis.readUTF();//Recupera el nombre.
				e=this.dis.readInt();//Recupera la edad.
				System.out.println("Nombre: "+n+", edad: "+e);
				
			}
		}catch(IOException ioe){
			ioe.printStackTrace();
		}finally{
			this.dis.close();
		}
		
	}

	public static void main(String[] args) throws IOException {
		LeerFichData lfd= new LeerFichData();
		lfd.leer();

	}

}
