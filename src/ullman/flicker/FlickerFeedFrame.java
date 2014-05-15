package ullman.flicker;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class FlickerFeedFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private final JLabel[] labels;
	private final JPanel panel;

	public FlickerFeedFrame() {
		labels = new JLabel[20];
		panel = new JPanel();
		setSize(800, 600);
		Thread flickerFeed = new DownloadFlickerFeedThread(this);
		flickerFeed.start();
		JScrollPane scroll = new JScrollPane(panel,
				JScrollPane.VERTICAL_SCROLLBAR_NEVER,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scroll);

		for (int i = 0; i < 20; i++) {
			labels[i] = new JLabel();
			panel.add(labels[i]);
		}

	}

	/**
	 * Runs a LoadImageThread for each image in the feed
	 */
	public void loadImages(final FlickerFeed feed) {

		Item[] items = feed.getItems();
		for (int i = 0; i < 20; i++) {
			Thread image = new DownloadImageThread(labels[i], items[i]
					.getMedia().getM());
			image.start();
		}

	}

	public static void main(final String args[]) {
		new FlickerFeedFrame().setVisible(true);
	}

}
