import java.util.Scanner;


public class JuegoBolas {
		Tablero tab;
		Scanner teclado = new Scanner(System.in);
	public void initJuego(){
		int limX, limY, limRad, vel, nBolas;
		System.out.println("Bienvenido al juego, introduce las caracteristicas: ");
		System.out.println("Tam. horizontal?");
		limX = teclado.nextInt(); teclado.nextLine();
		System.out.println("Tam. vertical?");
		limY = teclado.nextInt(); teclado.nextLine();
		System.out.println("Velocidad de disparo?");
		vel = teclado.nextInt(); teclado.nextLine();
		System.out.println("Cuantas bolas? ");
		nBolas = teclado.nextInt(); teclado.nextLine();
		System.out.println("Y su radio maximo?");
		limRad = teclado.nextInt(); teclado.nextLine();
		tab = new Tablero(limX, limY, limRad, vel, nBolas);
	}
	public void menuPrincipal(){
		int aukera;
		do{
		System.out.println("1. Realizar un disparo");
		System.out.println("2. Visualizar la posicion de las bolas");
		System.out.println("0. Salir");
		aukera = teclado.nextInt(); teclado.nextLine();
		switch(aukera){
		case 1:
			System.out.println("Introduce el angulo de disparo");
			try {
				if(tab.disparo(teclado.nextDouble())){
					System.out.println("Has acertado!");
				}else{
					System.out.println("Has fallado");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} teclado.nextLine();
			break;
		case 2:
			tab.visualizaBolas();
			break;
		case 0:
			System.out.println("Gracias por utilizar la aplicacion");
			break;
		default:
			System.out.println("Opcion incorrecta");
		}
		}while((aukera != 0)&&(!tab.endJuego()));
		System.out.println("Puntos conseguidos: "+tab.getPuntos());
	}
	
}
