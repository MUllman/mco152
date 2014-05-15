package ullman.weather;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class WeatherFrame extends JFrame implements ActionListener {

	private final JTextArea area;
	private final WeatherPanel panel;
	private final JButton button;
	private final JButton clear;

	public WeatherFrame() {
		button = new JButton("Enter");
		clear = new JButton("Reset");
		area = new JTextArea();
		panel = new WeatherPanel();
		setSize(800, 600);
		setLocation(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(panel, BorderLayout.NORTH);
		add(button, BorderLayout.EAST);
		add(clear, BorderLayout.SOUTH);
		add(area, BorderLayout.CENTER);

		button.addActionListener(this);
		clear.addActionListener(new ResetListener());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String place = panel.getUserInput();

		Thread thread = new WeatherThread(place, area);
		thread.start();
	}

	public static void main(String[] args) {
		WeatherFrame frame = new WeatherFrame();
		frame.setVisible(true);
	}

	private class ResetListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			panel.reset();
			area.setText("");
		}

	}
}
