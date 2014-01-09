interface State {
	void doAction();
}

class StartState {
	public void doAction(Context context) {
		context.setState(this);
	}
}

class EndState {
	public void doAction(Context context) {
		context.setState(this);
	}
}

class Context {
	State state;

	public void setState(State state) {
		this.state = state;
	}
}

class Test {
	public static void main(String[] args) {
		State start = StartState();
		State end = EndState();

		Context player = new Context();

		start.doAction(player);
		end.doAction(player);
	}
}