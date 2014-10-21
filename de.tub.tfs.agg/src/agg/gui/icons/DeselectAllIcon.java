package agg.gui.icons;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

public class DeselectAllIcon implements Icon {

	boolean isEnabled;

	public DeselectAllIcon() {
		this.isEnabled = false;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		if (this.isEnabled) {
			g.setColor(Color.black);
			g.drawLine(6, 6, 14, 6);
			g.drawLine(4, 4, 12, 14);
			g.drawLine(16, 6, 12, 14);
			g.setColor(Color.white);
			g.fillRect(4, 4, 4, 4);
			g.fillRect(14, 4, 4, 4);
			g.fillRect(10, 14, 4, 4);
			g.setColor(Color.black);
			g.drawRect(4, 4, 4, 4);
			g.drawRect(14, 4, 4, 4);
			g.drawRect(10, 14, 4, 4);
		} else {
			g.setColor(Color.gray.darker());
			g.drawLine(6, 6, 14, 6);
			g.drawLine(4, 4, 12, 14);
			g.drawLine(16, 6, 12, 14);
			g.fillRect(4, 4, 4, 4);
			g.fillRect(14, 4, 4, 4);
			g.fillRect(10, 14, 4, 4);
		}
	}

	public void setEnabled(boolean enabled) {
		this.isEnabled = enabled;
	}

	public int getIconWidth() {
		return 16;
	}

	public int getIconHeight() {
		return 16;
	}

}