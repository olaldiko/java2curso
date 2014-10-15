import java.util.Scanner;


public class Principal {
	static Personas[] persona;
	static Scanner teclado;
	static Boleto premiado;
	static int numPers = 0;
	static int cantN;
	public static void main(String[] args) {
		persona = new Personas[10];
		teclado = new Scanner(System.in);
		int aukera = 0;
		cantN = 6;
		do{
			System.out.println("1. Añadir una persona");
			System.out.println("2. Visualizar personas");
			System.out.println("3. Ver si alguien ha ganado");
			System.out.println("0. Salir");
			aukera = teclado.nextInt(); teclado.nextLine();
			switch(aukera){
			case 1:
				addPersona();
				break;
			case 2:
				visualizarPersonas();
				break;
			case 3:
				verGanadores();
				break;
			default:
				System.out.println("Öpcion incorrecta");
			}
			
		}while(aukera != 0);
	}
	public static void addPersona(){
		persona[numPers] = new Personas();
		System.out.println("Introduce el nombre: ");
		persona[numPers].nombre = teclado.nextLine();
		System.out.println("Introduce el apellido");
		persona[numPers].apellido = teclado.nextLine();
		persona[numPers].boleto = new Boleto(cantN);
		persona[numPers].boleto.introduceBoleto();
		numPers++;
	}
	public static void visualizarPersonas(){
		for(int i = 0; i < numPers; i++){
			System.out.println(i+". "+persona[i]);
		}
	}
	public static void verGanadores(){
		premiado = new Boleto(cantN);
		System.out.print("Boleto ganador: ");
		
		premiado.introduceBoleto();
		for(int i = 0; i < numPers; i++){
			System.out.println("***********************************");
			System.out.println(persona[i]);
			persona[i].boleto.calcAcertados(premiado);
			System.out.println("***********************************");
		}
	}
}
