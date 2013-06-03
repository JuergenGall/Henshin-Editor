package agg.gui.icons;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

public class NestedACIcon implements Icon {

	Color color;
	boolean addF;
	
	public NestedACIcon(Color aColor) {
		this.color = aColor;
	}

	public NestedACIcon(Color aColor, boolean ext) {
		this.color = aColor;
		this.addF = ext;
	}
	
	public void paintIcon(Component c, Graphics g, int x, int y) {
		g.setColor(Color.white);
		g.fillRect(x, y, getIconWidth(), getIconHeight());
		g.setColor(this.color);
		
//		g.setFont(new Font(Font.DIALOG, Font.BOLD,14));
//		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD,14));
		
		if (!this.addF) {
			g.drawString("G", x + 0, y + 10);
			g.drawString("A", x + 8, y + 13);
			g.drawString("C", x + 16, y + 15);
		} else {
			g.drawString("G", x + 0, y + 10);
			g.drawString("A", x + 8, y + 13);
			g.drawString("C", x + 16, y + 15);
			
			g.setColor(Color.red);
			g.drawString("F", x + 20, y + 8);
			g.setColor(this.color);
		}
		
//		g.setFont(font);
	}

	public int getIconWidth() {
		return 24;
	}

	public int getIconHeight() {
		return 16;
	}

}
