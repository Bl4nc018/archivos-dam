package metodo3;
import	java.io.FileReader;
import	java.io.FileWriter;
import	java.io.IOException;
import java.util.Scanner;

public class MenuFicheros {
	static int selMenu(Scanner scan) {
		int opcion = 0;
		System.out.println("\tMENÚ");
		System.out.println("\t====");
		System.out.println("\n1.- Crear fichero.");
		System.out.println("\n2.- Leer fichero.");
		System.out.println("\n3.- Contar vocales.");
		System.out.println("\n4.- Fin.");
		do {
			System.out.print("\n\n\tSeleccione la opción deseada (1-4): \n\n");
			opcion = scan.nextInt();
		}while (opcion<1 || opcion>4);
		scan.nextLine();
		return opcion;
	}
	
	static void crearFichero() {
		int car=0;
		try {
			FileWriter esc = new FileWriter("C:\\Users\\joker\\OneDrive\\Desktop\\Curso 22-23\\Asignaturas\\Programación\\Progra 2do trimestre archivos.txt", false);
			System.out.print("\n\n Teclear texto a grabar: ");
			car=(char) System.in.read();
			while(car!='*') {
				esc.write(car);
				car = (char) System.in.read();
			}
			esc.close();
		}catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		System.out.println("Fin proceso de escritura.\n\n");
	}
	
	
	
	static String leerFichero() {
		int car=0;
		String texto="";
		try {
			FileReader in = new FileReader("C:\\Users\\joker\\OneDrive\\Desktop\\Curso 22-23\\Asignaturas\\Programación\\Progra 2do trimestre archivos.txt");
			car = in.read();
			while(car!=-1) {
				texto += (char)car;
				System.out.print((char)car);
				car=in.read();
			}
			in.close();
		}catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		return texto;
	}
	
	
	
	static int contarVocales() {
		int car=0, cv= 0;
		System.out.println("\n\n =============> CONTAR VOCALES :\n");

		try {
			FileReader in = new FileReader("C:\\Users\\joker\\OneDrive\\Desktop\\Curso 22-23\\Asignaturas\\Programación\\Progra 2do trimestre archivos.txt");
			car = in.read();
			while(car!=-1) {
				switch(Character.toLowerCase((char)car)) {
				case 'a','e','i','o','u','á','é','í','ó','ú','ü':
					cv++;
				}
				car=in.read();
			}
			in.close();
		}catch(IOException ioe) {}
		return cv;
	}
	
	static void finPrograma() {
		System.out.println("\n\n\n\t\tFIN DEL PROGRAMA\n");
	}
	
	public static void main (String args[]) {
		Scanner scan = new Scanner (System.in);
		int opcion = 0;
		
		do {
			opcion = selMenu (scan);
			switch (opcion) {
				case 1:
					crearFichero();
					break;
				case 2:
					leerFichero();
					break;
				case 3:
					System.out.println("En el fichero hay un total de "+contarVocales()+" vocales.");
					break;
				default:
					finPrograma();				
			}
		}while (opcion != 4);
		scan.close();
	}
	
}
