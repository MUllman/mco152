package ullman.ufo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import au.com.bytecode.opencsv.CSVReader;

public class ZipCodes {

	private ArrayList<ZipCode> codes;
	private final double maxLat;
	private final double maxLon;
	private final double minLat;
	private final double minLon;
	private double latLength;
	private double lonLength;

	public ZipCodes() throws IOException {
		maxLat = -2147483648D;
		maxLon = -2147483648D;
		minLat = 2147483647D;
		minLon = 2147483647D;
		readZipData();
		extractFeatures();
	}

	public String getZipCode(String city, String state) {
		String zip = "not found";
		for (ZipCode z : codes) {
			if (z.getCity().equals(city) && z.getState().equals(state)) {
				zip = z.getZip();
			}
		}
		return zip;
	}

	private void extractFeatures() {
		latLength = Math.abs(maxLat - minLat);
		lonLength = Math.abs(maxLon - minLon);
	}

	public void readZipData() throws IOException {
		CSVReader reader = new CSVReader(new FileReader("ZIP_CODES.txt"));
		reader.readNext();
		codes = new ArrayList<ZipCode>();
		String line[];
		double lat;
		double lon;
		while ((line = reader.readNext()) != null) {
			if ("".equals(line[1])) {
				lat = 0.0;
			} else {
				lat = Double.valueOf(line[1]);
			}
			if ("".equals(line[2])) {
				lon = 0.0;
			} else {
				lon = Double.valueOf(line[2]);
			}
			ZipCode zip = new ZipCode(line[0], lat, lon, line[4], line[3]);
			codes.add(zip);
		}
		reader.close();
	}
}
