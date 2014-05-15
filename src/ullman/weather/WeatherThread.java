package ullman.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JTextArea;

import com.google.gson.Gson;

public class WeatherThread extends Thread {

	private final JTextArea area;
	private final String place;

	public WeatherThread(String place, JTextArea area) {
		this.area = area;
		this.place = place;
	}

	public void toArea(Conditions c) {
		area.setText(c.toString());
	}

	@Override
	public void run() {
		URL url;
		try {
			url = new URL("http://api.openweathermap.org/data/2.5/weather?q="
					+ place);

			URLConnection connection = url.openConnection();
			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			Gson gson = new Gson();
			Conditions c = gson.fromJson(reader, Conditions.class);
			toArea(c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		super.run();

	}

}
