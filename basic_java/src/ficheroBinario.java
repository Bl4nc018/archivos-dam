import	java.io.FileReader;
import	java.io.FileWriter;
import	java.io.IOException;
public class EjemploFicheroBinario {
	public static void main(String[]args) {
		int car=0;
		String texto=null;
		try {
			FileWriter esc = new FileWriter("C:\\Users\\joker\\OneDrive\\Desktop\\Curso 22-23\\Asignaturas\\Programación\\Progra 2do trimestre archivos.txt", false);
			System.out.println("Teclear texto a grabar: ");
			car=(char) System.in.read();
			while(car!='*') {
				esc.write(car);
				car = (char) System.in.read();
			}
			esc.close();
		}catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		System.out.println("Fin proceso de escritura.");
		
		texto="";
		try {
			FileReader in = new FileReader("C:\\Users\\joker\\OneDrive\\Desktop\\Curso 22-23\\Asignaturas\\Programación\\Progra 2do trimestre archivos.txt");
			car = in.read();
			while(car!=-1) {
				texto += (char)car;
				System.out.println((char)car);
				car=in.read();
			}
			System.out.println("Texto leído caracter a caracter: ");
			in.close();
		}catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}
}
