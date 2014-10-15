import java.util.Comparator;


public class Vehiculo implements Comparator<Vehiculo>{
	String matricula;
	String bastidor;
	

	public Vehiculo(String matricula, String bastidor)throws CarException{
		if((matricula.length()!= 8)||(bastidor.length()!= 10)){
			throw new CarException();
		}else{
		this.matricula = matricula;
		this.bastidor = bastidor;
		}
	}
	public Vehiculo(){
		matricula = "0000-AAA";
		bastidor = "ZZ00000000";
	}
	public String toString(){
		return matricula+" "+bastidor;
		
	}
	
	@Override
	public int compare(Vehiculo o1, Vehiculo o2) {
		if((o1.matricula == o2.matricula)&&(o1.bastidor == o2.bastidor)){
			return 0;
		}else{
			if(o1.matricula == o2.matricula){
				return 1;
			}else{
				return -1;
			}
		}
	}
}
