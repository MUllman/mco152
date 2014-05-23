package ullman.earthquakes;

public class Earthquake {

	private final double magnitude;
	private final String location;

	public Earthquake(double magnitude, String location) {
		super();
		this.magnitude = magnitude;
		this.location = location;
	}

	public double getMagnitude() {
		return magnitude;
	}

	public String getLocation() {
		return location;
	}

	@Override
	public String toString() {
		return magnitude + " " + location;

	}

}
