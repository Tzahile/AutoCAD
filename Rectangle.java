public class Rectangle extends Parallelogram
{
	public Rectangle(Color color, double x1, double y1, double x2, double y2)
	{
		super(color, x1, y1, x1, y2, x2, y2);
		CalculateRemainingVertex();
		CalculateEdgesLength();
	}
	
	public Rectangle Clone()
	{
		Rectangle clone = new Rectangle(color, vertex[0].getX(), vertex[0].getY(), vertex[2].getX(), vertex[2].getY());
		return clone;
	}
}