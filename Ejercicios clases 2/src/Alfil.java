
public class Alfil extends Figuras{
	
	public Alfil(int limX, int limY) {
		this.limX = limX;
		this.limY = limY;
	}
/**
 * Mueve el alfil a donde se pida, pero con las restricciones
 */
	public void mover(int x, int y){
		int difx;
		int dify;
		if(limitesOk(x, y)){
			difx = Math.abs(this.x - x);
			dify = Math.abs(this.y - y);
			if (difx == dify){
					this.x = x;
					this.y = y;
			}else{
					System.out.println("Movimiento no permitido");
			}
		}
	}
	public String toString(){
		return "Alfil";
	}
}

