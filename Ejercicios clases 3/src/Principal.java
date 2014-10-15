import java.util.Date;
import java.util.Scanner;
import java.text.*;

public class Principal {
	static Personas[] persona;
	static int numPers = 0;
	static Scanner teclado;
	
	public static void main(String[] args) {
		int aukera;
		Principal principal = new Principal();
		principal.persona = new Personas[20];
		teclado = new Scanner(System.in);
		do{
		System.out.println("1. Añadir una persona");
		System.out.println("2. Visualizar las personas que cumplen años hoy");
		System.out.println("3. Visualizar los cumpleaños para una determinada fecha");
		System.out.println("4. Visualizar las personas almacenadas");
		System.out.println("0. Salir");
		aukera = teclado.nextInt(); teclado.nextLine(); 
		switch(aukera){
			case 1:
				addPersona();
				break;
			case 2:
				cumplesHoy();
				break;
			case 3:
				cumplesFecha();
				break;
			case 4:
				visualizarPersonas();
				break;
			default:
				System.out.println("Opcion incorrecta");
		}
		}while(aukera != 0);
		teclado.close();
	}
	/**
	 * Añade una persona a la lista.
	 */
	public static void addPersona(){
		System.out.println("Introduce el nombre: ");
		persona[numPers] = new Personas();
		persona[numPers].setNombre(teclado.nextLine());
		System.out.println("Introduce el apellido: ");
		persona[numPers].setApellido(teclado.nextLine());
		persona[numPers].setCumple();
		numPers++;
	}
	/**
	 * Visualiza todas las personas de la lista
	 */
	public static void visualizarPersonas(){
		for(int i = 0; i<numPers;i++){
			System.out.println(persona[i]);
		}
	}
	/**
	 * Muestra las personas que cumplen años hoy(A partir de la fecha de sistema)
	 */
	public static void cumplesHoy(){
		Date fecha = new Date();
		String fechatext;
		String añotext;
		int edad;
		SimpleDateFormat fechaMia = new SimpleDateFormat("d M");
		SimpleDateFormat soloAño = new SimpleDateFormat("yyyy");
		fechatext = fechaMia.format(fecha);
		for(int i = 0; i < numPers; i++){
			if(fechatext.equals(persona[i].cumple.dd+" "+persona[i].cumple.mm)){
				añotext = soloAño.format(fecha);
				edad = persona[i].cumple.aaaa - (Integer.parseInt(añotext));
				System.out.println(persona[i].nombre+" "+persona[i].apellido+" cumple hoy "+edad+" años!!!");
			}
		}
	}
	
	/**
	 * Muestra las personas que cumplen años una determinada fecha
	 */
	public static void cumplesFecha(){
		int dd;
		int mm;
		System.out.println("Introduce el dia: ");
		dd = teclado.nextInt(); teclado.nextLine();
		System.out.println("Ïntroduce el mes: ");
		mm = teclado.nextInt(); teclado.nextLine();
		for(int i = 0; i < numPers; i++){
			Personas pers = persona[i];
			if((pers.cumple.dd == dd)&&(pers.cumple.mm == mm)){
				System.out.println(pers.nombre+" "+pers.apellido);
			}
		}
	}
}
