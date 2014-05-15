package ullman.smiley;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class SmileyFrame extends JFrame {

	public SmileyFrame() {
		setTitle("SMILE");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new SmileyFace(), BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		SmileyFrame frame = new SmileyFrame();
		frame.setVisible(true);
	}
}