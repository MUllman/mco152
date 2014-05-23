package ullman.earthquakes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.DefaultListModel;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class EarthquakeThread extends Thread {

	private static final String FEED_URL = "http://earthquake-report.com/feeds/recent-eq?json";
	private final DefaultListModel<String> listModel;
	private Earthquake[] quake;

	public EarthquakeThread(DefaultListModel<String> listModel) {
		this.listModel = listModel;
	}

	public Earthquake[] getQuake() {
		return quake;
	}

	@Override
	public void run() {
		URL url;
		try {

			url = new URL(FEED_URL);
			URLConnection connection = url.openConnection();
			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			Gson gson = new Gson();
			JsonReader jsonReader = new JsonReader(reader);
			quake = gson.fromJson(jsonReader, Earthquake[].class);
			for (int i = 0; i < quake.length; i++) {
				listModel.addElement(quake[i].toString());

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		super.run();
	}

}
