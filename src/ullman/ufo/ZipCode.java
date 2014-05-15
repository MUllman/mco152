package ullman.ufo;

public class ZipCode {
	private final double lat;
	private final double lon;
	private final String zip;
	private final String state;
	private final String city;

	public ZipCode(String zip, double lat, double lon, String state, String city) {
		this.zip = zip;
		this.lon = lon;
		this.lat = lat;
		this.state = state;
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public double getLat() {
		return lat;
	}

	public double getLon() {
		return lon;
	}

	public String getState() {
		return state;
	}

	public String getCity() {
		return city;
	}
}
