
public class Figuras {
	int x, y, limX, limY;
	public Figuras(){
		this.limX = -1;
		this.limY = -1;
	}
/**
 * Muestra la posicion por consola
 */
	public void getPos(){
		System.out.println("La figura esta en la posicion X: "+this.x+" Y: "+this.y);
	}
	/**
	 * Comprueba a ver si la figura esta dentro de los limites del tablero
	 * @param x
	 * @param y
	 * @return 
	 */
	public boolean limitesOk(int x, int y){
		if((limX == -1)||(((x < limX)&&(x > 0))&&((y < limY)&&(y > 0)))){
			return true;
		}else{
			System.out.println("Movimiento fuera de limites");
			return false;
		}
	}
	public void mover(int x, int y){
		this.x = x;
		this.y = y;
	}
}
