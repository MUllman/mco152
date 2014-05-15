package ullman.mtamap;

import java.awt.Color;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import au.com.bytecode.opencsv.CSVReader;

public class Routes {

	private final ArrayList<Route> routes = new ArrayList<Route>();

	public Routes() throws IOException {
		CSVReader reader = new CSVReader(new FileReader("routes.txt"));
		reader.readNext();
		String line[];
		while ((line = reader.readNext()) != null) {
			if (!"".equals(line[7])) {
				Route route = new Route(line[0],
						Color.decode((new StringBuilder("#")).append(line[7])
								.toString()));
				routes.add(route);
			}
		}
		reader.close();
	}

	public Color getColor(String routeId) {
		Route route = null;
		for (Route r : routes) {
			if (r.getRouteId().equals(routeId)) {
				route = r;
			}
		}
		if (route == null) {
			return Color.GRAY;
		} else {
			return route.getColor();
		}
	}

}
