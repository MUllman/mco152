package ullman.weatherGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;

public class WeatherThread extends Thread {

	private final String place;
	private final DrawGraph graph;

	public WeatherThread(String place, DrawGraph graph) {
		this.place = place;
		this.graph = graph;
	}

	@Override
	public void run() {
		URL url;
		try {
			url = new URL(
					"http://api.openweathermap.org/data/2.5/forecast/daily?q="
							+ place + "&mode=json&units=imperial&cnt=7");

			URLConnection connection = url.openConnection();
			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			Gson gson = new Gson();
			Weather weather = gson.fromJson(reader, Weather.class);
			graph.giveList(weather.getList());
			graph.repaint();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		super.run();

	}

}
