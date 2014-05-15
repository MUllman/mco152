package ullman.homework;

import org.junit.Assert;
import org.junit.Test;

public class Circle2DTest {

	@Test
	public void testGetArea() {
		Circle2D circle = new Circle2D();
		double area = circle.getArea();
		double expected = Math.PI;
		Assert.assertEquals(area, expected, .01);

	}

	@Test
	public void testGetPerimeter() {
		Circle2D circle = new Circle2D(1, 3, 5);
		double perimeter = circle.getPerimeter();
		double expected = 2 * Math.PI * 5;
		Assert.assertEquals(expected, perimeter, .01);
	}

	@Test
	public void testContains1() {
		Circle2D circle = new Circle2D(5, 5, 5);
		boolean contains = circle.contains(6, 8);
		Assert.assertTrue(contains);
	}

	@Test
	public void testContains2() {
		Circle2D circle = new Circle2D(5, 5, 5);
		Circle2D testCircle = new Circle2D(3, 3, 3);
		boolean contains = circle.contains(testCircle);
		Assert.assertTrue(contains);
	}

	@Test
	public void testOverlaps() {
		Circle2D circle = new Circle2D(5, 5, 5);
		Circle2D testCircle = new Circle2D(8, 8, 3);
		boolean overlaps = circle.overlaps(testCircle);
		Assert.assertTrue(overlaps);
	}

}
