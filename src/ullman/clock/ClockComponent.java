package ullman.clock;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Calendar;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class ClockComponent extends JComponent {

	private static final double TWO_PI = 2.0 * Math.PI;
	private final Calendar now = Calendar.getInstance();
	int width = 300;
	int hight = 300;
	int xcent = width / 2;
	int ycent = hight / 2;
	int minhand;
	int maxhand;
	double rdns;
	int dxmin;
	int dymin;
	int dxmax;
	int dymax;
	double radins;
	double sine;
	double cosine;
	double fminutes;
	private final JFrame frame;

	public ClockComponent(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void paintComponent(Graphics g) {
		int hours = now.get(Calendar.HOUR);
		int minutes = now.get(Calendar.MINUTE);
		int seconds = now.get(Calendar.SECOND);
		int millis = now.get(Calendar.MILLISECOND);
		minhand = width / 8;
		maxhand = (int) (width / 2.1);
		rdns = (seconds + ((double) millis / 1000)) / 60.0;
		drw(g, rdns, 0, maxhand, Color.RED);
		g.setColor(Color.BLACK);
		g.drawString(hours + ":" + minutes + ":" + seconds, minhand + 90,
				maxhand + 60);
		minhand = 0; // Minute hand starts in middle.
		maxhand = (int) (width / 2.25);
		fminutes = (minutes + rdns) / 60.0;
		drw(g, fminutes, 0, maxhand, Color.BLUE);
		minhand = 0; // Minute hand starts in middle.
		maxhand = width / 3;
		drw(g, (hours + fminutes) / 12.0, 0, maxhand, Color.YELLOW);
		g.setColor(Color.BLACK);
		g.drawOval(0, 0, width, hight);
		g.drawString("9", xcent - 145, ycent - 0);
		g.drawString("3", xcent + 140, ycent - 0);
		g.drawString("6", xcent, ycent + 145);
		g.drawString("12", xcent, ycent - 135);
	}

	public void drw(Graphics g, double prct, int minRadius, int maxRadius,
			Color c) {
		radins = (0.5 - prct) * TWO_PI;
		sine = Math.sin(radins);
		cosine = Math.cos(radins);
		dxmin = xcent + (int) (minRadius * sine);
		dymin = ycent + (int) (minRadius * cosine);

		dxmax = xcent + (int) (maxRadius * sine);
		dymax = ycent + (int) (maxRadius * cosine);

		g.setColor(c);
		g.drawLine(dxmin, dymin, dxmax, dymax);
	}

	void updateTime() {
		now.setTimeInMillis(System.currentTimeMillis());
	}

}
