import java.util.Scanner;

public class metodo7 {		
		static char letraNif(int n) {
			String letra = "TRWAGMYFPDXBNJZSQVHLCKE";
			return letra.charAt(n%23);
		}
		
		
		static int obtenerNumero(String n) {
			int numero=0;
			try {
				numero = Integer.parseInt(n.substring(0,8));
			}catch(NumberFormatException nfe) {
				System.out.println(" Error en formato nif. (Número)");
				numero = -1;
			}
			return numero;
		}
		
		static char obtenerLetra(String n) {
			char letra = Character.toUpperCase(n.substring(8).charAt(0));
			if(!Character.isLetter(letra)) {
				System.out.println("Error en formato nif. (letra).");
				letra = '*';
			}
			return letra;
		}
		
		static boolean comprobarLetra(int n, char l) {
			return letraNif(n)==l;
		}
		
		static String teclearNif(Scanner scan) {
			String nif = null;
			do {
				System.out.print("Teclear nif?: ");
				nif = scan.nextLine();
			}while(nif.length()!=9);
			return nif;
		}
		
		
		
		
		public static void main(String[] args) {
			Scanner scan = new Scanner (System.in);
			String nif=null;
			int numero=0;
			char letra= " ";
			do {
				nif= teclearNif(scan);
				numero= obtenerNumero(nif);
				letra= obtenerLetra(nif);
				if
			}while(numero == -1 || letra == '*');
			
		}
}
