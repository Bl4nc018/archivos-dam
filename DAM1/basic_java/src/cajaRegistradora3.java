package cajaregistradoraemilio;
import java.util.Scanner;
public class CajaRegistradoraEmilio {
	public static void main(String[]args) {
		Scanner scan=new Scanner(System.in);
		int pa=0, pc=0, pg=0, tv=0, f=0, tc=0, mc=0, otro=0;
			do { 
				System.out.print("\n Cuánto entrega?"); 
				pg=scan.nextInt(); 
				if(pg<pc) { 
					System.out.println("\n Faltan: "+(pc-pg)+" $.");
				}
			}while(pg<pc);
			
			System.out.println("\n Su vuelta es: "+(pg-pc)+" $."); 
			System.out.println("\n"); 
				
			do { 
					System.out.print("Otro cliente(1=Si/0=No) "); 
					otro=scan.nextInt(); 
				}while(otro!=0 && otro!=1); 
			
			
			do { 
				while (pa!=0) { //Este while es el bucle necesario para ir sumandole los artículos al precio total que se mostrará al final 
					pc=pc+pa; 
					System.out.print("Introduzca el precio del artículo que desea adquirir: "); 
					pa=scan.nextInt(); 
					}while(otro==1);
				
				if (pa==0) { //Este if se usa para que detectar el 0 y visualizar el total de la compra. 
					System.out.println("El total de su compra es de: " + pc + " $."); 
					System.out.print("Introduzca el dinero para pagar su compra: "); 
					pg=scan.nextInt(); 
					} 
				while(pg<pc) { 
					System.out.println("Todavía es necesario pagar: "+(pc-pg)+" $."); 
					pg=scan.nextInt(); 
					} 
				if(pg>=pc){ 
					System.out.println("Usted ha pagado su compra. Cantidad a dar de vuelta: "+(pg-pc)+" $."); 
					tv=tv+pg; 
					tc=tc+1; 
					} 
					f=scan.nextInt(); 
				if(f==0) { 
					System.out.println("El total de su clientes que ha habido es: "+tc+" y las ventas que hubo: "+tv);
					mc=tv/tc;
					System.out.print("La media de ventas por cliente has sido de: "+mc+".");				 
					} 
			}while(f==1);
	scan.close();
	}
}
