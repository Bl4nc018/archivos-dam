
// ENUNCIADO: Cree un programa que cuente las palabras en la frase introducida.
package contadorpalabras;
import java.util.Scanner;
public class ContadorPalabras {
	public static void main(String[]args) {
			
			/**********************Programa realizado con un array***************/
	//				char letra = ' ', vl[]=new char [20];
	//				int i = 0;
	//				System.out.print("Teclee la frase deseada, pulse * para terminar: ");
	//				for(i=0;i<20 && letra != '*';i++) {
	//						try {
	//							letra=(char) System.in.read();
	//						}catch(IOException ioe) {};
	//						
	//						if(Character.isLetter(letra))
	//							vl[i]=letra;
	//						}
	//				System.out.print("\nFrase tecleada: ");
	//				for(i=0;i<20;i++) {
	//					System.out.print(vl[i]);
	//				}
	//				
	//				for(i=19;i>0;i--) {
	//					System.out.print(vl[i]);
	//				} 
	//				
			/*******************Mismo programa pero con String****************/
					
	//				Scanner scan=new Scanner(System.in);
	//				String cadena = "";
	//				char palabra= ' ';
	//				int i=0, cp=0;
	//				System.out.print("Teclee la frase deseada, pulse * para terminar: ");
	//				cadena=scan.nextLine();
	//				if(cadena.charAt(0)=='*') {
	//					System.out.print("Programa terminado.");
	//				}
	//				else {
	//				System.out.print("\n Frase escrita correctamente: "+cadena);
	//				System.out.print("\n ");
	//				System.out.print("\n Frase escrita de manera inversa: ");
	//					for(i=(cadena.length()-1);i>=0;i--) {
	//						System.out.print(cadena.charAt(i));
	//					}
	//				}
					
			/*******************Contar cuantas palabras hay en cada frase****************/
					
					Scanner scan=new Scanner(System.in);
					String cadena=null;
					int i=0, contPal=0;
					do {
						System.out.print("Teclee la frase deseada: ");
						cadena=scan.nextLine();
						scan.close();
						cadena=cadena.trim();
					}while (cadena.length()==0);
					
					for(i=0;i<cadena.length();i++) {
						if(cadena.charAt(i)==' ') {
							contPal++;
							while(cadena.charAt(++i)==' ');
						}
					}
					System.out.println("Número de palabras que posee la frase: "+(++contPal));
		}
}
