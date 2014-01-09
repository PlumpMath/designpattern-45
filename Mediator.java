class Chatroom {
	public static void showMessage(User user, String message) {
		System.out.println(user.getName() + " says " + message);
	}
}

class User {
	String name;
	public User(String name) {
		this.name = name;
	}

	public chat(String message) {
		Chatroom.showMessage(this, message);
	}
}

class Test {
	public static void main(String[] args) {
		User u1 = new User("John");
		User u2 = new User("Tom");

		u1.chat("lalala");
		u2.chat("what?");
	}
}