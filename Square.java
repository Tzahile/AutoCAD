public class Square extends Rectangle{
	public Square(Color color, double x1, double y1, double length) {
		super(color, x1 - length/2, y1 + length/2, x1 + length/2, y1 - length/2);
		CalculateRemainingVertex();
	}

	// --> Ask nimrod if it's better to create another isInside function
	//     if can be better implemented in this case (rather than parallelogram)
}
