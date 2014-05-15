package ullman.pie;

public class Pie {

	private double pie = 0;

	public Pie() {

	}

	public double computePie() {
		for (int i = 1; i < 1000000000; i++) {

		}
		return pie = 4 * pie;

	}

	public static void main(String[] args) {
		Pie pie = new Pie();
		System.out.println(pie.computePie());
	}

}
