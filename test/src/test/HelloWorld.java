package test;


import javax.swing.JButton;
import javax.swing.JFrame; 
public class HelloWorld {
	public static void main(String args[]) {
		JFrame myFrame = new JFrame(); 
		JButton boton = new JButton();
		String myTitle = "Blank Frame";
		myFrame.setTitle(myTitle); 
		myFrame.setSize(300, 200); 
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		myFrame.setVisible(true);
		boton.setBounds(20, 20, 50, 20);
		boton.setVisible(true);
	} 
}