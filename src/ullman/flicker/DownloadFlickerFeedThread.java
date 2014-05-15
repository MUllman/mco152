package ullman.flicker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

//use gson connect to flicker download the json feed as a flicker feed object then call a method in frame
/**
 * Retrieves the Flicker feed and calls frame.loadImages()
 */
public class DownloadFlickerFeedThread extends Thread {

	private static final String FEED_URL = "https://api.flickr.com/services/feeds/photos_public.gne?id=20952345@N03&format=json";
	private final FlickerFeedFrame frame;

	public DownloadFlickerFeedThread(final FlickerFeedFrame frame) {
		this.frame = frame;
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
			jsonReader.setLenient(true);
			jsonReader.nextString();
			FlickerFeed ff = gson.fromJson(jsonReader, FlickerFeed.class);
			frame.loadImages(ff);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		super.run();
	}

}
