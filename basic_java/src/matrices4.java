package matriztridimensional_y_operaciones2;

import java.util.Scanner;

public class MatrizTridimensional_y_Operaciones2 {
	public static void main (String args[]) {
		Scanner scan = new Scanner (System.in);
//		int alm[][][]=new int[6][4][3], i1=0, i2=0, i3=0;
		
		int i1=0, i2=0, i3=0;
		int alm[][][]= {{{1,2,9},{2,6,5},{3,7,5},{4,2,5}},{{5,9,5},{6,3,5},{7,1,5},{8,3,6}},{{9,3,7},{10,4,8},{1,5,9},{2,6,6}},{{10,7,6},
			{10,8,6},{5,9,6},{6,4,10}},{{7,4,6},{8,4,6},{9,4,6},{2,4,6}},{{2,5,9},{2,6,7},{3,7,7},{4,8,7}}};
		float media=0, cont=0;
		
//		i1=> alumno, i2=> asignatura, i3 => evaluación 
		
		/********************************Llenado de la matriz************************/
//			for(i1=0;i1<5;i1++) {
//				for(i2=3;i2>=0;i2--) {
//					for(i3=0;i3<3;i3++) {
//							System.out.print("Introduzca la nota de la "+(i3+1)+"º evaluación, "+(i2+1)+"º asignatura del "+(i1+1)+"º alumno: ");
//							alm[i1][i2][i3] = scan.nextInt();
//							while (alm[i1][i2][i3]<1 || alm[i1][i2][i3]>10) {
//								System.out.print("Número introducido inválido, inténtelo de nuevo: ");
//								alm[i1][i2][i3] = scan.nextInt();
//							}
//					}
//				}
//			}
		
		/********************************Visualización******************************/
//		for(i1=0;i1<6;i1++) {
//			for(i2=3;i2>=0;i2--) {
//				for(i2=0;i2<4;i2++) {
//					for(i3=0;i3<3;i3++) {
//						System.out.print(alm[i1][i2][i3]+"\t");
//				}
//				System.out.print("\n");
//			}
//			System.out.print("\n");
//		}
		
		for(i3=0;i3<3;i3++) {
			for(i1=0;i1<6;i1++) {
				for(i2=0;i2<4;i2++) {
					System.out.print(alm[i1][i2][i3]+"\t");
				}
				System.out.print("\n");
			}
			System.out.print("\n");
		}
		
		
		/********************************Media Global******************************/
		for(i3=0;i3<3;i3++) {
			for(i1=0;i1<6;i1++) {
				for(i2=0;i2<4;i2++) {
					if(alm[i1][i2][i3]!=0) {
						media+= alm[i1][i2][i3];
						cont++;
					}
				}
			}
		}
		System.out.println("\n La media global es un total de : "+(media/cont));
		
		/********************************Media por alumno******************************/
		for(i1=0;i1<6;i1++) {
			cont=0;
			media=0;
			for(i2=0;i2<4;i2++) {
				for(i3=0;i3<3;i3++) {
					if(alm[i1][i2][i3]!=0) {
						media+= alm[i1][i2][i3];
						cont++;
					}
				}
			}
			System.out.println("\n La media del alumno "+(i1+1)+" es un total de : "+(media/cont));
		}
		
		/********************************Nota de un alumno en una asignatura en una evaluación******************************/
		
		System.out.print("Seleccione el alumno del que desea saber la nota (1-6): ");
		i1=scan.nextInt();
		System.out.print("Seleccione la asignatura (1-4): ");
		i2=scan.nextInt();
		System.out.print("Seleccione la evaluación (1-3): ");
		i3=scan.nextInt();
		System.out.print(alm[i1-1][i2-1][i3-1]);
		
	scan.close();
	}
}
