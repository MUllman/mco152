package ullman.pie;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Prime extends JFrame implements ActionListener, Runnable {

	private final JButton button;
	private final JTextArea area;
	private StringBuilder sb;

	public Prime() {
		button = new JButton("Start");
		area = new JTextArea();
		JScrollPane scroll = new JScrollPane(area);
		setSize(800, 600);
		setLocation(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(button, BorderLayout.SOUTH);
		add(scroll, BorderLayout.CENTER);

		button.addActionListener(this);
	}

	public static void main(String[] args) {
		Prime prime = new Prime();
		prime.setVisible(true);
	}

	@Override
	public void run() {
		sb = new StringBuilder();
		sb.append(1);
		sb.append("\n");
		sb.append(2);
		sb.append("\n");
		area.setText(sb.toString());
		for (int i = 3; i < 10000000; i = i + 2) {
			boolean prime = true;
			for (int j = i / 2; j > 1; j--) {
				if (i % j == 0) {
					prime = false;
					break;
				}
			}
			if (prime == true) {
				sb.append(i);
				sb.append("\n");
				area.setText(sb.toString());
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread t = new Thread(this);
		t.start();
	}
}
