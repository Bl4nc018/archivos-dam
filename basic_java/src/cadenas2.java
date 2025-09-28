package invertircadenascoincidencias;
import java.io.IOException;
import java.util.Scanner;
public class InvertirCadenasCoincidencias {	
	static String crearCadena(Scanner scan) {
		int longitud = 0;
		String cad="";
		do {
			System.out.print("Teclee una cadena (máx. 30 caracteres):");
			cad = scan.nextLine();
			longitud = cad.length();
			if (longitud>30)
				System.out.print("Número de caracteres incorrecto.");
		}while (longitud>30);
		return cad;
	}
	
	static String invertirCadena(String cadena) {
		int i1=0;
		String cadIn="";
		for(i1=(cadena.length()-1);i1>=0;i1--) {
			cadIn=cadIn+cadena.charAt(i1);
		}
		return cadIn;
	}
	
	static void contadorCoincidencias(String cadena, String cadenaIn, int vc[]) {
		int i=0;
		char c1=' ',c2= ' ';
			for(i=0; i<cadena.length(); i++) {
				c1=cadena.charAt(i);
				c2=cadenaIn.charAt(i);
				if(c1==c2) {
					vc[0]++;
					if(Character.isLetter(c1)) {
						vc[1]++;
					}
					else {
						if(Character.isDigit(c1)) {
							vc[2]++;
						}
						else {
							vc[3]++;
						}
					}
				}
			}
	}
	
	static void visualizarCoincidencias(int visCoin[]) {
		System.out.println("\nCoincidencias\n============\n");
		System.out.print("Total:\t\tLetras:\t\tNúmeros:\tOtros:\n");
		for(int i = 0; i<4; i++) {
			System.out.print(visCoin[i]+ "\t\t");
		}
		System.out.println("");
	}
	
	static boolean comprobarCaracter(String cadena, char letra) {
		boolean existe = false;
		for(int p=0; p<cadena.length() && !existe; p++) {
			if(letra == cadena.charAt(p)) {
				existe=true;
			}
		}
		return existe;
	}
	
	static char teclearCaracter(Scanner scan) {
		char c=' ';
		System.out.print("Teclee el caracter que desee comprobar: ");
		try {
			c = (char)System.in.read();;
		}catch(IOException ioe) {};
		return c;
	}
	
	public static void main (String [] args) {
		int vc []=  {0,0,0,0};
		char letra = ' ';
		Scanner scan = new Scanner(System.in);
		String cadena = "", cadenaIn= "";
		cadena = crearCadena(scan);
		cadenaIn = invertirCadena(cadena);
		comprobarCaracter(cadena, letra);
	    contadorCoincidencias(cadena, cadenaIn, vc);
	    System.out.print("Cadena ===========> "+cadena);
		System.out.print("\nCadena invertida => "+cadenaIn);
		System.out.println("");
	    visualizarCoincidencias(vc);
	    System.out.println("");
	    letra = teclearCaracter(scan);
	    System.out.println("");
	}
}
