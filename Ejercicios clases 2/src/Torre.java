
public class Torre extends Figuras{

	public Torre(int limX, int limY) {
		this.limX = limX;
		this.limY = limY;
	}
	/**
	 * Mueve la torre a donde se pida, pero con restricciones.
	 */
	public void mover(int x, int y){
		if(this.x == x){
			this.y = y;
		}else{
			if(this.y == y){
				this.x = x;
			}else{
				System.out.println("Movimiento incorrecto.");
			}
		}
	}
	public String toString(){
		return "Torre";
	}
}
