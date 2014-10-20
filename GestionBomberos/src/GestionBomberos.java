import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;


public class GestionBomberos {
	List<Persona> bomberlist = new ArrayList<Persona>();
	String nombre;
	String apellido;
	Boolean sexo;
	int sexint;
	Scanner teclado = new Scanner(System.in);
	
	public void addBombero(){
		try{
			System.out.println("Introduce el nombre:");
			nombre = teclado.nextLine();
			System.out.println("Introduce el apellido:");
			apellido = teclado.nextLine();
			do{
			System.out.println("Chico o chica? 0-chico 1-chica");
			sexint = teclado.nextInt(); teclado.nextLine();
			switch(sexint){
			case 0:
				sexo = false;
				break;
			case 1:
				sexo = true;
				break;
			default:
				System.out.println("Opcion incorrecta");
				break;
			}
			}while((sexint < 0)||(sexint > 1));
			if(sexo){
				bomberlist.add(new Bombera(nombre, apellido));
			}else{
				bomberlist.add(new Bombero(nombre, apellido));
			}
		}catch (Exception e){
			System.out.println("Error al introducir el/la candidat@");
		}
	}
	public void evaluar(Persona p){
		int resistencia;
		int capacidad;
		int velocidad;
		int potencia;
		try{
		System.out.println("Introduce la resistencia:");
		resistencia = teclado.nextInt(); teclado.nextLine();
		if(p.toString().contains("Chica")){
			System.out.println("Introduce la capacidad pulmonar");
			capacidad = teclado.nextInt(); teclado.nextLine();
			System.out.println("Introduce la velocidad: ");
			velocidad = teclado.nextInt(); teclado.nextLine();
			p.evaluar(resistencia, capacidad, velocidad);
			System.out.println("Total Puntos: "+p.getPuntos());
		}else{
			if(p.toString().contains("Chico")){
				System.out.println("Introduce la potencia: ");
				potencia = teclado.nextInt(); teclado.nextLine();
				p.evaluar(resistencia, potencia);
				System.out.println("Total Puntos: "+p.getPuntos());
			}else{
				throw new Exception();
			}
		}
		}catch (Exception e){
			System.out.println("Error en la introduccion de datos");
		}
	}
	public void verBomberos(){
		ListIterator<Persona> it = bomberlist.listIterator();
		Persona p;
		for(int i = 1;i <= bomberlist.size(); i++){
			p = it.next();
			System.out.println(i+". "+p);
		}
	}
	public Persona selectBombero(){
		ListIterator<Persona> it = bomberlist.listIterator();
		int i;
		verBomberos();
		System.out.println("Selecciona el bombero de la lista: ");
		try{
		i = teclado.nextInt(); teclado.nextLine();
		for(int j = 1; (j < i)&&(it.hasNext()); j++){
			it.next();
		}
		}catch(Exception e){
			System.out.println("Error en la  seleccion");
		}
		return it.next();
	}
	public void menuPrincipal(){
		int aukera;
		do{
			System.out.println("1. Anadir integrante");
			System.out.println("2. Ver integrantes");
			System.out.println("3. Evaluar");
			System.out.println("0. Salir");
			aukera = teclado.nextInt(); teclado.nextLine();
			switch(aukera){
			case 1:
				addBombero();
				break;
			case 2:
				verBomberos();
				break;
			case 3:
				evaluar(selectBombero());
				break;
			case 0:
				System.out.println("Agur!");
				break;
			default:
				System.out.println("Opcion no reconocida");
			}
		}while(aukera!= 0);
	}
	public static void main(String[] args) {
		GestionBomberos gest = new GestionBomberos();
		gest.menuPrincipal();
	}
}
