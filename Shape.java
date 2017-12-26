public abstract class Shape {
	private static int object_counter = 0;
	protected int ID;
	protected Color color;
	public abstract Point[] getAllPoints();
	public abstract double getArea();
	public abstract double getCircumference();
	public abstract boolean isPointInside(double x_coordinate, double y_coordinate);
	public abstract void Move(double x_offset, double y_offset);
	public abstract Shape Clone();
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