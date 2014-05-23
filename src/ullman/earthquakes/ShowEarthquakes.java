package ullman.earthquakes;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

public class ShowEarthquakes extends JFrame {

	private final JList<String> quakes;
	private final DefaultListModel<String> listModel;
	private final Thread thread;

	public ShowEarthquakes() {
		listModel = new DefaultListModel<>();
		thread = new EarthquakeThread(listModel);
		thread.start();
		quakes = new JList<>(listModel);
		quakes.setCellRenderer(new MyCellRender());
		add(quakes);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Earthquakes");
		this.setSize(200, 600);
		this.setLocationRelativeTo(null);

	}

	public static void main(String[] args) {
		ShowEarthquakes quake = new ShowEarthquakes();
		quake.setVisible(true);
	}

}
