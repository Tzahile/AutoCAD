import java.util.HashMap;
import java.util.Scanner;

public class Main {
	private static final int SUCCESS = 0;
	public static void main(String[] args) {
		HashMap < Integer, Shape > shapes_hash_table = new HashMap < Integer, Shape > ();
		Scanner scan = new Scanner(System.in);
		String input_line;
		String[] parsed_line;
		while (true) {
			input_line = GetLineFromUser(scan);
			parsed_line = ParseLine(input_line);
			switch (parsed_line[0]) {
				case "new":
					NewCommand(parsed_line, shapes_hash_table);
					break;
				case "delete":
					DeleteCommand(Integer.parseInt(parsed_line[1]), shapes_hash_table);
					break;
				case "move":
					MoveCommand(parsed_line, shapes_hash_table);
					break;
				case "copy":
					//CopyCommand(parsed_line, shapes_hash_table);
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
	private static void NewCommand(String[] parsed_line, HashMap < Integer, Shape > shapes_hash_table) {
		Shape new_shape;
		//parsed_line[2] = parsed_line[2].toUpperCase();
		Color color = Color.valueOf(parsed_line[2].toUpperCase());
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
	private static void DeleteCommand(int ID, HashMap < Integer, Shape > shapes_hash_table) {
		shapes_hash_table.remove(ID);
	}
	private static void MoveCommand(String[] parsed_line, HashMap < Integer, Shape > shapes_hash_table) {
		Shape current_shape = shapes_hash_table.get(Integer.parseInt(parsed_line[1]));
		current_shape.moveAllPoints(Double.parseDouble(parsed_line[2]), Double.parseDouble(parsed_line[3]));
	}
	private static void AreaCommand(Color color, HashMap < Integer, Shape > shapes_hash_table) {
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
	private static void ColorCommand(int ID, Color color, HashMap < Integer, Shape > shapes_hash_table) {
		Shape required_shape;
		required_shape = shapes_hash_table.get(ID);
		required_shape.setColor(color);
	}
	private static void CircumferenceCommand(Color color, HashMap < Integer, Shape > shapes_hash_table) {
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