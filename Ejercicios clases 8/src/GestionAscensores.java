import java.util.Scanner;


public class GestionAscensores {
	Ascensor[] ascensores = new Ascensor[3];
	Scanner teclado = new Scanner(System.in);
	public GestionAscensores(){
		for(int i = 0; i < 3; i++){
			ascensores[i] = new Ascensor();
		}
	}
	public void menuPrincipal(){
		int aukera;
		do{
		System.out.println("1. Mover ascensor a piso");
		System.out.println("2. Llamar ascensor desde piso");
		System.out.println("0. Salir");
		aukera = teclado.nextInt(); teclado.nextLine();
		switch(aukera){
			case 1:
				menuMover();
				break;
			case 2:
				llamarAscensor();
				break;
			case 0:
				System.out.println("Gracias por utilizar la aplicacion");
				break;
			default:
				System.out.println("Opcion incorrecta");
				break;
		}
		}while(aukera != 0);
	}
	public void menuMover(){
		int ascensor, piso;
		System.out.println("Indica que ascensor: ");
		ascensor = teclado.nextInt(); teclado.nextLine();
		System.out.println("Indica a que piso: ");
		piso = teclado.nextInt(); teclado.nextLine();
		moverAscensor(ascensor, piso);
	}
	public void moverAscensor(int ascensor, int piso){
		if(ascensor < 3){
		if(ascensores[ascensor].getPiso() > piso){
			ascensores[ascensor].cerrarPuerta();
			for(int i = ascensores[ascensor].getPiso(); i > piso; i--){
				ascensores[ascensor].bajarPiso();
				System.out.println("Ascensor "+ascensor+" en piso: "+ ascensores[ascensor].getPiso());
			}
			ascensores[ascensor].abrirPuerta();
		}else{
			if(ascensores[ascensor].getPiso() < piso){
				ascensores[ascensor].cerrarPuerta();
				for(int i = ascensores[ascensor].getPiso(); i < piso; i++){
					ascensores[ascensor].subirPiso();
					System.out.println("Ascensor "+ascensor+" en piso: "+ ascensores[ascensor].getPiso());
				}
				ascensores[ascensor].abrirPuerta();
			}else{
				ascensores[ascensor].abrirPuerta();
				System.out.println("El ascensor ya esta en el piso");
			}
		}
		}else{
			System.out.println("Error, ascensor incorrecto");
		}
	}
	public void llamarAscensor(){
		int piso;
		int diffpiso;
		int cercano = 0;
		System.out.println("Desde que piso?");
		piso = teclado.nextInt(); teclado.nextLine();
		diffpiso = Math.abs(piso - ascensores[cercano].getPiso());
		for(int i = 1; i < 3; i++){
			if(diffpiso > Math.abs(piso - ascensores[i].getPiso())){
				cercano = i;
				diffpiso = Math.abs(piso - ascensores[cercano].getPiso());
			}
		}
		moverAscensor(cercano, piso);
	}
}
