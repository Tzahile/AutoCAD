public class Square extends Rectangle{
	public Square(Color color, double x1, double y1, double length) {
		super(color, x1 - length/2, y1 + length/2, x1 + length/2, y1 - length/2);
		CalculateRemainingVertex();
	}
}
