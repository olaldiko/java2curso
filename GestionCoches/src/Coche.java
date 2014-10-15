
public class Coche extends Vehiculo{
	Persona propietario;
	String ciudad;
	
	
	public Coche(String matricula, String bastidor, Persona propietario, String ciudad)throws CarException{
		if((matricula.length()!= 8)||(bastidor.length()!= 10)){
			throw new CarException();
		}else{
		this.matricula = matricula;
		this.bastidor = bastidor;
		this.propietario = propietario;
		this.ciudad = ciudad;
		}
	}

	public void setPropietario(Persona prop){
		propietario = prop;
	}
	
	public void setCiudad(String city){
		ciudad = city;
	}
	public String toString(){
		return matricula+" "+bastidor+" "+propietario+" "+ciudad;
	}
}	