package ullman.flicker;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;

public class DownloadFlickerFeedThreadTest {

	@Test
	public void testCallsLoadImages() {

		FlickerFeedFrame frame = Mockito.mock(FlickerFeedFrame.class);
		DownloadFlickerFeedThread thread = new DownloadFlickerFeedThread(frame);
		VerificationMode never = Mockito.never();
		Mockito.verify(frame, never).loadImages(Mockito.any(FlickerFeed.class));

		thread.run();

		VerificationMode once = Mockito.times(1);
		Mockito.verify(frame, once).loadImages(Mockito.any(FlickerFeed.class));

	}

}
