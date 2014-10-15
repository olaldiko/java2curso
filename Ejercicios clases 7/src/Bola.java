import java.util.Random;


public class Bola {
	Double posX, posY;
	Double radio;
	boolean visible = true;
	public Bola(Double limX, Double limY, Double limRad){
		Random pos = new Random();
		posX = limX*pos.nextDouble();
		posY = limY*pos.nextDouble();
		radio = limRad*pos.nextDouble();
		
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public boolean hayColision(Bola bala){
		double dx, dy, distancia;
		dx = Math.abs(this.posX-bala.posX);
		dy = Math.abs(this.posY-bala.posY);
		distancia = Math.sqrt((dx*dx)+(dy*dy));
		if(distancia < (bala.radio + this.radio)){
			return true;
		}else{
			return false;
		}	
	}
	public void mover(int v, Double angulo){
		posX += v*Math.cos(Math.toRadians(angulo));
		posY += v*Math.sin(Math.toRadians(angulo));
	}
	public String toString(){
		return "X: "+this.posX+" Y: "+this.posY+" Radio: "+this.radio;
	}
	public void resetPos(){
		posX = 0.0;
		posY = 0.0;
	}
}
