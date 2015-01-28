package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CargadorFicheros implements CargaMonedas{

	@Override
	public HashMap<String, Moneda> cargaMonedas() {
		String linea;
		String[] moneda;
		HashMap<String, Moneda> monedas = new HashMap<>();
		BufferedReader lector;
		try {
			 lector = new BufferedReader(new FileReader("monedas.txt"));
			 while((linea = lector.readLine()) != null){
				 moneda = linea.split("\\$");
				 monedas.put(moneda[0], new Moneda(moneda[0], Double.parseDouble(moneda[1])));
			 }
			 lector.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(new JFrame(), "Error al leer el archivo", "Error!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return monedas;
	}

}
