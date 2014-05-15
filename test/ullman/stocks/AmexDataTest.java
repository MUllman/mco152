package ullman.stocks;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AmexDataTest {

	@Test
	public void testReadIn() {
		try {
			AmexData ad = new AmexData();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testContains() {
		try {
			AmexData ad = new AmexData();
			Assert.assertTrue(ad.contains("cxm"));
			Assert.assertFalse(ad.contains("nko"));
			Assert.assertFalse(ad.contains(" "));
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetPricesWithSymbol() {
		try {
			AmexData ad = new AmexData();
			List<DailyPrice> stocks = ad.getPrices("cxm");
			Assert.assertNotNull(stocks);
			Assert.assertFalse(stocks.size() == 0);
			for (int i = 1; i < stocks.size(); i++) {
				Assert.assertTrue(stocks.get(i).getDate()
						.after(stocks.get(i - 1).getDate()));
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetPricesWithSymbolAndDates() {
		try {
			AmexData ad = new AmexData();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String early = "1992-08-28";
			String late = "2010-01-05";
			Date startDate = df.parse(early);
			Date endDate = df.parse(late);
			List<DailyPrice> stocks = ad.getPrices("aip", startDate, endDate);
			Assert.assertNotNull(stocks);
			Assert.assertFalse(stocks.size() == 0);
			for (DailyPrice dp : stocks) {
				Assert.assertTrue(dp.getDate().compareTo(startDate) >= 0
						&& dp.getDate().compareTo(endDate) <= 0);
			}
			for (int i = 1; i < stocks.size(); i++) {
				Assert.assertTrue(stocks.get(i).getDate()
						.after(stocks.get(i - 1).getDate()));
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}

}
