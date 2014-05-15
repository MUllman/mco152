package ullman.homework;

import org.junit.Assert;
import org.junit.Test;

public class Force2DTest {

	@Test
	public void testGetMagnitude() {
		Force2D force = new Force2D(2, 3);
		double magnitude = force.getMagnitude();
		double expected = Math.sqrt(2 * 2 + 3 * 3);
		Assert.assertEquals(expected, magnitude, .001);
	}

	public void testGetAngle() {
		Force2D force = new Force2D(2, 3);
		double angle = force.getAngle();
		double expected = Math.toDegrees(Math.atan2(3, 2));
		Assert.assertEquals(angle, expected, .001);
	}

	public void testAdd() {
		Force2D force = new Force2D(2, 3);
		Force2D newForce = force.add(new Force2D(4, 7));
		Force2D expected = new Force2D(6, 10);
		Assert.assertEquals(newForce, expected);
	}

}
