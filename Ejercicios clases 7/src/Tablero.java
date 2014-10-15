
public class Tablero {
	Bola[] bolas;
	Bola bala = new Bola(0.0,0.0,3.0);
	Double limX, limY, limRad;
	int numBolas = 0;
	int numAcertadas = 0;
	int numDisparos = 0;
	int V = 5;
	int puntos = 0;
	public Tablero(int limX, int limY, int limRad, int V, int numBolas){
		this.limX = (double) limX;
		this.limY = (double) limY;
		this.V = V;
		this.limRad = (double) limRad;
		bolas = new Bola[numBolas];
		creaBolas(numBolas);
	}
	public void creaBolas(int nVeces){
		for(int i = 0; i < nVeces; i++){
		bolas[numBolas++] = new Bola(limX, limY, limRad);
		}
	}
	public boolean disparo(Double angulo) throws InterruptedException{
		boolean acertado = false;
		while((bala.posX < limX)&&(bala.posX > 0)&&(bala.posY > 0)&&(bala.posX < limY)&&(acertado == false)){
			bala.mover(V, angulo);
			for(int i = 0;(i < numBolas)&&(acertado == false); i++){
				if(bolas[i].hayColision(bala)&&(bolas[i].isVisible())){
					acertado = true;
					bolas[i].setVisible(false);
					puntos += bolas[i].radio;
					numAcertadas++;
				}
			}
		if(!acertado){
			Thread.sleep(5);
			bala.mover(V, angulo);
		}
		}
		if(!acertado){
			numDisparos++;
		}
		bala.resetPos();
		return acertado;
	}
	public void visualizaBolas(){
		for(int i = 0; i < numBolas;i++){
			if(bolas[i].isVisible()){
				System.out.println(bolas[i]);
			}
		}
	}
	public boolean endJuego(){
		return (numAcertadas == numBolas)||(numDisparos == 3);
	}
	public int getPuntos(){
		return puntos;
	}
}
