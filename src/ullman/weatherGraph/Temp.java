package ullman.weatherGraph;

public class Temp {
	private final double day;

	public Temp(double day) {
		super();
		this.day = day;
	}

	public double getDay() {
		return day;
	}

	@Override
	public String toString() {
		return "Temp [day=" + day + "]";
	}

}
