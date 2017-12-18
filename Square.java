public class Square extends Rectangle{
	public Square(Color color, double x1, double y1, double length) {
		super(color, x1 - length/2, y1 + length/2, x1 + length/2, y1 - length/2);
		CalculateRemainingVertex();
	}
	//private void CalculateRemainingVertex() {
	//	vertex[3].setPoint(vertex[0].getX() + length, vertex[0].getY());
	//}
}
