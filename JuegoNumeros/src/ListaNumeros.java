import java.util.ArrayList;
import java.util.ListIterator;

public class ListaNumeros{
	ArrayList<Integer[]> listanumeros = new ArrayList<Integer[]>();
	Valideitor valid = new Valideitor();
	
	public void creaLista() {
		Integer[] num = new Integer[4];
		for(int i = 0; i < 9999; i++){
			num = intToArray(i);
			if(valid.validar(num)){
				listanumeros.add(num);
			}
		}
	}
	public int comparaNum(int muertos, int heridos){
		Integer[] numprobado = listanumeros.get(0);
		int resultado = 0;
		ListIterator<Integer[]> it = listanumeros.listIterator();
		Integer[] num;
		int muertocont = 0;
		int heridocont = 0;
		while(it.hasNext()){
			num = it.next();
			for(int i = 0; i < num.length;i++){
				for(int j = num.length-1; j > 0; j--){
					if(num[i] == numprobado[j]){
						if(num[i] == numprobado[j]){
							if(j != i){
								heridocont++;
							}else{
								muertocont++;
							}
						}
					}
				}
			}
			if((muertocont == muertos)&&(heridocont == heridos)){
				resultado = 1;
			}else{
				it.remove();
			}
			if(listanumeros.size()== 0){
				resultado = -1;
			}
		}
		return resultado;
	}
	public Integer[] intToArray(int i){
		Integer[] num = new Integer[4];
		for(int j = 0, k = 1000; j < 4;j++, k /=10){
			num[j] = i/k;
			i /= 10;	
		}
		return num;
		
	}
	public int ArrToInt(Integer[] num ){
		int numint = 0;
		for(int i = 0; i < num.length; i++){
			numint += num[i]*Math.log10(i);
		}
		return numint;
	}

}
