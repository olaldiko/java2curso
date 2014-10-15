import java.util.Scanner;


public class Fecha {
	int dd;
	int mm;
	int aaaa;
	/**
	 * Pide la fecha por terminal ,la valida y la aplica.
	 */
	public void introduceFechaTerm(){
		int dd, mm, aaaa;
		Scanner teclado = new Scanner(System.in);
		do{
		System.out.println("Ïntroduce el dia: ");
		dd = teclado.nextInt(); teclado.nextLine();
		System.out.println("Ïntroduce el mes: ");
		mm = teclado.nextInt(); teclado.nextLine();
		System.out.println("Ïntroduce el año");
		aaaa = teclado.nextInt(); teclado.nextLine();
		}while(!validaFecha(dd, mm, aaaa));
		this.dd = dd;
		this.mm = mm;
		this.aaaa = aaaa;
	}
	public void setFecha(int dd, int mm, int aaaa){
		if(validaFecha(dd,mm,aaaa)){
			this.dd = dd;
			this.mm = mm;
			this.aaaa = aaaa;
		}
	}
 /**
  *  Valida que la fecha introducida sea correcta, returnea bool y indica resultado en la terminal
 * @param dd
 * @param mm
 * @param aaaa
 * @return fechaok
 */
	public boolean validaFecha(int dd, int mm, int aaaa){
		boolean fechaOk = true;
		if((dd < 1)||(dd > 31)||(((mm <7)&&(mm > 8)&&(mm% 2 == 0))&&(dd > 30))||((mm == 2)&&(dd > 28))){
			System.out.println("Ël dia introducido no es correcto");
			fechaOk = false;
		}
		if((mm < 1)||(mm > 12)){
			System.out.println("Ël mes introducido no es correcto");
			fechaOk = false;
		}
		if(aaaa <= 0){
			System.out.println("Ël año introducido no es correcto");
			fechaOk = false;
		}
		if(fechaOk){
			return true;
		}else{
			System.out.println("La fecha introducida no es correcta");
			return false;
		}
	}
}
