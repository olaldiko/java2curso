package Ejercicio1;

import java.util.Scanner;

public class Principal {
	Scanner teclado = new Scanner(System.in);
	Tablero tab = new Tablero();
	public Principal(){
		tab.creaMinas();
	}
	public void menuPrincipal(){
		int x;
		int y;
		int estadojug = 0;
		String opcion;
		int continuar = 0;
		do{
			try{
				System.out.println("Introduce la casilla: x y (m/n)");
				x = teclado.nextInt();
				y = teclado.nextInt();
				opcion = teclado.nextLine();
				estadojug = introJugador(x, y, opcion);
				if(estadojug == 1){
					System.out.println("Mina ("+x+","+y+") desactivada");
				}else{
					if(estadojug == 0){
						System.out.println("No encontrada, hay "+tab.minasCerca(x, y)+"minas cerca");
					}else{
						System.out.println("Boom!!!");
					}
					
				}
				if(estadojug != -1){
					System.out.println("Continuar??? (1-0)");
					continuar = teclado.nextInt();
					teclado.nextLine();
				}
			}catch(Exception e){
				System.out.println("Ha ocurrido un error");
			}
		}while((estadojug != -1)&&(continuar == 1));
		
		
	}
	public int introJugador(int x, int y, String opt){
		if(tab.hayMina(x,y) == 1){
			if(opt == "m"){
				tab.desactivaMina(x, y);
				return 1;
			}else{
				return -1;
			}
		}else{
			return 0;
		}
	}
	public static void main(String[] args) {
		Principal p = new Principal();
		p.tab.creaMinas();
		p.menuPrincipal();
	}

}
