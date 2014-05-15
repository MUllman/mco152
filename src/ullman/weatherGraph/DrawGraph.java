package ullman.weatherGraph;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class DrawGraph extends JComponent {

	private double maxTemp;
	private double minTemp;
	private final int width = 325;
	private final int height = 300;
	private Temp[] temps;

	public DrawGraph() {
		temps = new Temp[0];
	}

	public void giveList(List[] list) {
		temps = new Temp[list.length];
		for (int i = 0; i < list.length; i++) {
			temps[i] = list[i].getTemp();
		}

		minTemp = temps[0].getDay();
		maxTemp = temps[0].getDay();
		for (Temp t : temps) {
			if (t.getDay() < minTemp) {
				minTemp = t.getDay();
			}
			if (t.getDay() > maxTemp) {
				maxTemp = t.getDay();
				repaint();
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		Color[] colors = { Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW,
				Color.PINK, Color.ORANGE, Color.GRAY };
		if (temps.length == 0) {
			return;
		} else {
			int x = width / 7;
			int y = 0;
			for (int i = 0; i < 7; i++) {
				g.setColor(colors[i]);
				g.fillRect(i * x, (int) (height - (temps[i].getDay() * 2)), x,
						(int) (temps[i].getDay() * 4));
				g.drawString(String.valueOf((int) temps[i].getDay()), i * x,
						(int) (height - (temps[i].getDay() * 2)));
			}
		}
	}
}
