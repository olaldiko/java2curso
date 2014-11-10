import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.plaf.basic.BasicArrowButton;


public class Principal extends JFrame implements ActionListener , KeyListener{
	private static final long serialVersionUID = 8390849717731066438L;
	final int HSIZE = 7;
	final int VSIZE = 9;
	JButton barr, babj, bizq, bder;
	Integer[][] casillas = {{0,0,0,0,0,0,0},
							{0,1,1,1,1,1,0}, 
							{0,1,1,1,0,1,0},
							{0,1,0,1,0,1,0},
							{0,1,0,1,0,1,3},
							{2,1,0,1,0,1,0},
							{0,1,1,1,0,1,0},
							{0,1,0,0,0,1,0},
							{0,0,0,0,0,0,0}};
	JPanel[][] paneles = new JPanel[VSIZE][HSIZE];
	
	public Principal(){
		super("Laberinto");
		setSize(800,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(crearPanelPrincipal());
		setVisible(true);
		calcMovPosibles();
	}
	private Container crearPanelPrincipal() {
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		split.add(crearMapa());
		split.add(crearBotones());
		split.setDividerLocation(500);
		return split;
	}
	private Component crearBotones() {
		JPanel pbotones = new JPanel(new GridLayout(3, 3));
		
		pbotones.add(new JPanel());
		pbotones.add(barr = new BasicArrowButton(BasicArrowButton.NORTH));
		pbotones.add(new JPanel());
		pbotones.add(bizq = new BasicArrowButton(BasicArrowButton.WEST));
		pbotones.add(new JPanel());
		pbotones.add(bder = new BasicArrowButton(BasicArrowButton.EAST));
		pbotones.add(new JPanel());
		pbotones.add(babj = new BasicArrowButton(BasicArrowButton.SOUTH));
		pbotones.add(new JPanel());
//		barr.setFont(new Font("Arial", Font.BOLD, 24));
//		babj.setFont(new Font("Arial", Font.BOLD, 24));
//		bizq.setFont(new Font("Arial", Font.BOLD, 24));
//		bder.setFont(new Font("Arial", Font.BOLD, 24));
		barr.addActionListener(this);
		babj.addActionListener(this);
		bizq.addActionListener(this);
		bder.addActionListener(this);
		barr.setActionCommand("Arriba");
		babj.setActionCommand("Abajo");
		bizq.setActionCommand("Izquierda");
		bder.setActionCommand("Derecha");
		barr.setMnemonic(KeyEvent.VK_W);
		babj.setMnemonic(KeyEvent.VK_S);
		bizq.setMnemonic(KeyEvent.VK_A);
		bder.setMnemonic(KeyEvent.VK_D);
		return pbotones;
	}
	private Component crearMapa() {
		JPanel parent = new JPanel(new BorderLayout());
		JPanel mapa = new JPanel(new GridLayout(VSIZE, HSIZE));
		for(int i = 0; i < VSIZE; i++){
			for(int j = 0; j < HSIZE; j++){
				paneles[i][j] = new JPanel();
				paneles[i][j].setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
				switch(casillas[i][j]){
					case 0:
						paneles[i][j].setBackground(Color.RED);
						break;
					case 1:
						paneles[i][j].setBackground(Color.WHITE);
						break;
					case 2:
						paneles[i][j].setBackground(Color.GREEN);
						break;
					case 3:
						paneles[i][j].setBackground(Color.BLUE);
						break;
				}
				mapa.add(paneles[i][j]);
			}
		}
		parent.add(mapa, BorderLayout.CENTER);
		return parent;
	}
	public static void main(String[] args) {
		Principal p = new Principal();

	}
	public void calcMovPosibles(){
		int x = 0, y = 0;
		Pos p = calculaPosicion();
		x= p.x;
		y = p.y;
		if((y == VSIZE-1)||(paneles[y+1][x].getBackground() == Color.RED)){
			babj.setEnabled(false);
		}else{
			babj.setEnabled(true);
		}
		if(y > 0){
		if((paneles[y-1][x].getBackground() == Color.RED)){
			barr.setEnabled(false);
		}else{
			barr.setEnabled(true);
		}
		}else{
			barr.setEnabled(false);
		}
		if((x == HSIZE-1)|(paneles[y][x+1].getBackground() == Color.RED)){
			bder.setEnabled(false);
		}else{
			bder.setEnabled(true);
		}
		if(x > 0){
		if((paneles[y][x-1].getBackground() == Color.RED)){
			bizq.setEnabled(false);
		}else{
			bizq.setEnabled(true);
		}
		}else{
			bizq.setEnabled(false);
		}
	}
	public Pos calculaPosicion(){
		Pos p = new Pos();
		for(int i = 0; i < VSIZE; i++){
			for(int j = 0; j < HSIZE; j++){
				if(paneles[i][j].getBackground() == Color.GREEN){
					p.y = i;
					p.x = j;
				}
			}
		}
		return p;
	}
	public boolean moverAbajo(){
		Pos p= calculaPosicion();
		if(paneles[p.y+1][p.x].getBackground() == Color.BLUE){
			return true;
		}else{
			paneles[p.y][p.x].setBackground(Color.WHITE);
			paneles[p.y+1][p.x].setBackground(Color.GREEN);
			return false;
		}
	}
	public boolean moverArriba(){
		Pos p= calculaPosicion();
		if(paneles[p.y-1][p.x].getBackground() == Color.BLUE){
			return true;
		}else{
			paneles[p.y][p.x].setBackground(Color.WHITE);
			paneles[p.y-1][p.x].setBackground(Color.GREEN);
			return false;
		}
	}
	public boolean moverIzquierda(){
		Pos p= calculaPosicion();
		if(paneles[p.y][p.x-1].getBackground() == Color.BLUE){
			return true;
		}else{
			paneles[p.y][p.x].setBackground(Color.WHITE);
			paneles[p.y][p.x-1].setBackground(Color.GREEN);
			return false;
		}
	}
	public boolean moverDerecha(){
		Pos p= calculaPosicion();
		if(paneles[p.y][p.x+1].getBackground() == Color.BLUE){
			return true;
		}else{
			paneles[p.y][p.x].setBackground(Color.WHITE);
			paneles[p.y][p.x+1].setBackground(Color.GREEN);
			return false;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean ganador = false;
		switch(e.getActionCommand()){
		case "Arriba":
			ganador = moverArriba();
			calcMovPosibles();
			break;
		case "Abajo":
			ganador = moverAbajo();
			calcMovPosibles();
			break;
		case "Izquierda":
			ganador = moverIzquierda();
			calcMovPosibles();
			break;
		case "Derecha":
			ganador = moverDerecha();
			calcMovPosibles();
			break;
		}
		if(ganador){
			JOptionPane.showMessageDialog(this, "Felicidades! Has ganado!",	"Fin del juego", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		}
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
