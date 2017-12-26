public class Circle extends Ellipse {
	public Circle(Color color, double x, double y, double radius) {
		super(color, x, y, x, y, radius * 2);
	}
	public double getCircumference() {
		return 2 * Math.PI * (distance / 2);
	}
	public Circle Clone() {
		Circle clone = new Circle(color, focus[0].getX(), focus[0].getY(), distance/2);
		return clone;
	}
}