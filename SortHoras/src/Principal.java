import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;


public class Principal {
	List<Hora> lista = new ArrayList<Hora>();
	Scanner teclado = new Scanner(System.in);
	Hora comp = new Hora(00,00);
	public void introduceHoras(){
		int hh;
		int mm;
		int aukera = 0;
		do{
		try{
		System.out.println("Introduce las horas: ");
		hh = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Introduce los minutos:");
		mm = teclado.nextInt();
		teclado.nextLine();
		lista.add(new Hora(hh, mm));
		}catch(Exception e){
			System.out.println("Introduccion incorrecta");
		}finally{
			System.out.println("Continuar?");
			try{
				aukera = teclado.nextInt();
				teclado.nextLine();
			}catch(Exception e){
				System.out.println("Opcion incorrecta");
				aukera = 0;
			}
		}
		}while(aukera !=0);
	}
	public void muestraHoras(){
		Collections.sort(lista);
		for(Hora a: lista){
			System.out.println(a);
		}
		
	}
	public static void main(String args[]){
		Principal pr = new Principal();
		pr.introduceHoras();
		pr.muestraHoras();
	}
}
