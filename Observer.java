class Subject {
	List<Observer> observerList;
	int state;

	public Subject(int state) {
		this.state = state;
	}

	public void attach(Observer ob) {
		observerList.add(ob);
	}

	public void detach(Observer ob) {
		observerList.remove(ob);
	}

	public void notifyAll() {
		for (Observer ob : observerList) {
			ob.update();
		}
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		notifyAll();
	}
}

abstract class Observer {
	protected Subject subject;
	abstract void update();
}

class BinaryObserver extends Observer {
	public BinaryObserver(Subject subject) {
		this.subject = subject;
		subject.attach(this);
	}

	public void update() {
		System.out.println("BinaryObserver is notified " + Integer.toBinaryString(subject.getState()));
	}
}

class HexObserver extends Observer {
	public HexObserver(Subject subject) {
		this.subject = subject;
		subject.attach(this);
	}

	public void update() {
		System.out.println("BinaryObserver is notified " + Integer.toHexString(subject.getState()));
	}
}

class Test {
	public static void main(String[] args) {
		Subject s = new Subject(5);

		new BinaryObserver(s);
		new HexObserver(s);

		s.setState(7);
	}
}
