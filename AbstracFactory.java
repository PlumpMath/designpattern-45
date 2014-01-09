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

interface Color {
	void fill();
}

class Red implements Color {
	public void fill() {
		System.out.println("Red");
	}
}

class Blue implements Color {
	public void fill() {
		System.out.println("Blue");
	}
}

class AbstractFactory {
	abstract Shape getShape();
	abstract Color getColor();
}

class ShapeFactory extends AbstractFactory {
	@override
	public Shape getShape(String shape) {
		if (shape == null) {
			return null;
		}
		if (shape.equals("Circle")) {
			return new Circle();
		}
		else if (shape.equals("Rectangle")) {
			return new Rectangle();
		}
		return null;
	}

	@override
	Color getColor() {
		return null;
	}
}

class ColorFactory extends AbstractFactory {
	@override
	public Color getColor(String color) {
		if (color == null) {
			return null;
		}
		if (color.equals("Red")) {
			return new Red();
		}
		else if (color.equals("Blue")) {
			return new Blue();
		}
		return null;
	}

	@override
	Shape getShape() {
		return null;
	}
}

class FactoryBuilder {
	public static AbstractFactory getFactory(String type) {
		if (type == null) {
			return null;
		}
		if (type.equals("Shape")) {
			return new ShapeFactory();
		}
		else if (type.equals("Color")) {
			return new ColorFactory();
		}
		return null;
	}
}

public class Test {
	public static void main(String[] args) {
		AbstractFactory f1 = FactoryBuilder.getFactory("Shape");
		Shape s1 = f1.getShape("Circle");
		Shape s2 = f1.getShape("Rectangle");

		AbstractFactory f2 = FactoryBuilder.getFactory("Color");
		Color c1 = f2.getColor("Red");
		Color c2 = f2.getColor("Blue");

		s1.draw();
		s2.draw();
		c1.fill();
		c2.fill();
	}
}