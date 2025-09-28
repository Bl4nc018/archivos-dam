// A partir de una matriz de 6 filas (alumnos) y 4 columnas (asignaturas) codificar el programa que permita realizar las siguientes operaciones:
// a) Llenar la matriz por alumnos (las 4 asignaturas antes de cambiar de alumno).
// b) Visualizar la nota media de la asignatura que se introduzca por el teclado las asignaturas serán 1, 2, 3, 4 únicamente, en cualquier otro caso se volverá a preguntar.
package ej3examen;
import java.util.Scanner;
public class Ej_3_Examen {
			public static void main(String[]args) {
			Scanner scan=new Scanner(System.in);
			int alm[][]=new int[6][4], ial=0, ias=0, nMedia=0; 
			for(ial=0;ial<6;ial++) { 
				for(ias=0;ias<4;ias++) { 
					System.out.print("Teclee un valor para el alumno "+ial+" y las asignatura "+ias+": "); 
					alm[ial][ias] = scan.nextInt(); 
				} 
			} 
			System.out.println("\n\n"); 
			
			System.out.print("Teclee la asignatura de la que desee obtener la nota media: "); 
			ias = scan.nextInt();
			if(ias!=1 || ias!=2 || ias!=3 || ias!=4){
				System.out.print("Vuelva a intentarlo: "); 
				ias = scan.nextInt();
			}
			else {
			for(ial=0;ial<6;ial++) {
				nMedia=nMedia+alm[ias][ial];
				}
			}
			System.out.print("La nota media sería de: "+nMedia/6);	
			scan.close();
				}
}
