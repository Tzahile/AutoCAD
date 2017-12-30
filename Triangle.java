public class Triangle extends Shape
{
	private static final double EPSILON = 0.005;
	private double first_edge_length;
	private double second_edge_length;
	private double third_edge_length;
	private Point[] vertex = new Point[3];
	public Triangle(Color color, double x1, double y1, double x2, double y2, double x3, double y3)
	{
		super(color);
		vertex[0] = new Point(x1, y1);
		vertex[1] = new Point(x2, y2);
		vertex[2] = new Point(x3, y3);
		CalculateEdgesLength();
	}
	
	private void CalculateEdgesLength()
	{
		first_edge_length = vertex[0].distanceTo(vertex[1]);
		second_edge_length = vertex[0].distanceTo(vertex[2]);
		third_edge_length = vertex[1].distanceTo(vertex[2]);
	}
	
	
	public Point[] getAllPoints()
	{
		return this.vertex;
	}
	
	public void Move(double x_offset, double y_offset)
	{
		Point[] all_points = getAllPoints();
		int i = 0;
		double x_value, y_value;
		for (i = 0; i < all_points.length; i++)
		{
			x_value = all_points[i].getX();
			y_value = all_points[i].getY();
			vertex[i].setPoint(x_value + x_offset, y_value + y_offset);
		}
	}
	
	public Triangle Clone()
	{
		Triangle clone = new Triangle(color, vertex[0].getX(), vertex[0].getY(), vertex[1].getX(), vertex[1].getY(),
				vertex[2].getX(), vertex[2].getY());
		return clone;
	}
	
	public double getArea()
	{
		Point[] all_points = getAllPoints();
		return Triangle.triangleArea(all_points[0], all_points[1], all_points[2]);
	}
	
	public double getCircumference()
	{
		return first_edge_length + second_edge_length + third_edge_length;
	}
	public boolean isPointInside(double x_coordinate, double y_coordinate)
	{
		Point checked_point = new Point(x_coordinate, y_coordinate);
		Point[] all_points = getAllPoints();
		return isPointInsideTriangle(checked_point, all_points[0], all_points[1], all_points[2]);
	}

	public static double triangleArea(Point first_point, Point second_point, Point third_point)
	{
		double first_second_distance = first_point.distanceTo(second_point);
		double first_third_distance = first_point.distanceTo(third_point);
		double second_third_distance = second_point.distanceTo(third_point);
		double s = (first_second_distance + first_third_distance + second_third_distance) / 2;
		return Math.sqrt(s * (s - first_second_distance) * (s - first_third_distance) * (s - second_third_distance));
	}

	public static boolean isPointInsideTriangle(Point checked_point, Point first_point, Point second_point,
			Point third_point)
	{
		double first_sub_area_with_checked_point = triangleArea(first_point, second_point, checked_point);
		double second_sub_area_with_checked_point = triangleArea(first_point, checked_point, third_point);
		double third_sub_area_with_checked_point = triangleArea(checked_point, second_point, third_point);
		double area_sum_with_checked_point = first_sub_area_with_checked_point +
			second_sub_area_with_checked_point +
			third_sub_area_with_checked_point;
		double triangle_area = triangleArea(first_point, second_point, third_point);
		if (area_sum_with_checked_point >= triangle_area - EPSILON &&
			area_sum_with_checked_point <= triangle_area + EPSILON)
		{
			return true;
		}
		return false;
	}
}