package Ejercicio1;


public class Tablero {
	final int dimx = 10;
	final int dimy = 10;
	final int numMinas = 20;
	Mina[][] minas = new Mina[dimx][dimy];
	
	public void creaMinas(){
		int minaspuestas = 0;
		int x, y;
		while(minaspuestas < numMinas){
			x = (int) ((int)(dimx-1)*Math.random());
			y = (int) ((int)(dimy-1)*Math.random());
			if(minas[x][y] == null){
			minas[x][y] = new Mina(x,y);
			minaspuestas++;
			}
		}
	}
	public int minasCerca(int x, int y){
		int minas = 0;
		minas += hayMina(x+1, y); //E
		minas += hayMina(x+1, y+1); //NE
		minas += hayMina(x, y+1); //N
		minas += hayMina(x, y-1);//S
		minas += hayMina(x-1, y);//O
		minas += hayMina(x-1, y-1);//SO
		minas += hayMina(x+1, y-1);//SE
		minas += hayMina(x-1, y+1); //NO
		return minas;
	}
	public int hayMina(int x, int y){
		if (minas[x][y] != null){
			if(minas[x][y].isActiva()){
			return 1;
			}else{
				return 0;
			}
		}else{
			return 0;
		}
	}
	public void desactivaMina(int x, int y){
		minas[x][y].setActiva(false);
	}
	
}
