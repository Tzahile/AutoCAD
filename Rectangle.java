public class Rectangle extends Parallelogram {
	public Rectangle(Color color, double x1, double y1, double x2, double y2) {
		super(color, x1, y1, x1, y2, x2, y2);
		CalculateRemainingVertex();
		CalculateEdgesLength();
	}
}