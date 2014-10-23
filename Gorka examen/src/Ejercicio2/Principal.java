package Ejercicio2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Principal {
	Scanner teclado = new Scanner(System.in);
	Figura fig = new Figura(0, 0);
	List<Figura> figuras = new ArrayList<Figura>();
	public void menuPrincipal(){
		int aukera = 0;
		do{
			System.out.println("1. Crear figura");
			System.out.println("2. Ver figuras ordenadas por area");
			System.out.println("3. Ver figuras ordenadas por posicion;");
			System.out.println("0. Salir");
			try{
				aukera = teclado.nextInt(); teclado.nextLine();
			}catch(Exception e){
				aukera = -1;
			}
			switch(aukera){
			case 1:
				crearFigura();
				break;
			case 2:
				verPorArea();
				break;
			case 3:
				verPorPos();
				break;
			case 0:
				System.out.println("Agur!");
				break;
			default:
				System.out.println("Opcion incorrecta");
				break;
			}
		}while(aukera != 0);
	}
	private void verPorPos() {
		Collections.sort(figuras);
		verFigura();
		
	}
	private void verPorArea() {
		Collections.sort(figuras, Figura.Area);
		verFigura();
	}
	
	public void verFigura() {
		ListIterator<Figura> it = figuras.listIterator();
		Figura p;	
		for (int i = 1; i <= figuras.size(); i++) {
			p = it.next();
			System.out.println(i + ". " + p);
		}
	}
	private void crearFigura() {
		int aukera = 0;
			System.out.println("1. Cuadrado");
			System.out.println("2. Rectangulo");
			System.out.println("3. Circulo");
			System.out.println("4, Triangulo");
			System.out.println("0. Salir");
			try{
				aukera = teclado.nextInt(); teclado.nextLine();
			}catch(Exception e){
				aukera = 0;
			}
			switch(aukera){
			case 1:
				crearCuadrado();
				break;
			case 2:
				crearRectangulo();
				break;
			case 3:
				crearCirculo();
				break;
			case 4:
				crearTriangulo();
			default:
				System.out.println("Opcion incorrecta");
				break;
			}
	}
	private void crearTriangulo() {
		int x, y, base, alt;
		System.out.println("Introduce la posicion x y");
		x = teclado.nextInt();
		y = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Introduce la base: ");
		base = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Introduce la altura: ");
		alt = teclado.nextInt();
		teclado.nextLine();
		figuras.add(new Triangulo(x, y, base, alt));
	}
	private void crearRectangulo() {
		int x, y, lado1, lado2;
		System.out.println("Introduce la posicion x y");
		x = teclado.nextInt();
		y = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Introduce el primer lado");
		lado1 = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Introduce el segundo lado");
		lado2 = teclado.nextInt();
		teclado.nextLine();
		figuras.add(new Rectangulo(x, y, lado1, lado2));
		
	}
	private void crearCirculo() {
		int x, y, dim;
		System.out.println("Introduce la posicion x y");
		x = teclado.nextInt();
		y = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Introduce el radio");
		dim = teclado.nextInt();
		teclado.nextLine();
		figuras.add(new Circulo(x, y, dim));
		
	}
	private void crearCuadrado() {
		int x, y, dim;
		System.out.println("Introduce la posicion x y");
		x = teclado.nextInt();
		y = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Introduce la dimension del lado: ");
		dim  = teclado.nextInt();
		teclado.nextLine();
		figuras.add(new Cuadrado(x,y,dim));
		
	}
	public static void main(String[] args) {
		Principal p = new Principal();
		p.menuPrincipal();
		p.teclado.close();
	}

}
