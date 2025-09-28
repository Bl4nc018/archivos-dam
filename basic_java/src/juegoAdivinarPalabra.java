package juegoadivinarpalabra;

import java.io.IOException;
import java.util.Scanner;

public class JuegoAdivinarPalabra {
	public static void main(String[]args) {
		Scanner scan= new Scanner(System.in);
		char [] paciertos, pfallos;
		String palabra=null;
		char letra=' ', otra= ' ';
		int i=0, i1=0, ca=0, longpal=0;
		boolean encontrada=false;
		do {
			i=0;
			System.out.print("Teclee la palabra deseada: ");
			palabra=scan.next();
			longpal=palabra.length();
			
/********* Construir los dos vectores **********/
			
			paciertos=new char[longpal];
			pfallos=new char[longpal];
			paciertos[i]=palabra.charAt(i);
			pfallos[i]=palabra.charAt(i);
			i++;
			
			for(;i<longpal-1;i++) {
				paciertos[i]='_';
				pfallos[i]='_';
			}
			
			paciertos[i]=palabra.charAt(i);
			pfallos[i]=palabra.charAt(i);
			
			do {
				System.out.print("\n\n");
				
/********** Visualizar los dos vectores *********/
				
				for(i=0;i<longpal;i++) {
					System.out.print(paciertos[i]+" ");
				}
				System.out.println();
				for(i=0;i<longpal;i++) {
					System.out.print(pfallos[i]+" ");
				}
				
/********** Buscar letra **********/
				
				System.out.print("\n Teclee la letra a buscar: ");
				try {
					letra=(char) System.in.read();
					while (System.in.read()!='\n');
				}catch(IOException ex) {}
				
				for(i=1; i<longpal-1;i++) {
					if(letra==palabra.charAt(i)&&letra!=paciertos[i]) {
						encontrada=true;
						paciertos[i]=palabra.charAt(i);
					}
				}
				if(!encontrada) {
					i1++;
					pfallos[i]=letra;
				}
				else {
					encontrada=false;
				}
			}while(i1<longpal-1 && ca<longpal-2);
			
			if(i1<longpal-1) {
				System.out.println("\n Palabra acertada. \n La respuesta correcta es: ");
			}
			else {
				System.out.println("\n Palabra acertada. \n La respuesta correcta es: ");

			}
			System.out.print("\t\t ");
			
			for(i=0;i<longpal;i++) {
				System.out.print(palabra.charAt(i)+" ");
			do {
				try {
					System.out.print("\n \n ¿Desea jugar otra partida?: ");
					otra=(char) System.in.read();
					while (System.in.read()!='\n');									
				}catch(IOException ioe) {}
				i1=0;
				ca=0;
				
				
			}while(otra!='s' && otra != 'n');
			}
		}while(otra=='s');
		System.out.println("Fin del progama.");
		scan.close();

		
	}
}
