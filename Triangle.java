
public class Triangle extends Shape{
	private double first_edge_length;
	private double second_edge_length;
	private double third_edge_length;
	private Point[] vertex = new Point[3];
	public Triangle(Color color, double x1, double y1, double x2, double y2, double x3, double y3) {
		super(color);
		vertex[0] = new Point(x1, y1);
		vertex[1] = new Point(x2, y2);
		vertex[2] = new Point(x3, y3);
		CalculateEdgesLength();
		ID = object_counter;
		object_counter++;
	}
	private void CalculateEdgesLength() {
		first_edge_length = vertex[0].getDistanceBetweenTwoPoints(vertex[1]);
		second_edge_length = vertex[0].getDistanceBetweenTwoPoints(vertex[2]);
		third_edge_length = vertex[1].getDistanceBetweenTwoPoints(vertex[2]);
	}
	public double getCircumference() {
		return first_edge_length + second_edge_length + third_edge_length;
	}
	public double getArea() {
		// Heron's formula
		double s = (first_edge_length + second_edge_length + third_edge_length)/2;
		return Math.sqrt(s * (s - first_edge_length) * (s - second_edge_length) * (s - third_edge_length));
	}
}
