interface ComputerPart {
	void accept(ComputerPartVisitor visitor);
}

class Mouse implements ComputerPart {
	public void accept(ComputerPartVisitor visitor) {
		System.out.println("Mouse says Hello");
		visitor.visit(this);
	}
}

class Keyboard implements ComputerPart {
	public void accept(ComputerPartVisitor visitor) {
		System.out.println("Keyboard says Hello");
		visitor.visit(this);
	}
}

class Computer implements ComputerPart {
	ComputerPart mouse, keyboard;
	public Computer() {
		this.mouse = new Mouse();
		this.keyboard = new Keyboard();
	}

	public void accept(ComputerPartVisitor visitor) {
		mouse.accept(visitor);
		keyboard.accept(visitor);
	}
}

interface ComputerPartVisitor {
	void visit(Computer computer);
	void visit(Mouse mouse);
	void visit(Keyboard keyboard);
}

class ComputerPartDisplayVisitor implements ComputerPartVisitor {
	void visit(Computer computer) {
		System.out.println("Displaying computer");
	}
	void visit(Mouse mouse) {
		System.out.println("Displaying mouse");
	}
	void visit(Keyboard keyboard) {
		System.out.println("Displaying keyboard");
	}
}

class Test {
	public static void main(String[] args) {
		Computer c = new Computer();
		ComputerPartDisplayVisitor cpdv = new ComputerPartDisplayVisitor();
		cpdv.visit(c);
	}
}