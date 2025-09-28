package llenarordenararray;

import java.util.Scanner;

public class LlenarOrdenarArray {
	static void llenarNombres(Scanner scan, String n[]) {
		int i = 0;
		for (i=0; i<10; i++) {
			System.out.print((i+1)+"º Nombres?; ");
			n[i]=scan.nextLine();
		}
	}
	
	static void visualizarNombres(String n[]) {
		System.out.println("\n\nVisualización nombres: \t");
		for(int i =0; i<10; i++) {
			System.out.println((i+1)+"..."+n[i]);
		}
	}
	
	static void ordenarNombres(String n[]) {
		int i1 = 0, i2=0;
		String nombresAux = null;
		System.out.println("\nOrdenando Array.\n");
		for(i1=0; i1<10-1; i1++) {
			for(i2=i1+1; i2<10; i2++) {
				if(n[i1].compareToIgnoreCase(n[i2])>0) {
					nombresAux = n[i1];
					n[i1]=n[i2];
					n[i2]=nombresAux;
				}
			}
		}
		System.out.println("\nArray ordenado.\n");
		
	}
	
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		String nombre[] = new String [10];
		llenarNombres(scan, nombre);
		System.out.println();
		visualizarNombres(nombre);
		ordenarNombres(nombre);
		System.out.println();
		visualizarNombres(nombre);
		System.out.print("\nFinalizado el programa.");
	}
}
