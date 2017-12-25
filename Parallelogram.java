
public class Parallelogram extends Shape {
	protected double first_edge_length;
	protected double second_edge_length;
	protected Point[] vertex = new Point[4];
	public Parallelogram(Color color, double x1, double y1, double x2, double y2, double x3, double y3) {
		super(color);
		this.vertex[0] = new Point(x1, y1);
		this.vertex[1] = new Point(x2, y2);
		this.vertex[2] = new Point(x3, y3);
		CalculateRemainingVertex();
		CalculateEdgesLength();
		ID = object_counter;
		object_counter++;
	}
	protected void CalculateRemainingVertex() {
		double x4, y4;
		double x1x2Distance = vertex[1].getX() - vertex[0].getX();
		double y1y2Distance = vertex[1].getY() - vertex[0].getY();
		x4 = vertex[2].getX() - x1x2Distance;
		y4 = vertex[2].getY() - y1y2Distance;		
		vertex[3] = new Point(x4, y4);
	}
	protected void CalculateEdgesLength() {
		first_edge_length = vertex[0].getDistanceBetweenTwoPoints(vertex[1]);
		second_edge_length = vertex[1].getDistanceBetweenTwoPoints(vertex[2]);
	}
	public Point[] getAllPoints(){
		return this.vertex;
	}
	public void moveAllPoints(double x_coordinate, double y_coordinate){
		Point[] all_points = getAllPoints();
		int i=0;
		double x_value, y_value;
		for(i=0; i<all_points.length; i++){
			x_value = all_points[i].getX();
			y_value = all_points[i].getY();
			all_points[i].setPoint(x_value + x_coordinate, y_value + y_coordinate);
		}
	}
	public double getArea() {
		double[][] matrix_to_calculate_det = new double[2][2];
		double determinant = 0;
		matrix_to_calculate_det[0][0] = vertex[1].getX() - vertex[0].getX();
		matrix_to_calculate_det[1][0] = vertex[1].getY() - vertex[0].getY();
		matrix_to_calculate_det[0][1] = vertex[2].getX() - vertex[0].getX();
		matrix_to_calculate_det[1][1] = vertex[2].getY() - vertex[0].getY();
		determinant =  matrix_to_calculate_det[0][0] * matrix_to_calculate_det[1][1];
		determinant = determinant - matrix_to_calculate_det[0][1] * matrix_to_calculate_det[1][0];
		return Math.abs(determinant);
	}
	public double getCircumference() {
		first_edge_length = vertex[1].getDistanceBetweenTwoPoints(vertex[0]);
		second_edge_length = vertex[1].getDistanceBetweenTwoPoints(vertex[2]);
		return 2 * first_edge_length + 2 * second_edge_length;
	}
	public int getID() {
		return this.ID;
	}
}
