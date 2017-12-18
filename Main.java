import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//while(true) {
		//	Scanner scan = new Scanner(System.in); //standard input stream
		//	String input_line = scan.next();
			//if (input_line.equals("new")) {
			//	System.out.println("new!!!!!\n");
			//}
		//	break;
		//}
		
		Ellipse myEli = new Ellipse(Color.BLUE, -3, 0, 3, 0, 10);
		System.out.println("Area of Eli is " + myEli.getArea() +"\n");
		Ellipse myTranEli = new Ellipse(Color.YELLOW, 0, -3, 0, 3, 10);
		System.out.println("Area of TransEli is " + myTranEli.getArea() +"\n");
		System.out.println("Circum of Eli is " + myEli.getCircumference() +"\n");
		System.out.println("Circum of TranEli is " + myTranEli.getCircumference() +"\n");
		System.out.println("ID of Eli is " + myEli.getID() +"\n");
		System.out.println("ID of TranEli is " + myTranEli.getID() +"\n");
		Circle myCirc = new Circle(Color.GREEN, 0, 0, 3);
		System.out.println("Area of myCirc is " + myCirc.getArea() +"\n");
		System.out.println("Circum of mtCirc is " + myCirc.getCircumference() +"\n");
		
//		System.out.println("Color of Eli is " + myEli.getColor() +"\n");
//		System.out.println("Color of TransEli is " + myTranEli.getColor() +"\n");
//		Triangle tri = new Triangle(Color.GREEN, 2, 4, 6, 1, 1, 1);
//		System.out.println("Area of tri is " + tri.getArea() +"\n");
//		Triangle tri2 = new Triangle(Color.GREEN, 3, 4, 8, 6, 4, 9);
//		System.out.println("Area of tri is " + tri2.getArea() +"\n");
//		Rectangle rect = new Rectangle(Color.BLUE, 1, 1, 6, 6);
//		Rectangle rect2 = new Rectangle(Color.BLUE, 1, 6, 6, 1);
//		System.out.println("Area of rect is " + rect.getArea() +"\n");
//		System.out.println("Hekef of rect is " + rect.getCircumference() +"\n");
//		System.out.println("Area of rect2 is " + rect2.getArea() +"\n");
//		System.out.println("Hekef of rect2 is " + rect2.getCircumference() +"\n");
//		Square sq = new Square(Color.RED, 1,1,4);
//		/*Point myPoint = new Point(1,3);
//		System.out.println("first log: "+myPoint.getX() +"+"+myPoint.getY()+"\n");
//		Point mySecPoint = myPoint.getPoint();
//		System.out.println("sec log: "+mySecPoint.getX() +"+"+myPoint.getY()+"\n");
//		line = ParseLine("Hi my name is Dorky Porky! I love to eat pizza");
//		System.out.println("name log: "+line[0]+" "+line[4]+"\n");*/
//		Parallelogram par = new Parallelogram(Color.RED, 2, 4, 1, 1, 6, 1);
//		System.out.println("Area of par is " + par.getArea() +"\n");
//		Parallelogram par2 = new Parallelogram(Color.RED, 2, 4, 7, 4, 6, 1);
//		System.out.println("Area of par is " + par2.getArea() +"\n");
//		Parallelogram par3 = new Parallelogram(Color.RED, 7, 4, 2, 4, 1, 1);
//		System.out.println("Area of par is " + par3.getArea() +"\n");
//		System.out.println("Hekef of par is " + par.getCircumference() +"\n");
//		Parallelogram par4 = new Parallelogram(Color.RED, 7, 4, 6, 1, 1, 1);
//		System.out.println("Area of par is " + par4.getArea() +"\n");
//		Parallelogram par5 = new Parallelogram(Color.RED, 1, 4, 2, 1, 7, 1);
//		System.out.println("Area of par is " + par5.getArea() +"\n");
//		Parallelogram par6 = new Parallelogram(Color.RED, 6, 4, 1, 4, 2, 1);
//		System.out.println("Area of par is " + par6.getArea() +"\n");
//		System.out.println("Hekef of par6 is " + par6.getCircumference() +"\n");
//		Parallelogram par7 = new Parallelogram(Color.RED, 2, 1, 1, 4, 6, 4);
//		System.out.println("Area of par is " + par7.getArea() +"\n");
//		System.out.println("Hekef of par7 is " + par7.getCircumference() +"\n");
	}
	public static String[] ParseLine(String line) {
		String[] parsedLine = line.split(" ");
		return parsedLine;
	}

}
