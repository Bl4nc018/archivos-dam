import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
public class metodo14 {
	public static void main (String [] args) {
		Scanner scan = new Scanner(System.in);
		String texto="", linea="";
		try {
			BufferedWriter grabar = new BufferedWriter(new FileWriter("C:\\Users\\joker\\OneDrive\\Desktop\\Curso 22-23\\Asignaturas\\Programación\\AAAA.txt"));
			System.out.println("Teclear texto a grabar: ");
			texto = scan.nextLine();
			while(!texto.equals("*")) {
				grabar.write(texto);
				grabar.newLine();
				texto=scan.nextLine();
			}
			grabar.close();	
		}catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		
		texto="";
		try{
			BufferedReader leer = new BufferedReader(new FileReader("C:\\Users\\joker\\OneDrive\\Desktop\\Curso 22-23\\Asignaturas\\Programación\\AAAA.txt"));
			linea = leer.readLine();
			while (linea !=null) {
				System.out.println(linea);
				linea=leer.readLine();
			}
			leer.close();
		}catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		scan.close();
	}
}
