package ullman.weatherGraph;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class WeatherFrame extends JFrame implements ActionListener {

	private final WeatherPanel panel;
	private final JButton button;
	private final JButton clear;
	private Thread thread;
	private final DrawGraph drawGraph;

	public WeatherFrame() {
		button = new JButton("Enter");
		clear = new JButton("Reset");
		panel = new WeatherPanel();
		drawGraph = new DrawGraph();
		setSize(400, 400);
		setLocation(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(panel, BorderLayout.NORTH);
		contentPane.add(drawGraph, BorderLayout.CENTER);
		contentPane.add(button, BorderLayout.EAST);
		contentPane.add(clear, BorderLayout.SOUTH);
		button.addActionListener(this);
		clear.addActionListener(new ResetListener());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String place = panel.getUserInput();

		thread = new WeatherThread(place, drawGraph);
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
		}

	}
}
