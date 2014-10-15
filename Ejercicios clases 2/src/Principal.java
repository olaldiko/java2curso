import java.util.Scanner;


public class Principal {
	Scanner teclado;
	public static void main(String[] args) {
		Tablero tablero = new Tablero();
		int aukera;
		do{
			aukera = menu();
		switch(aukera){
		case 1:
			tablero.crearFigura();
			break;
		case 2:
			tablero.moverFigura();
			break;
		case 3:
			tablero.visualizarFiguras();
			break;
		case 0:
			System.out.println("Agur!");
		default:
			System.out.println("Opcion Incorrecta");
		}
		}while(aukera != 0);
	}
	public static int menu(){
		int aukera;
		Scanner teclado = new Scanner(System.in);
		System.out.println("****************************");
		System.out.println("1. Crear una pieza");
		System.out.println("2. Mover una pieza");
		System.out.println("3. Visualizar las piezas");
		System.out.println("0. Salir");
		System.out.println("****************************");
		aukera = teclado.nextInt(); teclado.nextLine();
		return aukera;
	}
}
