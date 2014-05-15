package ullman.smiley;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileyFace extends JComponent {

	@Override
	public void paintComponent(Graphics g) {

		g.drawLine(0, 0, getWidth(), getHeight());
		g.drawLine(0, getHeight(), getWidth(), 0);
		g.setColor(Color.GREEN);
		g.fillOval(getWidth() / 2 - 50, getHeight() / 2 - 50, 100, 100);
	}
}
