package ullman.clock;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class ClockFrame extends JFrame {

	public ClockFrame() {
		System.out.println("please work");
		setSize(301, 301);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setName("CLOCK");
		ClockComponent com = new ClockComponent(this);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(com, "Center");
		Thread clock = new ClockThread(com);
		clock.start();
	}

	public static void main(String[] args) {
		ClockFrame frame = new ClockFrame();
		frame.setVisible(true);
	}

}
