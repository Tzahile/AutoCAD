import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	private static final int SUCCESS = 0;
	private static final int COMAND_NOT_EXIST = -1;
	public static void main(String[] args) {
		ArrayList < String > all_NewCommands = new ArrayList < String > ();
		HashMap < Integer, Shape > shapes_hash_table = new HashMap < Integer, Shape > ();
		Scanner scan = new Scanner(System.in);
		String input_line;
		String[] parsed_line;
		while (true) {
			input_line = GetLineFromUser(scan);
			parsed_line = ParseLine(input_line);
			switch (parsed_line[0]) {
				case "new":
					all_NewCommands.add(input_line);
					NewCommand(parsed_line, shapes_hash_table);
					break;
				case "delete":
					DeleteCommand(Integer.parseInt(parsed_line[1]), shapes_hash_table);
					break;
				case "move":
					MoveCommand(parsed_line, shapes_hash_table);
					break;
				case "copy":
					CopyCommand(parsed_line, shapes_hash_table, all_NewCommands);
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
					isInsideCommand(parsed_line, shapes_hash_table);		
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
	private static int NewCommand(String[] parsed_line, HashMap < Integer, Shape > shapes_hash_table) {
		Shape new_shape;
		Color color = Color.valueOf(parsed_line[2].toUpperCase());
		switch (parsed_line[1]) {
			case "parallelogram":
				new_shape = new Parallelogram(color, StrToDouble(parsed_line[3]), StrToDouble(parsed_line[4]),
					StrToDouble(parsed_line[5]), StrToDouble(parsed_line[6]), StrToDouble(parsed_line[7]), StrToDouble(parsed_line[8]));
				shapes_hash_table.put(new_shape.ID, new_shape);
				return new_shape.ID;
			case "rectangle":
				new_shape = new Rectangle(color, StrToDouble(parsed_line[3]), StrToDouble(parsed_line[4]),
					StrToDouble(parsed_line[5]), StrToDouble(parsed_line[6]));
				shapes_hash_table.put(new_shape.ID, new_shape);
				return new_shape.ID;
			case "square":
				new_shape = new Square(color, StrToDouble(parsed_line[3]), StrToDouble(parsed_line[4]),
					StrToDouble(parsed_line[5]));
				shapes_hash_table.put(new_shape.ID, new_shape);
				return new_shape.ID;
			case "triangle":
				new_shape = new Triangle(color, StrToDouble(parsed_line[3]), StrToDouble(parsed_line[4]),
					StrToDouble(parsed_line[5]), StrToDouble(parsed_line[6]), StrToDouble(parsed_line[7]), StrToDouble(parsed_line[8]));
				shapes_hash_table.put(new_shape.ID, new_shape);
				return new_shape.ID;
			case "ellipse":
				new_shape = new Ellipse(color, StrToDouble(parsed_line[3]), StrToDouble(parsed_line[4]),
					StrToDouble(parsed_line[5]), StrToDouble(parsed_line[6]), StrToDouble(parsed_line[7]));
				shapes_hash_table.put(new_shape.ID, new_shape);
				return new_shape.ID;
			case "circle":
				new_shape = new Circle(color, StrToDouble(parsed_line[3]), StrToDouble(parsed_line[4]),
					StrToDouble(parsed_line[5]));
				shapes_hash_table.put(new_shape.ID, new_shape);
				return new_shape.ID;
			default:
				return COMAND_NOT_EXIST;
		}
	}
	private static void DeleteCommand(int ID, HashMap < Integer, Shape > shapes_hash_table) {
		shapes_hash_table.remove(ID);
	}
	private static void MoveCommand(String[] parsed_line, HashMap < Integer, Shape > shapes_hash_table) {
		int ID = Integer.parseInt(parsed_line[1]);
		double x_coordinate = Double.parseDouble(parsed_line[2]);
		double y_coordinate = Double.parseDouble(parsed_line[3]);
		Shape current_shape = shapes_hash_table.get(ID);
		current_shape.moveAllPoints(x_coordinate, y_coordinate);
	}
	private static void CopyCommand(String[] parsed_line, HashMap < Integer, Shape > shapes_hash_table, ArrayList < String > all_commands){
		int ID = Integer.parseInt(parsed_line[1]);
		String new_copy_line = all_commands.get(ID);
		String[] new_copy_parsed_line = ParseLine(new_copy_line);
		int new_copy_ID = NewCommand(new_copy_parsed_line, shapes_hash_table);
		String move_string = "Move " + String.valueOf(new_copy_ID) + " " + parsed_line[2] + " " + parsed_line[2];
		String[] move_parsed_line = ParseLine(move_string);
		MoveCommand(move_parsed_line, shapes_hash_table);
		System.out.println(new_copy_ID);
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
	public static void isInsideCommand(String[] parsed_line, HashMap < Integer, Shape > shapes_hash_table) {
		int ID = Integer.parseInt(parsed_line[1]);
		double x_coordinate = Double.parseDouble(parsed_line[2]);
		double y_coordinate = Double.parseDouble(parsed_line[3]);
		Shape current_shape = shapes_hash_table.get(ID);
		System.out.println(current_shape.isInside(x_coordinate, y_coordinate));
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