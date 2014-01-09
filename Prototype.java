abstract class Shape implements Cloneable {
	private String id;
	protected String type;
	abstract void draw();

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public Object clone() {
		Object clone = null;
		try {
			clone = super.clone();
		}
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}
}

class Circle extends Shape {
	public Circle {
		super();
		this.type = "Circle";
	}
	public void draw() {
		System.out.println("Circle");
	}
}

class ShapeCache {
	public static Map<Integer, Shape> map = new HashMap<Integer, Shape>();
	
	public static Shape getShape(Integer id) {
		return (Shape)map.get(id).clone();
	}

	public static void loadCache() {
		Shape s1 = new Circle();
		s1.setId("1");
		map.put(1, s1);
	}
}

public class Test {
	public static void main(String[] args) {
		ShapeCache.loadCache();
		Shape s1 = ShapeCache.getShape(1);
		s1.draw();
	}
}