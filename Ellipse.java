public class Ellipse extends Shape {
	final int NUM_OF_ITERATIONS = 100;
	protected Point[] focus = new Point[2];
	protected double distance = 0;

	public Ellipse(Color color, double x1, double y1, double x2, double y2, double distance) {
		super(color);
		this.focus[0] = new Point(x1, y1);
		this.focus[1] = new Point(x2, y2);
		this.distance = distance;
	}
	public int getID() {
		return this.ID;
	}
	public Point[] getAllPoints() {
		return this.focus;
	}
	public double getDistance() {
		return this.distance;
	}
	public void Move(double x_offset, double y_offset) {
		Point[] all_points = getAllPoints();
		int i = 0;
		double x_value, y_value;
		for (i = 0; i < all_points.length; i++) {
			x_value = all_points[i].getX();
			y_value = all_points[i].getY();
			focus[i].setPoint(x_value + x_offset, y_value + y_offset);
		}
	}
	public Ellipse Clone() {
		Ellipse clone = new Ellipse(color, focus[0].getX(), focus[0].getY(), focus[1].getX(), focus[1].getY(),
				distance);
		return clone;
	}
	public double getArea() {
		double focus_length_from_center = focus[0].distanceTo(focus[1]) / 2;
		double axis_remainder = this.distance / 2;
		double semi_major_axis_length = this.distance / 2;
		double semi_minor_axis_length = Math.sqrt(axis_remainder * axis_remainder -
			focus_length_from_center * focus_length_from_center);
		return Math.PI * semi_major_axis_length * semi_minor_axis_length;
	}
	public double getCircumference() {
		double focus_length_from_center = focus[0].distanceTo(focus[1]) / 2;
		double axis_remainder = this.distance / 2;
		double semi_major_axis_length = this.distance / 2;
		double semi_minor_axis_length = Math.sqrt(axis_remainder * axis_remainder -
			focus_length_from_center * focus_length_from_center);

		double summation = 0;
		double first_fraction = 0, second_fraction = 0;
		double h = Math.pow((semi_major_axis_length - semi_minor_axis_length) /
			(semi_major_axis_length + semi_minor_axis_length), 2);
		for (int i = 1; i < NUM_OF_ITERATIONS; i++) {
			first_fraction = (factorial(factorial(2 * i - 1))) / (Math.pow(2, i) * factorial(i));
			second_fraction = Math.pow(h, i) / Math.pow(2 * i - 1, 2);
			summation += first_fraction * second_fraction;
		}
		return Math.PI * (semi_major_axis_length + semi_minor_axis_length) * (1 + summation);
	}

	private int factorial(int number) {
		if (number == 0) return 1;
		return factorial(number - 1);
	}
	public boolean isPointInside(double x_coordinate, double y_coordinate) {
		Point checked_point = new Point(x_coordinate, y_coordinate);
		Point[] focus_points = getAllPoints();
		double distance_from_focuses = checked_point.distanceTo(focus_points[0]) + 
				checked_point.distanceTo(focus_points[1]);
		if (distance_from_focuses <= getDistance()) {
			return true;
		}
		return false;
	}
}