import java.util.Scanner;


public class Cumpleaños extends Fecha{
	boolean recordatorio;
	
	public Cumpleaños(){
		setFecha(01, 01, 0001);
		this.recordatorio = false;
	}
	public Cumpleaños(boolean recordatorio, int dd, int mm, int aaaa){
		this.recordatorio = recordatorio;
		setFecha(dd, mm, aaaa);
	}
	/**
	 * Pide introducir la fecha del cumpleaños y un recordatorio
	 */
	public void selectCumple(){
		String opcion;
		Scanner teclado = new Scanner(System.in);
		introduceFechaTerm();
		System.out.println("Qieres añadir un recordatorio? s/n:(n)");
		opcion = teclado.nextLine();
		switch (opcion.toLowerCase()){
		case "s":
			recordatorio = true;
			break;
		case "n":
			recordatorio = false;
			break;
		default:
			recordatorio = false;
			break;
		}
	}
	public String toString(){
		return "Dia: "+this.dd+" Mes: "+this.mm+" Año: "+this.aaaa+" Recordatorio: "+this.recordatorio;
	}
}
	