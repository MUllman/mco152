package ullman.homework;

import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

	@Test
	public void testTriangle() {
		Triangle triangle = new Triangle(5);
		String drawing = triangle.toString();
		String expected = "    *\n" + "   * *\n" + "  *   *\n" + " *     *\n"
				+ "*********";

		Assert.assertEquals(drawing, expected);

	}
}
