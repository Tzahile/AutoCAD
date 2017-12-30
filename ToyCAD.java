import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.lang.reflect.*;

public class ToyCAD
{
    private static final int SUCCESS = 0;
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
    IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
    SecurityException
    {
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
                    DeleteCommand(StrToInt(parsed_line[1]), shapes_hash_table);
                    break;
                case "move":
                    MoveCommand(StrToInt(parsed_line[1]), StrToDouble(parsed_line[2]),
                    		StrToDouble(parsed_line[3]), shapes_hash_table);
                    break;
                case "copy":
                    CopyCommand(StrToInt(parsed_line[1]), StrToDouble(parsed_line[2]),
                    		StrToDouble(parsed_line[3]), shapes_hash_table);
                    break;
                case "area":
                    parsed_line[1] = parsed_line[1].toUpperCase();
                    AreaCommand(Color.valueOf(parsed_line[1]), shapes_hash_table);
                    break;
                case "color":
                    parsed_line[1] = parsed_line[1].toUpperCase();
                    ColorCommand(StrToInt(parsed_line[2]), Color.valueOf(parsed_line[1]), shapes_hash_table);
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
    
    private static String GetLineFromUser(Scanner scan)
    {
        String input_string = "";
        input_string = scan.nextLine();
        input_string = input_string.toLowerCase();
        return input_string;
    }
    
    private static String[] ParseLine(String line)
    {
        String[] parsedLine = line.split(" ");
        return parsedLine;
    }
    
	private static void NewCommand(String[] parsed_line, HashMap < Integer, Shape > shapes_hash_table) 
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException
    {   
        Class<? extends Shape> reflected_class = Class.forName(Capitalize(parsed_line[1])).asSubclass(Shape.class);
        Constructor<?>[] reflected_constructor = reflected_class.getDeclaredConstructors();
    	double[] sliced_double_parsed_line = StringArraySliceToDoubleArray(parsed_line, 3, parsed_line.length);
    	Object[] object_args = new Object[sliced_double_parsed_line.length+1];
    	object_args[0] = Color.valueOf(parsed_line[2].toUpperCase());
    	for (int i = 0; i < sliced_double_parsed_line.length; i++)
    	{
    		object_args[i+1] = Double.valueOf(sliced_double_parsed_line[i]);
    	}
    	Object reflected_object = reflected_constructor[0].newInstance(object_args);
    	Method reflected_method = reflected_class.getMethod("getID");
		Object invoked_method_result = reflected_method.invoke(reflected_object);
	    shapes_hash_table.put((Integer)invoked_method_result, (Shape)reflected_object);
	    System.out.println(invoked_method_result);
    }
    
    private static void DeleteCommand(int ID, HashMap < Integer, Shape > shapes_hash_table)
    {
        shapes_hash_table.remove(ID);
    }
    
    private static void MoveCommand(int ID, double x_offset, double y_offset, 
    		HashMap < Integer, Shape > shapes_hash_table)
    {
    	Shape current_shape = shapes_hash_table.get(ID);
    	current_shape.Move(x_offset, y_offset);
    }

    private static void CopyCommand(int ID, double x_offset, double y_offset, 
    		HashMap < Integer, Shape > shapes_hash_table)
    {
    	Shape current_shape = shapes_hash_table.get(ID);
    	Shape clone = current_shape.Clone();
    	clone.Move(x_offset, y_offset);
    	shapes_hash_table.put(clone.getID(), clone);
    	System.out.println(clone.getID());
    }
    
    private static void AreaCommand(Color color, HashMap < Integer, Shape > shapes_hash_table)
    {
        double total_area = 0;
        for (Integer key: shapes_hash_table.keySet())
        {
            Shape current_shape = shapes_hash_table.get(key);
            if (current_shape.getColor() == color) {
                total_area += current_shape.getArea();
            }
        }
        System.out.println(String.format("%.2f", total_area));
    }
    
    private static void isInsideCommand(String[] parsed_line, HashMap < Integer, Shape > shapes_hash_table)
    {
        int ID = StrToInt(parsed_line[1]);
        boolean is_inside = false;
        double x_coordinate = StrToDouble(parsed_line[2]);
        double y_coordinate = StrToDouble(parsed_line[3]);
        Shape current_shape = shapes_hash_table.get(ID);
        is_inside = current_shape.isPointInside(x_coordinate, y_coordinate);
        if (is_inside == true)
        {
        	System.out.println(1);
        } else {
        	System.out.println(0);
        }
    }
    
    private static void ColorCommand(int ID, Color color, HashMap < Integer, Shape > shapes_hash_table)
    {
        Shape required_shape;
        required_shape = shapes_hash_table.get(ID);
        required_shape.setColor(color);
    }
    
    private static void CircumferenceCommand(Color color, HashMap < Integer, Shape > shapes_hash_table)
    {
        double total_circumference = 0;
        for (Integer key: shapes_hash_table.keySet())
        {
            Shape current_shape = shapes_hash_table.get(key);
            if (current_shape.getColor() == color)
            {
            	total_circumference += current_shape.getCircumference();
            }
        }
        System.out.println(String.format("%.2f", total_circumference));
    }
    
    private static int StrToInt(String string)
    {
    	return Integer.parseInt(string);
    }
    
    private static double StrToDouble(String string)
    {
    	return Double.parseDouble(string);
    }
    
    private static double[] StrArrayToDoubleArray(String[] string_array)
    {
    	double[] double_array = Arrays.stream(string_array).mapToDouble(Double::parseDouble).toArray();
    	return  double_array;
    }
    
    private static double[] StringArraySliceToDoubleArray(String[] string_array, int start, int end)
    {
    	String[] trimmed_parsed_line = Arrays.copyOfRange(string_array, start, end);
    	double[] double_array = StrArrayToDoubleArray(trimmed_parsed_line);
    	return double_array;
    }
    
    private static String Capitalize(String string)
    {
        String mystring = string.substring(0, 1).toUpperCase() + string.substring(1);
        return mystring;
    }
}
	