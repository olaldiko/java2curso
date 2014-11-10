import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;


public class RenderCelda implements ListCellRenderer<Contacto> {
	DefaultListCellRenderer render = new DefaultListCellRenderer();
	@Override
	public Component getListCellRendererComponent(
			JList<? extends Contacto> list, Contacto value, int index,
			boolean isSelected, boolean cellHasFocus) {
		render.setBackground(Color.WHITE);
		render.setBorder(BorderFactory.createLineBorder(Color.RED));
		render.setForeground(Color.BLACK);
				if(value instanceof Amigo){
						render.setFont(new Font("Arial", Font.ITALIC, 16));
						render.setIcon(new ImageIcon("amigo.png"));
				}else{
					if(value instanceof Familiar){
						render.setFont(new Font("Arial", Font.BOLD, 16));
						render.setIcon(new ImageIcon("familia.png"));
					}else{
						if(value instanceof Colega){
							render.setFont(new Font("Times New Roman", Font.BOLD, 16));
							render.setIcon(new ImageIcon("utilities.png"));
						}
					}		
				}
				if(isSelected){
				render.setBackground(Color.RED);
				render.setForeground(Color.WHITE);
				}
				render.setText(value.toString());
		return render;
	}

}
