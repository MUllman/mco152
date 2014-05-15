package ullman.stocks;

import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class AmexData {

	private final ArrayList<DailyPrice> stocks;
	private final String[] fileNames = {
			"./resources/amex/AMEX_daily_prices_A.csv",
			"./resources/amex/AMEX_daily_prices_B.csv",
			"./resources/amex/AMEX_daily_prices_C.csv",
			"./resources/amex/AMEX_daily_prices_D.csv" };

	public AmexData() throws IOException, ParseException {
		stocks = new ArrayList<DailyPrice>();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < fileNames.length; i++) {
			CSVReader reader = new CSVReader(new FileReader(fileNames[i]));
			reader.readNext();
			String line[];
			while ((line = reader.readNext()) != null) {
				String dateString = line[2];
				Date date = df.parse(dateString);
				DailyPrice dp = new DailyPrice(line[0], line[1], date,
						Double.parseDouble(line[3]),
						Double.parseDouble(line[4]),
						Double.parseDouble(line[5]),
						Double.parseDouble(line[6]), Integer.parseInt(line[7]),
						Double.parseDouble(line[8]));
				stocks.add(dp);
			}
			reader.close();
		}
	}

	public boolean contains(String symbol) {
		for (DailyPrice dp : stocks) {
			if (dp.getSymbol().equals(symbol.toUpperCase())) {
				return true;
			}
		}
		return false;
	}

	public List<DailyPrice> getPrices(String symbol) {
		List<DailyPrice> list = new ArrayList<DailyPrice>();
		for (DailyPrice dp : stocks) {
			if (dp.getSymbol().equals(symbol.toUpperCase())) {
				list.add(dp);
			}
		}
		Collections.sort(list);
		return list;
	}

	public List<DailyPrice> getPrices(String symbol, Date startDate,
			Date endDate) {
		List<DailyPrice> list = new ArrayList<DailyPrice>();
		for (DailyPrice dp : stocks) {
			if (dp.getSymbol().equals(symbol.toUpperCase())
					&& dp.getDate().compareTo(startDate) >= 0
					&& dp.getDate().compareTo(endDate) <= 0) {
				list.add(dp);
			}
		}
		Collections.sort(list);
		return list;
	}

}
