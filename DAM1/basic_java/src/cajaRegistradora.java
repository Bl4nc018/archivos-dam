// ENUNCIADO: Creación de caja registradora.
package cajaregistradora;
import java.util.Scanner;
public class CajaRegistradora {
	public static void main(String[]args) {
		Scanner scan=new Scanner(System.in);
		int pa=0, t=0;
		System.out.print("Introduzca el precio del artículo que desee adquirir: ");
		pa=scan.nextInt();
		while(pa!=0) {  // Este while es el bucle necesario para ir sumandole los artículos al precio total que se mostrará al final.
			// Línea de código en la que se realizan una serie de acciones una y otra vez hasta que la condición del comienzo sea cumplida.
			t=t+pa;
			pa=scan.nextInt();
		}
		if(pa==0) { // Este if se usa para que detectar el 0 y visualizar el total de la compra.
			System.out.print("El total de su compra es de: "+t);
		}
		scan.close();
	}
}