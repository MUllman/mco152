package ullman.mtamap;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Shapes {

	private ArrayList<Shape> shapes;
	private double maxLat;
	private double maxLon;
	private double minLat;
	private double minLon;
	private double latLength;
	private double lonLength;

	public Shapes() throws IOException {
		maxLat = -2147483648D;
		maxLon = -2147483648D;
		minLat = 2147483647D;
		minLon = 2147483647D;
		readShapeData();
		extractFeatures();
	}

	private void extractFeatures() {
		latLength = Math.abs(maxLat - minLat);
		lonLength = Math.abs(maxLon - minLon);
	}

	public void readShapeData() throws IOException {
		CSVReader reader = new CSVReader(new FileReader("shapes.txt"));
		reader.readNext();
		shapes = new ArrayList<Shape>();
		String line[];
		while ((line = reader.readNext()) != null) {
			Shape shape = new Shape(line[0], Double.valueOf(line[1]),
					Double.valueOf(line[2]));
			shapes.add(shape);
			maxLat = Math.max(maxLat, shape.getLat());
			maxLon = Math.max(maxLon, shape.getLon());
			minLat = Math.min(minLat, shape.getLat());
			minLon = Math.min(minLon, shape.getLon());
		}
		reader.close();
	}

	public List<Shape> getShapes(String shapeId) {
		ArrayList<Shape> ids = new ArrayList<Shape>();
		for (Shape s : shapes) {
			if (s.getShapeId().equals(shapeId)) {
				ids.add(s);
			}
		}
		return ids;
	}

	public double getMinLat() {
		return minLat;
	}

	public List<String> getShapeIds() {
		ArrayList<String> ids = new ArrayList<String>();
		for (Shape s : shapes) {
			if (!ids.contains(s.getShapeId())) {
				ids.add(s.getShapeId());
			}
		}
		return ids;
	}

	public double getMinLon() {
		return minLon;
	}

	public double getLatLength() {
		return latLength;
	}

	public double getLonLength() {
		return lonLength;
	}

}
