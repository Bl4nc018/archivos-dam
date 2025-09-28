package compararascii;

public class CompararASCII {
	public static void main(String[] args){
		String c1 = "Asada", c2 = "asada";
		System.out.println("c1.compareTo(c2) => "+c1.compareTo(c2));
		System.out.println("c2.compareToIgnoreCase(c1) => "+c2.compareTo(c1));
		
		// Comparaciones son realizadas mediante el código ASCII
	}
}
