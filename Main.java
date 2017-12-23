import java.util.HashMap;
import java.util.Scanner;

public class Main {
	private static final int SUCCESS = 0;
	public static void main(String[] args) {
		HashMap<Integer, Shape> shapes_hash_table = new HashMap<Integer, Shape>();
		Scanner scan = new Scanner(System.in);
		String input_line;
		String[] parsed_line;
		while(true) {
			input_line = GetLineFromUser(scan);
			parsed_line = ParseLine(input_line);
			switch(parsed_line[0]) {
			case "new":
				NewCommand(parsed_line, shapes_hash_table);
				break;
			case "delete":
				DeleteCommand(Integer.parseInt(parsed_line[1]), shapes_hash_table);
				break;
			case "move":
				break;
			case "copy":
				break;
			case "area":
				parsed_line[1] = parsed_line[1].toUpperCase();	
				AreaCommand(Color.valueOf(parsed_line[1]), shapes_hash_table);
				break;	
			case "color":
				parsed_line[1] = parsed_line[1].toUpperCase();				
				ColorCommand(Integer.parseInt(parsed_line[2]), Color.valueOf(parsed_line[1]), shapes_hash_table);
				break;
			case "circumference":
				parsed_line[1] = parsed_line[1].toUpperCase();
				CircumferenceCommand(Color.valueOf(parsed_line[1]), shapes_hash_table);
				break;
			case "is_inside":
				break;				
			case "exit":
				scan.close();
				System.exit(SUCCESS);
			}
		}
		/*System.out.println("Area of ID = 0 is " + shapes_hash_table.get(0).getArea());
			
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
		
		
		
		
		Triangle tri = new Triangle(Color.GREEN, 2, 4, 6, 1, 1, 1);
		System.out.println("Area of tri is " + tri.getArea() +"\n");
		Triangle tri2 = new Triangle(Color.GREEN, 3, 4, 8, 6, 4, 9);
		System.out.println("Area of tri is " + tri2.getArea() +"\n");
		Rectangle rect = new Rectangle(Color.BLUE, 1, 1, 6, 6);
		Rectangle rect2 = new Rectangle(Color.BLUE, 1, 6, 6, 1);
		System.out.println("Area of rect is " + rect.getArea() +"\n");
		System.out.println("Hekef of rect is " + rect.getCircumference() +"\n");
		System.out.println("Area of rect2 is " + rect2.getArea() +"\n");
		System.out.println("Hekef of rect2 is " + rect2.getCircumference() +"\n");
		Square sq = new Square(Color.red, 1,1,4);
		Point myPoint = new Point(1,3);
		System.out.println("first log: "+myPoint.getX() +"+"+myPoint.getY()+"\n");
		Point mySecPoint = myPoint.getPoint();
		System.out.println("sec log: "+mySecPoint.getX() +"+"+myPoint.getY()+"\n");
		line = ParseLine("Hi my name is Dorky Porky! I love to eat pizza");
		System.out.println("name log: "+line[0]+" "+line[4]+"\n");
		Parallelogram par = new Parallelogram(Color.RED, 2, 4, 1, 1, 6, 1);
		System.out.println("Area of par is " + par.getArea() +"\n");
		Parallelogram par2 = new Parallelogram(Color.RED, 2, 4, 7, 4, 6, 1);
		System.out.println("Area of par is " + par2.getArea() +"\n");
		Parallelogram par3 = new Parallelogram(Color.RED, 7, 4, 2, 4, 1, 1);
		System.out.println("Area of par is " + par3.getArea() +"\n");
		System.out.println("Hekef of par is " + par.getCircumference() +"\n");
		Parallelogram par4 = new Parallelogram(Color.RED, 7, 4, 6, 1, 1, 1);
		System.out.println("Area of par is " + par4.getArea() +"\n");
		Parallelogram par5 = new Parallelogram(Color.RED, 1, 4, 2, 1, 7, 1);
		System.out.println("Area of par is " + par5.getArea() +"\n");
		Parallelogram par6 = new Parallelogram(Color.RED, 6, 4, 1, 4, 2, 1);
		System.out.println("Area of par is " + par6.getArea() +"\n");
		System.out.println("Hekef of par6 is " + par6.getCircumference() +"\n");
		Parallelogram par7 = new Parallelogram(Color.RED, 2, 1, 1, 4, 6, 4);
		System.out.println("Area of par is " + par7.getArea() +"\n");
		System.out.println("Hekef of par7 is " + par7.getCircumference() +"\n");*/
	}
	private static String GetLineFromUser(Scanner scan) {
		String input_string = "";
		input_string = scan.nextLine();
		input_string = input_string.toLowerCase();
		return input_string;
	}
	private static String[] ParseLine(String line) {
		String[] parsedLine = line.split(" ");
		return parsedLine;
	}
	private static void NewCommand(String[] parsed_line, HashMap<Integer, Shape> shapes_hash_table) {
		Shape new_shape;
		parsed_line[2] = parsed_line[2].toUpperCase();
		Color color = Color.valueOf(parsed_line[2]);
		switch (parsed_line[1]) {
		case "parallelogram":
			new_shape = new Parallelogram(color, StrToDouble(parsed_line[3]), StrToDouble(parsed_line[4]), 
			StrToDouble(parsed_line[5]), StrToDouble(parsed_line[6]), StrToDouble(parsed_line[7]), StrToDouble(parsed_line[8]));
			shapes_hash_table.put(new_shape.ID, new_shape);
			break;
		case "rectangle":
			new_shape = new Rectangle(color, StrToDouble(parsed_line[3]), StrToDouble(parsed_line[4]), 
			StrToDouble(parsed_line[5]), StrToDouble(parsed_line[6]));
			shapes_hash_table.put(new_shape.ID, new_shape);
			break;
		case "square":
			new_shape = new Square(color, StrToDouble(parsed_line[3]), StrToDouble(parsed_line[4]),
			StrToDouble(parsed_line[5]));
			shapes_hash_table.put(new_shape.ID, new_shape);
			break;
		case "triangle":
			new_shape = new Triangle(color, StrToDouble(parsed_line[3]), StrToDouble(parsed_line[4]),
			StrToDouble(parsed_line[5]), StrToDouble(parsed_line[6]), StrToDouble(parsed_line[7]), StrToDouble(parsed_line[8]));
			shapes_hash_table.put(new_shape.ID, new_shape);
			break;	
		case "ellipse":
			new_shape = new Ellipse(color, StrToDouble(parsed_line[3]), StrToDouble(parsed_line[4]), 
			StrToDouble(parsed_line[5]), StrToDouble(parsed_line[6]), StrToDouble(parsed_line[7]));	
			shapes_hash_table.put(new_shape.ID, new_shape);
			break;
		case "circle":
			new_shape = new Circle(color, StrToDouble(parsed_line[3]), StrToDouble(parsed_line[4]),
			StrToDouble(parsed_line[5]));
			shapes_hash_table.put(new_shape.ID, new_shape);
			break;
		}
	}
	private static void DeleteCommand(int ID, HashMap<Integer, Shape> shapes_hash_table) {
		shapes_hash_table.remove(ID);
	}
	private static void AreaCommand(Color color, HashMap<Integer, Shape> shapes_hash_table) {
		int i = shapes_hash_table.size();
		double total_area = 0;
		for (i = 0; i < shapes_hash_table.size(); i++) {
			Shape current_shape = shapes_hash_table.get(i);
			if (current_shape.color == color) {
				total_area += current_shape.getArea();
			}
		}
		System.out.println(String.format("%.2f", total_area));
	}
	private static void ColorCommand(int ID, Color color, HashMap<Integer, Shape> shapes_hash_table) {
		Shape required_shape;
		required_shape = shapes_hash_table.get(ID);
		required_shape.setColor(color);
	}
	private static void CircumferenceCommand(Color color, HashMap<Integer, Shape> shapes_hash_table) {
		int i = shapes_hash_table.size();
		double total_circumference = 0;
		for (i = 0; i < shapes_hash_table.size(); i++) {
			Shape current_shape = shapes_hash_table.get(i);
			if (current_shape.color == color) {
				total_circumference += current_shape.getCircumference();
			}
		}
		System.out.println(String.format("%.2f", total_circumference));
	}
	private static double StrToDouble(String string) {
		return Double.parseDouble(string);
	}
}