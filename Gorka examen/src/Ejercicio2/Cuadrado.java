package Ejercicio2;

public class Cuadrado extends Figura {
	int lado;
	public Cuadrado(int x, int y, int lado){
		super(x,y);
		this.lado = lado;
	}
	public int calcArea(){
		return (int)Math.pow(lado, 2);
	}
	public String toString(){
		return"Cuadrado X: "+x+" Y: "+y+" lado "+lado;
	}
}
