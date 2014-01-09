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

class ShapeMaker {
	Shape circle, rectangle;

	public ShapeMaker() {
		circle = new Circle();
		rectangle = new Rectangle();
	}

	public void drawCircle() {
		circle.draw();
	}

	public void drawRectangle() {
		rectangle.draw();
	}
}

class Test {
	public static void main(String[] args) {
		ShapeMaker sm = new ShapeMaker();
		sm.drawCircle();
		sm.drawRectangle();
	}
}