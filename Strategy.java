interface Strategy {
	int doAction(int num1, int num2);
}

class SubStractStrategy implements Strategy {
	public int doAction(int num1, int num2) {
		return num1 - num2;
	}
}

class AddStrategy implements Strategy {
	public int doAction(int num1, int num2) {
		return num1 + num2;
	}
}

class Context {
	Strategy strategy;
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public int executeStrategy(int num1, int num2) {
		this.strategy.doAction(num1, num2);
	}
}

class Test {
	public static void main(String[] args) {
		Context c = new Context();
		c.setStrategy(new SubStractStrategy());
		c.executeStrategy(1, 2);
		c.setStrategy(new AddStrategy());
		c.executeStrategy(1, 2);
	}
}