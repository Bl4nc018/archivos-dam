import java.util.Scanner;
public class metodo11 {
	
	// Creación de la parte del menú del programa:
	static int Menu (Scanner scan) {
		int o = 0;
		System.out.println("\n\tMENU\n\t====\n");
		System.out.println("1.- Teclear cadena.");
		System.out.println("2.- Crear cadena caracteres agrupados.");
		System.out.println("3.- Visualizar cadena caracteres agrupados.");
		System.out.println("4.- Fin. \n");
		do {
			System.out.print("\t Seleccione una operación (1-4): ");
			o=scan.nextInt();
		}while(o<1 || o>4);
		scan.nextLine();
		return o;
	}
		
	static String crearCadena(Scanner scan) {
		int longitud = 0;
		String cad="";
		do {
			System.out.print("Teclee cadena (10-20 caracteres");
			cad = scan.nextLine();
			longitud=cad.length();
			if (longitud<40 || longitud>50)
				System.out.print("Número de caracteres incorrecto");
		}while (longitud<10 || longitud>20);
		return cad;
		
	}
	
	static String crearCadenaAgrupada(String c) {
		String ca= "", cadenaL="", cadenaN="", cadenaC="";
		int ic=0;
		char caracter=' ';
		System.out.print("\n Agrupando la cadena. ");
		for(ic=0; ic<c.length(); ic++ ) {
			caracter =c.charAt(ic);
			if(Character.isLetter(caracter)) {
				cadenaL+=caracter;
			}
			else {
				if(Character.isDigit(caracter)) {
					cadenaN += caracter;
				}else {
					if(caracter != ' ') {
						cadenaC += caracter;
					}
				}
			}
		}
		ca=cadenaL + cadenaN + cadenaC;
		return ca;
	}
	
	static void visualizarCadenaAgrupada() {
		System.out.println(" ");
	}
	
	static void finPrograma () {
		System.out.println("\n\n\n\t\tFIN DEL PROGRAMA\n");
	}
	
	// Public donde se agrupan los métodos.
	
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		int opcion=0;
		String cadena = "", cadenaA="";
		do {
			Menu(scan);
			switch(opcion){
			case 1:
				cadena =crearCadena(scan);
				break;
			case 2:
				cadenaA=crearCadenaAgrupada(cadena);
				break;
			case 3:
				visualizarCadenaAgrupada(cadenaA);
			case 4:
				System.out.print("Cuatro");
				break;
				default,
				finPrograma();
			}
		}while(opcion !=4);
	}
}
		
