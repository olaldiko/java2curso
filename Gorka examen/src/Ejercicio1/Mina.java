package Ejercicio1;

public class Mina {
	public Mina(int x2, int y2) {
		this.x = x2;
		this.y = y2;
		boolean activa = true;
	}
	boolean activa = true;
	int x;
	int y;
	public boolean isActiva() {
		// TODO Auto-generated method stub
		return activa;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setActiva(boolean activa) {
		this.activa = activa;
	}
	
}
