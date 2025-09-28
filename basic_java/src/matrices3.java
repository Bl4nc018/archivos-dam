package matriztridimensional_y_operaciones;

import java.util.Scanner;

public class MatrizTridimensional_y_Operaciones {
	public static void main (String args[]) {
		Scanner scan = new Scanner (System.in);
		
/*********************************Inicio para realizar la matriz rellenándola a mano*********************************/
		
//		int alm[][]=new int[12][4];
//		int i=0,j=0;
		
/********************************************************************************************************************/

		int alm[][]= {{25,46,32,11},{3,8,11,12},{45,65,23,22},{125,345,200,100},{40,34,7,54},{12,56,98,4},{9,5,123,44},{27,83,160,3},{23,44,66,13},
				 {4,5,70,9},{12,23,34,2},{33,87,200,3}};
		
		int ic=0,im=0,aux=0,vs=0,suma=0,is=0,iM=0;
		
		/*********************************For para llenar la matriz tecleando números*********************************/
//		for(i=0;i<12;i++) {
//			for(j=0;j<4;j++) {
//				System.out.print("Teclee las ventas en el mes "+i+" del coche "+j+": ");
//				alm[i][j] = scan.nextInt();
//			}
//		}
//		System.out.println("\n\n");
		/******************************************************************/
		
		/*********************************Mayor venta*********************************/
		
		for(im=0;im<12;im++) {
			for(ic=0;ic<4;ic++) {
				if(aux<alm[im][ic]) {
					aux=alm[im][ic];
				}
			}
		}
		System.out.println("\n La venta mayor es de: "+aux);
		
		/*********************************Total de coches vendidos*********************************/
		suma=0;
		for(im=0;im<12;im++) {
			for(ic=0;ic<4;ic++) {
				suma=suma+alm[im][ic];
			}
		}
		
		System.out.println("\n El total de coches vendidos en el año fue de: "+suma);
		
		/*********************************El coche más vendido junto a sus unidades*********************************/
		
		for(ic=0;ic<4;ic++) {
			suma=0;
			for(im=0;im<12;im++) {
				suma=suma+alm[im][ic];
				if(suma>vs) {
					vs=suma;
					is=ic;
				}
			}
		}
		System.out.println("\n El coche más vendido en el año fue "+(is+1)+" con "+vs+" unidades.");
		
		/*********************************El mes de mayor numero de ventas y las uds vendidas*********************************/
		vs=0;
		for(im=0;im<12;im++) {
			suma=0;
			for(ic=0;ic<4;ic++) {
				suma=suma+alm[im][ic];
				if(suma>vs) {
					vs=suma;
					iM=im;
				}
			}
		}
		System.out.println("\n El mes con mayor ventas es el "+(iM+1)+" con "+vs+" unidades.");
		
		/*********************************Coches más vendidos en un mes*********************************/
		vs=0;
		iM=0;
		is=0;
		for(ic=0;ic<4;ic++) {
			for(im=0;im<12;im++) {
				suma=suma+alm[im][ic];
				if(alm[im][ic]>vs) {
					vs=alm[im][ic];
					iM=im;
					is=ic;
				}
			}
		}
		System.out.println("\n Las ventas mayores fueron del mes: "+(iM+1)+", y de la marca: "+(is+1)+" con "+vs+" unidades.");
		
		/*********************************Seleccionar mes y mostrar coches vendidos*********************************/
		
		suma=0;
		do {
			System.out.print("Teclee el mes que desea comprobar (1-12): ");
			im=scan.nextInt();
		}while(im<1 || im>12);
		for(ic=0;ic<4;ic++) {
			suma+= alm[im-1][ic];
		}
		System.out.println("\n El número de coches vendidos en el mes("+(ic+1)+") es de: "+suma);
		
		/*********************************Seleccionar coche y mostrar datos en mes vendidos*********************************/		
				
		suma=0;
		do {
			System.out.print("Teclee el coche que desea comprobar (1-12): ");
			im=scan.nextInt();
		}while(im<1 || im>12);
		for(im=0;im<12;im++) {
			suma+= alm[im][ic-1];
		}
		System.out.println("\n El número de ventas del coche en el mes("+(im+1)+") es de: "+suma);		
				
		scan.close();
	}
}
