import java.util.Scanner;
public class metodo12 {
	static int menu (Scanner e) {
		int o = 0;
		System.out.println("MENÚ");
		System.out.println("1.Teclear cadena");
		System.out.println("2.Codificar cadena");
		System.out.println("3.Descodificar cadena");
		System.out.println("4.Visualizar cadena");
		System.out.println("5.Fin \n");
		do {
			System.out.print("\tTeclee opcion (1-4)");
			o = e.nextInt();
		}while (o<1 || o>5);
		e.nextLine();
		return o;
	}
	
	static String crearCadena (Scanner e) {
		String cad="";
		System.out.println("Introduzca frase:");
		cad = e.nextLine();
		return cad;
	}
	
	static String codificarCadena (String c) {
		char letra[];
		int p=0;
		letra = c.toCharArray();
		System.out.print("Codificando");
		for (p=0; p<letra.length; p++) {
			switch(letra[p]) {
			case ' ':
				letra[p]='*';
				break;
			case ',':
				letra[p]='-';
				break;
			case 'Ñ','ñ':
				letra[p]='?';
				break;
			case 'Z','z':
				letra[p]= (char) (((int)letra[p]-25));
				break;
				default:
					letra[p]= (char) (((int)letra[p])+1);		
			}
		}
		c = String.valueOf(c);
		return c;
	}
	
	static String descodificarCadena (String c) {
		char letra[];
		int p=0;
		letra = c.toCharArray();
		System.out.print("Descodificando");
		for (p=0; p<letra.length; p++) {
			switch(letra[p]) {
			case '*':
				letra[p]=' ';
				break;
			case '-':
				letra[p]=',';
				break;
			case '?':
				letra[p]='ñ';
				break;
			case 'A','a':
				letra[p]= (char) (((int)letra[p]+25));
				break;
				default:
					letra[p]= (char) (((int)letra[p])-1);		
			}
		}
		c = String.valueOf(c);
		return c;
	}
	static void visualizarCadena(String c) {
		System.out.println("La frase es: " + c);
	}
	
	static void fin() {
		System.out.println("\n\n\n\t\tFIN DEL PROGRAMA\n");
	}
	
	
	public static void main (String args[]) {
		Scanner entrada = new Scanner (System.in);
		int opcion = 0;
		String cadena="";
		
		do {
			opcion=menu(entrada);
			switch(opcion) {
			case 1:
				cadena=crearCadena(entrada);
				break;
			case 2:
				cadena=codificarCadena(cadena);
				break;
			case 3:
				cadena=descodificarCadena(cadena);
				break;
			case 4:
				visualizarCadena(cadena);
				break;
				default:
					fin();
			}
		}while(opcion != 5);
	}

}
//el espacio por *, la ñ por interrogacion, las comas por guiones, los puntos por +
