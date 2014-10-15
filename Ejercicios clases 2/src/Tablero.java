import java.util.Scanner;


public class Tablero {
	Figuras[] figuras;
	int limX;
	int limY;
	int limPiezas;
	int numPiezas;
	public Tablero(){
		this.limX = 8;
		this.limY = 8;
		this.limPiezas = 32;
		figuras = new Figuras[this.limPiezas];
	}
	/**
	 * Inicializa el tablero con las piezas y limites puestos
	 * @param limX
	 * @param limY
	 * @param limPiezas
	 */
	public Tablero(int limX, int limY, int limPiezas){
		figuras = new Figuras[limPiezas];
		this.limX = limX;
		this.limY = limY;
		this.limPiezas = limPiezas;
	}
	/**
	 * Crea una figura en el tablero, pide tipo y manda a la funcion de cada una.
	 */
	public void crearFigura(){
		Scanner teclado = new Scanner(System.in);
		int aukera;
		if(numPiezas < limPiezas){
		System.out.println("De que tipo?");
		System.out.println("\t1. Alfil");
		System.out.println("\t2. Torre");
		aukera = teclado.nextInt(); teclado.nextLine();
		switch(aukera){
		case 1:
			figuras[numPiezas++] = new Alfil(limX, limY);		
			break;
		case 2:
			figuras[numPiezas++] = new Torre(limX, limY);
			break;
		default:
			System.out.println("Tipo incorrecto");
			break;
		}
		
		}else{
			System.out.println("Has llegado al limite de piezas");
		}
	}
	/**
	 * Muestra todas las figuras que hay en el tablero.
	 */
	public void visualizarFiguras(){
		for(int i = 0; i < numPiezas;i++){
			System.out.println((i+1)+". "+figuras[i].toString()+" PosX: "+figuras[i].x+" PosY: "+figuras[i].y);
		}
	}
	/**
	 * Visualiza las figuras, y luego pide elegir una por consola.
	 * @return la figura elegida
	 */
	public Figuras seleccionarFigura(){
		int aukera;
		Scanner teclado = new Scanner(System.in);
		visualizarFiguras();
		System.out.println("Selecciona una figura:");
		aukera = teclado.nextInt(); teclado.nextLine();
		return figuras[aukera-1];
	}
	/**
	 * Pide las cordenadas por consola y manda a la funcion de cada una para mover con restricciones.
	 */
	public void moverFigura(){
		Figuras figura;
		Scanner teclado = new Scanner(System.in);
		int posX, posY;
		figura = seleccionarFigura();
		System.out.println("ïntroduce PosX: ");
		posX = teclado.nextInt(); teclado.nextLine();
		System.out.println("Ïntroduce PosY: ");
		posY = teclado.nextInt(); teclado.nextLine();
		figura.mover(posX, posY);
	}
}
