package Ejercicio2;

public class Rectangulo extends Figura {
	int lado1, lado2;
	public Rectangulo(int x, int y, int lado1, int lado2){
		super(x,y);
		this.lado1 = lado1;
		this.lado2 = lado2;
	}
	public int calcArea(){
		return lado1*lado2;
	}
	public String toString(){
		return"Rectangulo X: "+x+" Y: "+y+" lado1 "+lado1+" lado2 "+lado2;
	}
}
