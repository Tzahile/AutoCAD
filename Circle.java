public class Circle extends Ellipse{
	//Point center;
	public Circle(Color color, double x, double y, double radius) {
		super(color, x, y, x, y, radius*2);
	}
	public double getCircumference() {
		return 2*Math.PI*(distance/2);
	}
}