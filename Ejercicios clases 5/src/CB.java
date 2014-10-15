
public class CB {
	static int numID;
	int ID;
	public Persona titular;
	private Double cantidad;
	
	public CB(){
		ID = numID++;
		titular = new Persona();
		cantidad = 0.0;
	}
	public CB(Persona pers){
		ID = numID++;
		titular = pers;
		cantidad = 0.0;
	}
	public void addDinero(Double transferido){
		cantidad += transferido;
	}
	public boolean remDinero(Double retirado){
		if(cantidad >= retirado){
			cantidad -= retirado;
			return true;
		}else{
			return false;
		}
	}
	public boolean transferirA(CB destino, Double cantidad){
		if(remDinero(cantidad)){
			destino.addDinero(cantidad);
			return true;
		}else{
			return false;
		}
	}
	public boolean transferirDe(CB origen, Double cantidad){
		
		if(origen.remDinero(cantidad)){
		addDinero(cantidad);
			return true;
		}else{
			return false;
		}
	}
	public Double getCantidad(){
		return cantidad;
	}
	public String toString(){
		
		return "ID: "+ID+" Titular: "+titular+" Balance: "+cantidad;
	}
	public int getID() {
		return ID;
	}
	public Persona getTitular() {
		return titular;
	}
}
	