public class Circle extends Ellipse{
	Point center;
	public Circle(Color color, double x, double y, double radius) {
		super(color, x, y, x, y, radius*2);
	}
	//area is the same
	public double getCircumference() {
		return 2*Math.PI*(distance/2);
	}
}
