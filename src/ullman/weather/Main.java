package ullman.weather;

public class Main {

	@Override
	public String toString() {
		return "Main [temp=" + temp + ", pressure=" + pressure + ", humidity="
				+ humidity + ", temp_min=" + temp_min + ", temp_max="
				+ temp_max + "]";
	}

	private final double temp;
	private final int pressure;
	private final int humidity;
	private final double temp_min;
	private final double temp_max;

	public Main(double temp, int pressure, int humidity, double temp_min,
			double temp_max) {
		super();
		this.temp = temp;
		this.pressure = pressure;
		this.humidity = humidity;
		this.temp_min = temp_min;
		this.temp_max = temp_max;
	}

	public double getTemp() {
		return temp;
	}

	public int getPressure() {
		return pressure;
	}

	public int getHumidity() {
		return humidity;
	}

	public double getTemp_min() {
		return temp_min;
	}

	public double getTemp_max() {
		return temp_max;
	}

}