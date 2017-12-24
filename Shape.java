
public abstract class Shape {
	protected static int object_counter = 0;
	protected int ID = 0;
	protected Color color;
	protected abstract Point[] getAllPoints();
	protected abstract void moveAllPoints(double x_coordinate, double y_coordinate);
	protected abstract double getArea();
	protected abstract double getCircumference();
	protected Shape(Color color){
		this.color = color;
	}
	public Color getColor(){
		return this.color;
	}
	public void setColor(Color new_color){
		this.color = new_color;
	}
}