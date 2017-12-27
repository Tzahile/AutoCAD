public class Square extends Rectangle
{
	public Square(Color color, double x1, double y1, double length) 
	{
		super(color, x1 - length / 2, y1 + length / 2, x1 + length / 2, y1 - length / 2);
		CalculateRemainingVertex();
	}
	
	public Square Clone() {
		Square clone = new Square(color, vertex[0].getX() + first_edge_length/2,
				vertex[0].getY() - first_edge_length / 2, first_edge_length);
		return clone;
	}
}