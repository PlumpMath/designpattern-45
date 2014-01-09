class Memento {
	String state;
	String time;

	public Memento(String state, String time) {
		this.state = state;
		this.time = time;
	}

	public String getState() {
		return state;
	}

	public String getTime() {
		return time;
	}
}

class Originator {
	String state;
	String name;

	public Originator(String state, String name) {
		this.state = state;
		this.name = name;
	}

	public Memento saveStateToMemento() {
		return new Memento(state, null);
	}

	public void getStateFromMemento(Memento m) {
		state = m.getState();
	}

	public void setState(String state) {
		this.state = state;
	}
}

class CareTaker {
	List<Memento> mementoList;
	public CareTaker() {
		mementoList = new ArrayList<Memento>();
	}

	public void addMemento(Memento m) {
		mementoList.add(m);
	}

	public Memento restore(int i) {
		return mementoList.get(i);
	}
}

class Test {
	public static void main(String[] args) {
		Originator o = new Originator("true", "Tom");
		CareTaker ct = new CareTaker();
		ct.add(o.saveStateToMemento());
		o.setState("False");
		ct.add(o.saveStateToMemento());

		o.getStateFromMemento(ct.restore(0));
	}
}