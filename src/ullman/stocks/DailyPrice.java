package ullman.stocks;

import java.util.Date;

public class DailyPrice implements Comparable {
	private final String exchange;
	private final String symbol;
	private final Date date;
	private final double openPrice;
	private final double highPrice;
	private final double lowPrice;
	private final double closePrice;
	private final int volume;
	private final double adjustedClosePrice;

	public DailyPrice(String exchange, String symbol, Date date,
			double openPrice, double highPrice, double lowPrice,
			double closePrice, int volume, double adjustedClosePrice) {
		this.exchange = exchange;
		this.symbol = symbol;
		this.date = date;
		this.openPrice = openPrice;
		this.highPrice = highPrice;
		this.lowPrice = lowPrice;
		this.closePrice = closePrice;
		this.volume = volume;
		this.adjustedClosePrice = adjustedClosePrice;
	}

	@Override
	public int compareTo(Object o) {
		DailyPrice dp = (DailyPrice) o;
		return this.getDate().compareTo(dp.getDate());
	}

	public String getExchange() {
		return exchange;
	}

	public String getSymbol() {
		return symbol;
	}

	public Date getDate() {
		return date;
	}

	public double getOpenPrice() {
		return openPrice;
	}

	public double getHighPrice() {
		return highPrice;
	}

	public double getLowPrice() {
		return lowPrice;
	}

	public double getClosePrice() {
		return closePrice;
	}

	public int getVolume() {
		return volume;
	}

	public double getAdjustedClosePrice() {
		return adjustedClosePrice;
	}

}
