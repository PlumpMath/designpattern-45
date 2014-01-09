interface Expression {
	boolean interpret(String context);
}

class TerminalExpression implements Expression {
	String data;

	public TerminalExpression(String data) {
		this.data = data;
	}

	public boolean interpret(String context) {
		if (context.contains(data)) {
			return true;
		}
		else {
			return false;
		}
	}
}

class OrExpression implements Expression {
	Expression expr1, expr2;

	public OrExpression(Expression expr1, Expression expr2) {
		this.expr1 = expr1;
		this.expr2 = expr2;
	}

	public boolean interpret(String context) {
		return expr1.interpret(context) || expr2.interpret(context);
	}
}

class AndExpression implements Expression {
	Expression expr1, expr2;

	public AndExpression(Expression expr1, Expression expr2) {
		this.expr1 = expr1;
		this.expr2 = expr2;
	}

	public boolean interpret(String context) {
		return expr1.interpret(context) && expr2.interpret(context);
	}
}

class Test {
	public static void main(String[] args) {
		Expression expr1 = new TerminalExpression("John");
		Expression expr2 = new TerminalExpression("Tom");

		Expression expr3 = new OrExpression(expr1, expr2);
	}
}