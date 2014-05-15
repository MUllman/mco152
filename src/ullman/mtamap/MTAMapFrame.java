package ullman.mtamap;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;

import javax.swing.JFrame;

public class MTAMapFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public MTAMapFrame() {
		try {
			Shapes shapes = new Shapes();
			Trips trips = new Trips();
			Routes routes = new Routes();
			ShapesView view = new ShapesView(trips, routes, shapes);
			Container contentPane = getContentPane();
			contentPane.setLayout(new BorderLayout());
			contentPane.add(view, "Center");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("MTA Map");
			setSize(800, 600);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
