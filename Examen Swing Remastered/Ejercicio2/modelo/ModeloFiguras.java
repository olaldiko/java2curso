package modelo;

import java.util.ArrayList;
import java.util.Observable;

public class ModeloFiguras extends Observable{
	ArrayList<Figuras> figuras = new ArrayList<>();
	Double area;
	public void addFigura(Figuras f){
		figuras.add(f);
		this.recalcularAreaTotal();
		this.setChanged();
		this.notifyObservers();
	}
	public void removeFigura(Figuras f){
		figuras.remove(f);
		this.recalcularAreaTotal();
		this.setChanged();
		this.notifyObservers();
	}
	public ArrayList<Figuras> getFiguras(){
		return figuras;
	}
	public void recalcularAreaTotal(){
		area = 0.0;
		for(Figuras f: figuras){
			area += f.calcularArea();
		}
	}
	public Double getArea(){
		return area;
	}
}
