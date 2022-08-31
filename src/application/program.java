package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Circle;
import model.entities.Rectangle;
import model.entities.Shape;
import model.enums.Color;

public class program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		List<Shape> shapes = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the number of shapes: ");
		Integer number_of_shapes = scanner.nextInt(); 
		scanner = new Scanner(System.in);
		
		for(Integer i = 1; i <= number_of_shapes; i++) {
			scanner = new Scanner(System.in);
			System.out.printf("Shape #%d data:\n", i);
			System.out.print("Rectangle or Circle (r/c)? ");
			String shape_option = scanner.nextLine();
			
			System.out.print("Color (BLACK/BLUE/RED): ");
			String color = scanner.nextLine();
			
			if(shape_option.toLowerCase().equals("r")) {
				// Rectangle
				System.out.print("Width: ");
				Double width = scanner.nextDouble();
				
				System.out.print("Height: ");
				Double height = scanner.nextDouble();
				
				shapes.add(new Rectangle(Color.valueOf(color.toUpperCase()), width, height));
				
			} else if(shape_option.toLowerCase().equals("c")) {
				System.out.print("Radius: ");
				Double radius = scanner.nextDouble();
				
				shapes.add(new Circle(Color.valueOf(color.toUpperCase()), radius));
			} else {
				i--;
				System.out.println("[WRONG OPTION]");
			}
			
		}
		System.out.println("\nSHAPE AREAS");
		for(Shape shape: shapes) {
			System.out.println(String.format("%.2f", shape.area()));
		}

	}

}
