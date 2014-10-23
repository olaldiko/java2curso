package Ejercicio3;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Principal {
	List<Integer> lista = new ArrayList<Integer>();
	
	public Boolean isCapicua(int num){
		String numero;
		numero = Integer.toString(num);
		for(int i = 0; i < numero.length();i++){
			for(int j = numero.length()-1; j > i;j--){
				if(numero.charAt(i) != numero.charAt(j)){
					return false;
				}
			}
		}
		return true;
	}
	public Boolean isPrimo(int num){
		int i = 2;  
		while (i <= num / 2)
		  {
		      if (num % i == 0)
		      {
		         return false;
		      }
		      i++;
		  }
		return true;
		}
	public Boolean sumaTrece(int num){
		String numero;
		int resultado = 0;
		char[] arr = new char[1];
		numero = Integer.toString(num);
		for(int i = 0; i < numero.length();i++){
			arr[0] = numero.charAt(i);
			resultado += Integer.parseInt(String.copyValueOf(arr));
		}
		if(resultado == 13){
		return true;
		}else{
			return false;
		}
		
	}
	public void initLista(){
		for(int i = 0; i < 10; i++){
			lista.add((int) (1000*Math.random()));
		}
	}
	public static void main(String[] args) {
		Principal p = new Principal();
		p.initLista();
		switch(args[0]){
		case "primos":
			p.filtraPrimos();
			break;
		case "capicua":
			p.filtraCapi();
			break;
		case "sumatrece":
			p.filtraTrece();
			break;
		default:
			System.out.println("Elige un parametro!!!");
			break;
		}
	}
	public void filtraCapi() {
			ListIterator<Integer> it = lista.listIterator();
			int p;
			for (int i = 1; i <= lista.size(); i++) {
				p = it.next();
				if(isCapicua(p)){
					System.out.println(p);
				}
			}
	}
	public void filtraTrece() {
		ListIterator<Integer> it = lista.listIterator();
		int p;
		for (int i = 1; i <= lista.size(); i++) {
			p = it.next();
			if(sumaTrece(p)){
				System.out.println(p);
			}
		}
	}
	public void filtraPrimos() {
		ListIterator<Integer> it = lista.listIterator();
		int p;
		for (int i = 1; i <= lista.size(); i++) {
			p = it.next();
			if(isPrimo(p)){
				System.out.println(p);
			}
		}
		
	}

}
