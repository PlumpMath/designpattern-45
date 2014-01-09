class SingleObject {
	public static SingleObject singleObject = new SingleObject();

	private SingleObject(){
	}

	public static SingleObject getObject() {
		return singleObject;
	}

	public void print(String message) {
		System.out.println(message);
	}
}

public class Test {
	public static void main(String[] args) {
		StringleObject s1 = SingleObject.getObject();
		s1.print("Hello World");
	}
}