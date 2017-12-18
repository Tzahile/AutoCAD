public class Rectangle extends Parallelogram{	
	public Rectangle(Color color, double x1, double y1, double x2, double y2) {
		super(color, x1, y1, x1, y2, x2, y2);
		CalculateRemainingVertex();
		CalculateEdgesLength();
	}
	//private void CalculateRemainingVertex() {
	//	vertex[3].setPoint(vertex[2].getX(), vertex[0].getY());
	//}
	//private void CalculateEdgesLength() {
	//	first_edge_length = vertex[0].getDistanceBetweenTwoPoints(vertex[1]);
	//	second_edge_length = vertex[1].getDistanceBetweenTwoPoints(vertex[2]);
	//}
	//public double getArea() {
	//	return first_edge_length * second_edge_length;
	//}
	//public double getCircumference() {
	//	return 2 * first_edge_length + 2 * second_edge_length;
	//}
}
