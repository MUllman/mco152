package ullman.homework;

public class Triangle {

	private int height;

	public Triangle(int hight) {
		this.height = hight;
	}

	public String toString() {
		double space = height;
		int middleSpace = 1;
		StringBuilder triangle = new StringBuilder();

		for (int i = 0; i < space - 1; i++) {
			triangle.append(" ");
		}
		triangle.append('*' + "\n");
		space -= 1;

		for (int i = 1; i < height - 1; i++) {
			for (int j = 1; j < space; j++) {
				triangle.append(" ");
			}
			space -= 1;
			triangle.append('*');
			for (int k = 0; k < middleSpace; k++) {
				triangle.append(" ");
			}
			middleSpace += 2;
			triangle.append('*' + "\n");
		}

		for (int i = 0; i < middleSpace + 2; i++) {
			triangle.append('*');
		}
		return triangle.toString();

	}

}
