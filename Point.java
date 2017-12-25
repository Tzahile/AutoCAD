public class Point {
	private double x;
	private double y;
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public void setPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public Point getPoint() {
		return this;
	}
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	public double distanceTo(Point other_point) {
		return Math.sqrt(Math.pow(this.getX() - other_point.getX(), 2) + Math.pow(this.getY() - other_point.getY(), 2));
	}
}