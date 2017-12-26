public class Square extends Rectangle
{
	private Point center_point;
	public Square(Color color, double x1, double y1, double length) 
	{
		super(color, x1 - length / 2, y1 + length / 2, x1 + length / 2, y1 - length / 2);
		center_point = new Point(x1, y1);
		CalculateRemainingVertex();
	}
	
	public Square Clone() {
		Square clone = new Square(color, center_point.getX(), center_point.getY(), first_edge_length);
		return clone;
	}
}