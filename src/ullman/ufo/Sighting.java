package ullman.ufo;

import com.google.gson.annotations.SerializedName;

public class Sighting {
	private String description;
	private String location;

	@SerializedName("sighted_at")
	private String sightedAt;
	@SerializedName("reported_at")
	private String reportedAt;
	private String duration;
	private String shape;
	private String zip;

	@Override
	public String toString() {
		return "Sighting [location=" + location + ", dateSightedAt="
				+ sightedAt + ", shape=" + shape + ", zip=" + zip + "]";
	}

	public void SetZip(String zip) {
		this.zip = zip;
	}

	public String getDescription() {
		return description;
	}

	public String getLocation() {
		return location;
	}

	public String getDateSightedAt() {
		return sightedAt;
	}

	public String getDateReportedAt() {
		return reportedAt;
	}

	public String getDuration() {
		return duration;
	}

	public String getShape() {
		return shape;
	}
}
