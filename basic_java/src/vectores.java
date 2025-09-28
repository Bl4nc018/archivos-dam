// Diseñar un programa que permita introducir, al mismo tiempo (en un solo bucle para el llenado de vectores), 10 números enteros en dos vectores, de tal forma que se
// introduzcan en sentido inverso, uno desde el primer elemento hasta el último y el otro desde el último elemento hasta el primero, teniendo en cuenta que los números
// a introducir estarán de forma obligatoria comprendidos entre los valores 25 y 75 ambos inclusive. Si se teclease un valor fuera de dicho rango, se volverá a introducir otro
// hasta que el número sea correcto. Una vez lleno se tendrá que visualizar el contenido de los dos vectores.

package ej2examen;
import java.util.Scanner;
public class Ej_2_Examen {	
		public static void main(String[]args) {
			Scanner scan=new Scanner(System.in);
			int i=0, j=0, aux=0;
			int v[]=new int[10];
			int w[]=new int[10];

	/***** Llenado de ambos vectores*****/
			
				for(i=0;i<10;i++) {
					System.out.print("Introduzca el número con el que desea llenar ambos vectores: ");	
					v[i]=scan.nextInt();
					aux=v[i];
					for(j=9;j>0;j--) {
						w[j]=aux;
					}
				}
				
	/***** Lectura de vectores*****/
			
			i=0; 
			System.out.print("Este sería uno de los vectores completados: ");
			for(i=0;i<10;i++) {
				System.out.print("\t"+v[i]);	
			}
			System.out.print("\n"+"Este sería otro de los vectores completados: ");
			i=0;
			for(i=0;i<10;i++) {
				System.out.print("\t"+w[i]);
			}
		}
}
