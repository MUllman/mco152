package ullman.mtamap;

import java.awt.Color;

public class Route {

	private final String routeId;
	private final Color color;

	public Route(String routeId, Color color) {
		this.routeId = routeId;
		this.color = color;
	}

	public String getRouteId() {
		return routeId;
	}

	public Color getColor() {
		return color;
	}

}
