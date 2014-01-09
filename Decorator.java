interface Shape {
	void draw();
}

class Circle implements Shape {
	void draw() {
		System.out.println("Circle");
	}
}

class Rectangle implements Shape {
	void draw() {
		System.out.println("Rectangle");
	}
}

abstract class DecoratedShape implements Shape {
	Shape decoratedShape;

	public DecoratedShape(Shape decoratedShape) {
		this.decoratedShape = decoratedShape;
	}

	public void draw() {
		decoratedShape.draw();
	}
}

class RedDecoratedShape extends DecoratedShape {
	public RedDecoratedShape(Shape decoratedShape) {
		super(decoratedShape);
	}

	public void draw() {
		decoratedShape.draw();
		setRedBorder(decoratedShape);
	}

	private void setRedBorder(Shape decoratedShape) {
		System.out.println("Set Red Border");
	}
}

class Test {
	public static void main(String[] args) {
		Shape decoratedShape = new RedDecoratedShape(new Circle());
		decoratedShape.draw();
	}
}