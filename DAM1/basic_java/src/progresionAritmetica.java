package ej1examen;

import java.util.Scanner;

public class Ej_1_Examen {
	
// Diseñar el programa que nos permita visualizar la progresión geométrica entre dos números introducidos previamente por teclado habrá que comprobar que el número inicial sea menor que el final, en caso contrario se volverá a preguntar por dicho valor. Una vez visualizada la progresión se preguntará si se quiere calcular otra a la que sólo se podrá contestar con un 1 o un 0 para si o no respectivamente, en caso de contestar con cualquier otro valor, se repetirá dicha pregunta.
	
		public static void main(String[]args) {
			Scanner scan=new Scanner(System.in);
			int n1=0, n2=0, otro=1;
			
			do {
				do {
					System.out.print("Introduzca el primer número para realizar la progresión: ");
					n1=scan.nextInt();
					System.out.print("Introduzca el segundo número para realizar la progresión: ");
					n2=scan.nextInt();
				}while(n1>n2);
				
				do {
					System.out.print(n1+"\t");
					n1=n1+n1;
					if(n1>n2 || n1==n2) {
						System.out.print(n2+"\t");
						System.out.print("\n"+"La progresión aritmética ha terminado.");
					}
				}while(n1<n2 && n1!=n2);
				
				do {
					System.out.print("\n"+"¿Desea realizar otra progresión aritmética?: ");
					otro=scan.nextInt();
				}while(otro!=0 && otro!=1);
			}while(otro==1);
		scan.close();
		}
}
