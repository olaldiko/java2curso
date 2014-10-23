package Ejercicio2;

public class Circulo extends Figura {
	int radio;
public Circulo(int x, int y, int radio){
	super(x,y);
	this.radio = radio;
}
public int calcArea(){
	return (int) (Math.pow(Math.PI*radio, 2));
}
public String toString(){
	return"Circulo X: "+x+" Y: "+y+" radio "+radio;
}
}
