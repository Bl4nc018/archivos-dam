package cajaregistradora2;
import java.util.Scanner;
public class CajaRegistradora2 {
	public static void main(String[]args) {
		Scanner scan=new Scanner(System.in);
		int pa=0, pc=0, pg=0, tv=0, f=0, tc=0, mc=0;
		do {
			
/******** Introducción del coste de los artículos y su respectiva suma ********/
			
			System.out.print("Introduzca el precio del artículo que desea adquirir, recuerde pulsar 0 para proceder al pago del total: ");
			pa=scan.nextInt();
			while (pa!=0) {
				pc=pc+pa;
				System.out.print("Introduzca el precio del artículo que desea adquirir, recuerde pulsar 0 para proceder al pago del total: ");
				pa=scan.nextInt();
				}
			
/******** Una vez pulsa 0, presenta el total y paga ********/
			
			if (pa==0) {
				System.out.println("El total de su compra es de: "+pc+"$.");
				System.out.print("Introduzca el pago de su compra: ");
				pg=scan.nextInt();
				tv=tv+pg;
				}
			
			while (pg<pc) {
				System.out.println("Cantidad a pagar restante: "+(pc-pg)+"$.");
				pc=pc-pg;
				System.out.print("Introduzca el pago de su compra: ");
				pg=scan.nextInt();
				}
			
/******** Una vez que es pagada la compra, comprobar y devolver si es necesario, la vuelta. ********/
			
			if (pc<pg) {
				System.out.println("Pago realizado con éxito. Debe de devolverse una cantidad de: "+(pg-pc)+"$.");
				}
			
/******** Comprobar si hay un nuevo cliente o si se finaliza la actividad de la caja por el día. ********/			
			
			System.out.print("Introduzca 1 para comenzar de nuevo con la operación de compra o 0 para finalizar toda operación de la caja: ");
			f=scan.nextInt();
			
			while(f!=1 && f!=0) {
				System.out.print("Número inválido, inténtelo de nuevo: ");
				f=scan.nextInt();
			}
			if(f==1) {
				pg=0;
				pc=0;
			}
			tc=tc+1;
		}while(f==1);
	
/******** Presentar los clientes, las ventas y la media de clientes por venta. ********/		
		
		if(f==0) {
			System.out.println("El total de su clientes que ha habido es: "+tc+" y las ventas que hubo: "+tv);
			mc=tv/tc;
			System.out.print("La media de ventas por cliente has sido de: "+mc+".");
			}
			scan.close();
		}
	}