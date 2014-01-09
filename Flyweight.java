interface Shape {
	void draw();
}

class Circle implements Shape {
	int x, y, radius;
	String color;

	public Circle(String color) {
		this.color = color;
	}

	public void draw() {
		System.out.println("Draw Circle");
	}
}

class ShapeFactory {
	Map<String, Shape> circles;

	public static Shape createCircle(String color) {
		Shape circle = circles.get(color);
		if (circle == null) {
			circle = new Circle(color);
			circles.put(color, circle);
		}
		return circle;
	}
}

class Test {
	public static void main(String[] args) {
		List<Circle> circles = new ArrayList<Circle>();
		for (int i = 0; i < 20; ++i) {
			circles.add((Circle)ShapeFactory.createCircle(String.valueOf(i % 5));
		}
	}
}