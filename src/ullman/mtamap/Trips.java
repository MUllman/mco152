package ullman.mtamap;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import au.com.bytecode.opencsv.CSVReader;

public class Trips {

	private final ArrayList<Trip> trips = new ArrayList<Trip>();

	public Trips() throws IOException {
		CSVReader reader = new CSVReader(new FileReader("trips.txt"));
		reader.readNext();
		String line[];
		while ((line = reader.readNext()) != null) {
			Trip trip = new Trip(line[0], line[6]);
			trips.add(trip);
		}
		reader.close();
	}

	public Trip getTrip(String shapeId) {
		Trip found = null;
		for (Trip t : trips) {
			if (t.getShapeId().equals(shapeId)) {
				found = t;
			}
		}
		return found;
	}
}
