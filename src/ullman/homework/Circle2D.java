package ullman.homework;

public class Circle2D {

	private final double x;
	private final double y;
	private final double radius;

	public Circle2D() {
		x = 0;
		y = 0;
		radius = 1;
	}

	public Circle2D(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getRadius() {
		return radius;
	}

	public double getArea() {
		return Math.PI * (radius * radius);
	}

	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

	public boolean contains(double x, double y) {
		return x <= (this.x + radius) && x >= (this.x - radius)
				&& y <= (this.y + radius) && y >= (this.y - radius);
	}

	public boolean contains(Circle2D circle) {
		return Math.abs(circle.getX() - x) + circle.getRadius() <= radius
				&& Math.abs(circle.getY() - y) + circle.getRadius() <= radius;
	}

	public boolean overlaps(Circle2D circle) {
		return (Math.abs(circle.getX() - x) + Math.abs(circle.getY() - y)) < (radius + circle
				.getRadius());
	}
}
