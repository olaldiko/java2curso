package Ejercicio2;

public class Triangulo extends Figura {
	int base, altura;
	public Triangulo(int x, int y, int base, int altura){
		super(x,y);
		this.base = base;
		this.altura = altura;
	}
	public int calcArea(){
		return (base*altura)/2;
	}
	public String toString(){
		return"Triangulo X: "+x+" Y: "+y+" base "+base+" altura "+altura;
	}
}
