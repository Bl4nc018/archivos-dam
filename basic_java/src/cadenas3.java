package menuintercalarcadenas;
import java.util.Scanner;
public class MenuIntercalarCadenas {

	static int menu (Scanner scan) {
		int opcion = 0;
		System.out.println("\tMENÚ");
		System.out.println("\t====");
		System.out.println("\n1.- Teclear cadenas");
		System.out.println("\n2.- Intercalar cadenas.");
		System.out.println("\n3.- Visualizar cadenas intercaldas.");
		System.out.println("\n4.- Fin.");
		do {
			System.out.print("\n\n\tSeleccione la opción deseada (1-4): ");
			opcion = scan.nextInt();
		}while (opcion<1 || opcion>4);
		scan.nextLine();
		return opcion;
	}
	
	static String teclearCadenas (Scanner scan) {
		String cad = "";
		do {
			System.out.print("\nIntroduzca el contenido de la cadena (máx. 12 caracteres): ");
			cad = scan.nextLine();
			if (cad.length()>12)
				System.out.println("Número de caracteres excedido.");
		}while (cad.length()>12);
		return cad;
	}

	static String intercalarCadenas (String cadena1, String cadena2) {
		String cad="";
		System.out.print("\nIniciando el intercalado de cadenas...\n");
		boolean fc1 = false, fc2 = false;
		int i1 = 0, i2 = cadena2.length()-1;
		while(!fc1 || !fc2) {
			if (i1 < cadena1.length() && ! fc1)
				cad += cadena1.charAt(i1++);
			else
				fc1 = true;
			if (i2 >= 0 && !fc2)
				cad += cadena2.charAt(i2--);
			else
				fc2 = true;
		}
		System.out.println("\nLas cadenas han sido intercaladas correctamente.");
		cad=String.valueOf(cad);
		return cad;
	}
	
	static void visualizarCadena(String VisCad) {
		System.out.print("Cadena intercalada: "+VisCad);
	}
	
	static void finPrograma() {
		System.out.println("\n\n\n\t\tFIN DEL PROGRAMA\n");
	}
	
	public static void main (String args[]) {
		Scanner scan = new Scanner (System.in);
		int opcion = 0;
		String cadena1 = "", cadena2="", intercalada ="";
		
		do {
			opcion = menu (scan);
			switch (opcion) {
				case 1:
					System.out.println("\nEsta es la primera cadena: ");
					cadena1 = teclearCadenas(scan);
					System.out.println("\nEsta es la segunda cadena: ");
					cadena2 = teclearCadenas(scan);
					System.out.print("\n\n");
					break;
				case 2:
					intercalada = intercalarCadenas(cadena1,cadena2); 
					System.out.print("\n\n");
					break;
				case 3:
					visualizarCadena(intercalada);
					System.out.print("\n\n");
					break;
					default:
					finPrograma();				
			}
		}while (opcion != 4);
		scan.close();
	}

}

