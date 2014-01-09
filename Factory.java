interface Shape {
	void draw();
}

class Circle implements Shape {
	public void draw() {
		System.out.println("Circle");
	}
}

class Rectangle implements Shape {
	public void draw() {
		System.out.println("Rectangle");
	}
}

class ShapeFactory {
	public Shape createShape(String shape) {
		if (shape == null) {
			return null;
		}
		if (shape.equals("Circle")) {
			return new Circle();
		}
		else if (shape.equals("Rectangle")) {
			return new Rectangle();
		}
		else {
			System.err.println("Invalid Input");
		}
		return null;
	}
}

public class Test {
	public static void main(String[] args) {
		ShapeFactory f1 = new ShapeFactory();
		Shape s1 = f1.createShape("Circle");
		Shape s2 = f1.createShape("Rectangle");
		s1.draw();
		s2.draw();
	}
}
