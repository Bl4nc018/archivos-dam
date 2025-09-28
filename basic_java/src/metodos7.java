package metodo3;
import java.io.BufferedReader;
import	java.io.FileReader;
import	java.io.FileWriter;
import	java.io.IOException;
import java.util.Scanner;

public class metodo15 {
	
	static String buscaPalabraLarga(String f)
	
	
	
	
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
	
	static void crearFichero(String frase, Scanner scan) {
		int n1=0;
		try {
			FileWriter be = new FileWriter("C:\\Users\\joker\\OneDrive\\Desktop\\Curso 22-23\\Asignaturas\\Programación\\Progra 2do trimestre archivos.txt", false);
			System.out.print("Escribe frases (\"*\" para finalizar): ");
			frase=scan.nextLine();
			while(!frase.equals("*")) {
				be.write(frase);
				be.nextLine();
				n1++;
				frase.nextLine();
			}
			be.close();
		}catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		System.out.println("Fin proceso de escritura.\n\n");
	}
	
	
	
	static void leerFichero(int lv) {
		String frase, pl="";
		String vpl[]=new String[lv];
		int nlinea[]= new int[lv];
		vpl[0]="";
		int ipl=0;
		try {
				BufferedReader bl = new BufferedReader(new FileReader("C:\\Users\\joker\\OneDrive\\Desktop\\Curso 22-23\\Asignaturas\\Programación\\Progra 2do trimestre archivos.txt"));
				for(int lecturas = 0; lecturas<lv; lecturas++) {
					frase = bl.readLine();
					pl=buscaPalabraLarga(frase);
					System.out.println(frase);
					if(pl.length() >= vpl[0].length()) {
						if(pl.length()>vpl[0].length()) {
							ipl=0;
						}
						vpl[ipl]=pl;
						nlinea[ipl++]=lecturas+1;
				}
			}
			System.out.println("\nPalabras más largas: ");
			for(int i=0; i<ipl; i++)
				System.out.println(vpl[i]+" en la línea número: "+nlinea[i]);
			bl.close();
		}catch(IOException ioe) {};
	}
	
	static void finPrograma() {
		System.out.println("\n\n\n\t\tFIN DEL PROGRAMA\n");
	}
	
	public static void main (String args[]) {
		Scanner scan = new Scanner (System.in);
		int nl = 0;
		nl= crearFichero(scan);
		leerFichero(nl);
		scan.close();
	}
	
}

