interface DrawAPI {
	void drawCircle(int x, int y, int radius);
}

class RedDraw implements DrawAPI {
	void drawCircle(int x, int y, int radius) {
		System.out.println("Red draw ");
	}
}

class BlueDraw implements DrawAPI {
	void drawCircle(int x, int y, int radius) {
		System.out.println("Blue draw ");
	}
}

class Shape {
	DrawAPI drawApi;

	public Shape (int x, int y, DrawAPI drawApi) {
		this.drawApi = drawApi;
	}

	abstract void draw();
}

class Circle extends Shape {
	int x, y, radius;

	public Circle (int x, int y, int radius, DrawAPI drawApi) {
		super(drawApi);
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public void draw() {
		this.drawApi.drawCircle(x, y, radius);
	}
}

class Test {
	public static void main(String[] args) {
		Shape c = new Circle(0, 1, 1, new RedDraw());
		c.draw();
	}
}