package ullman.ufo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class ListSightings {

	private static final int Auto = 0;

	public static void main(String[] args) throws FileNotFoundException {
		Gson gson = new Gson();

		JsonReader reader = new JsonReader(new FileReader("ufo_awesome.json"));
		final SightingList list = gson.fromJson(reader, SightingList.class);
		Map<String, ArrayList<Sighting>> map = new HashMap<String, ArrayList<Sighting>>();

		for (Sighting s : list) {
			String location = s.getLocation();
			List<Sighting> sightings = map.get(location);
			if (sightings == null) {
				sightings = new ArrayList<Sighting>();
			}
			sightings.add(s);
			map.put(location, (ArrayList<Sighting>) sightings);
		}
	}
}
