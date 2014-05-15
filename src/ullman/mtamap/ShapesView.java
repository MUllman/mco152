package ullman.mtamap;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Iterator;
import java.util.List;

import javax.swing.JComponent;

public class ShapesView extends JComponent {

	private static final long serialVersionUID = 1L;
	private final Trips trips;
	private final Routes routes;
	private final Shapes shapes;

	public ShapesView(Trips trips, Routes routes, Shapes shapes) {
		this.trips = trips;
		this.routes = routes;
		this.shapes = shapes;
	}

	@Override
	protected void paintComponent(Graphics g1) {
		super.paintComponent(g1);
		Graphics2D g = (Graphics2D) g1;
		int width = getWidth();
		int height = getHeight();
		int dimension = Math.min(width, height);
		double minLat = shapes.getMinLat();
		double minLon = shapes.getMinLon();
		double latLength = shapes.getLatLength();
		double lonLength = shapes.getLonLength();
		List<String> shapeIds = shapes.getShapeIds();
		for (Iterator iterator = shapeIds.iterator(); iterator.hasNext();) {
			String shapeId = (String) iterator.next();
			List<Shape> list = shapes.getShapes(shapeId);
			Trip trip = trips.getTrip(shapeId);
			if (trip != null) {
				Color color = routes.getColor(trip.getRouteId());
				g.setColor(color);
				for (int i = 1; i < list.size(); i++) {
					Shape a = list.get(i - 1);
					Shape b = list.get(i);
					int x1 = (int) (((a.getLat() - minLat) * dimension) / latLength);
					int y1 = (int) (((a.getLon() - minLon) * dimension) / lonLength);
					int x2 = (int) (((b.getLat() - minLat) * dimension) / latLength);
					int y2 = (int) (((b.getLon() - minLon) * dimension) / lonLength);
					if (x1 != x2 || y1 != y2) {
						g.drawLine(x1, y1, x2, y2);
					}
				}
			}
		}
	}
}
