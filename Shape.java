public abstract class Shape {
	private static int object_counter = 0;
	protected int ID = 0;
	protected Color color;
	public abstract Point[] getAllPoints();
	public abstract void moveAllPoints(double x_coordinate, double y_coordinate);
	public abstract double getArea();
	public abstract double getCircumference();
	public abstract int isPointInside(double x_coordinate, double y_coordinate);
	protected Shape(Color color) {
		ID = object_counter;
		object_counter++;
		this.color = color;
	}
	public Color getColor() {
		return this.color;
	}
	public void setColor(Color new_color) {
		this.color = new_color;
	}
}