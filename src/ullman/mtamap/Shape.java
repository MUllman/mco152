package ullman.mtamap;

public class Shape {
	
	private String shapeId;
	private double lat;
	private double lon;

	public Shape(String shapeId, double lat, double lon) {
		this.shapeId = shapeId;
		this.lat = lat;
		this.lon = lon;
	}

	public String getShapeId() {
		return shapeId;
	}

	public double getLat() {
		return lat;
	}

	public double getLon() {
		return lon;
	}

}
