package Ejercicio2;

import java.util.Comparator;


public class Figura implements Comparable<Figura>{
	int x, y;
	public Figura(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Figura o) {
		if((this.x == o.x)&&(this.y == o.y)){
		return 0;
		}else{
			if((Math.abs(Math.sqrt((this.x+this.y)))) < (Math.abs(Math.sqrt((o.x+o.y))))){
				return -1;
			}else{
				return 1;
			}
		}
	}
	public int calcArea(){
		return 0;
	}
	public static Comparator<Figura> Area = new Comparator<Figura>(){
		public int compare(Figura o1, Figura o2) {
			if(o1.calcArea() > o2.calcArea()){
				return 1;
			}else{
				if(o1.calcArea() == o2.calcArea()){
					return 0;
				}
				return -1;
			}
		}
	};
}
