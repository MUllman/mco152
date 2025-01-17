package ullman.flicker;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Loads a single image from a url into a JLabel
 */
public class DownloadImageThread extends Thread {

	private final String url;
	private final JLabel label;

	public DownloadImageThread(final JLabel label, final String url) {
		this.url = url;
		this.label = label;
	}

	@Override
	public void run() {
		URL ur;
		try {
			ur = new URL(url);
			Image image = ImageIO.read(ur);
			ImageIcon icon = new ImageIcon(image);
			label.setIcon(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		super.run();
	}

}
