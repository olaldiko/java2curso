import java.util.Date;
import java.util.Scanner;

public class Fecha {
	Date fecha;
	/**
	 * Pide la fecha por terminal ,la valida y la aplica.
	 */
	public void introduceFechaTerm(){
		String fechastring;
		Compruebafecha fechaok = new Compruebafecha();
		Scanner teclado = new Scanner(System.in);
		do{
			System.out.println("Introduce la fecha, separada por espacios");
			fechastring = teclado.nextLine();
			fecha = fechaok.validaFecha(fechastring);
		}while(!fechaok.fechaok);
		
	}
}