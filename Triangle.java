
public class Triangle extends Shape{
	private static final double EPSILON = 0.05;
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
		// Heron's formula
		double s = (first_edge_length + second_edge_length + third_edge_length)/2;
		return Math.sqrt(s * (s - first_edge_length) * (s - second_edge_length) * (s - third_edge_length));
	}
	public double getCircumference() {
		return first_edge_length + second_edge_length + third_edge_length;
	}
	public int isInside(double x_coordinate, double y_coordinate){
		Point checked_point = new Point(x_coordinate, y_coordinate);
		Point[] all_points = getAllPoints();
		double first_sub_area_with_checked_point = triangleArea(all_points[0], all_points[1], checked_point);
		double second_sub_area_with_checked_point = triangleArea(all_points[0], checked_point, all_points[2]);
		double third_sub_area_with_checked_point = triangleArea(checked_point, all_points[1], all_points[2]);
		double area_sum_with_checked_point = first_sub_area_with_checked_point + second_sub_area_with_checked_point + third_sub_area_with_checked_point;
		if(area_sum_with_checked_point >= getArea()-EPSILON && area_sum_with_checked_point <= getArea() + EPSILON) return 1;
		return 0;
	}

	public static double triangleArea(Point first_point, Point second_point, Point third_point) {
		double first_second_distance = first_point.getDistanceBetweenTwoPoints(second_point);
		double first_third_distance = first_point.getDistanceBetweenTwoPoints(third_point);
		double second_third_distance = second_point.getDistanceBetweenTwoPoints(third_point);
		
		// Heron's formula
		double s = (first_second_distance + first_third_distance + second_third_distance)/2;
		return Math.sqrt(s * (s - first_second_distance) * (s - first_third_distance) * (s - second_third_distance));
	}
}
