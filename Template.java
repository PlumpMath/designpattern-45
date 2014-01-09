abstract class Game {
	abstract void initialize();
	abstract void start();
	abstract void end();

	public void play() {
		initilize();
		start();
		end();
	}
}

class Soccer extends Game {
	void initialize() {
		System.out.println("Soccer initialize");
	}

	void start() {
		System.out.println("Soccer start");
	}

	void end() {
		System.out.println("Soccer end");
	}
}

class Basketball extends Game {
	void initialize() {
		System.out.println("B-ball initialize");
	}

	void start() {
		System.out.println("B-ball start");
	}

	void end() {
		System.out.println("B-ball end");
	}	
}

class Test {
	public static void main(String[] args) {
		Game soccer = new Soccer();
		Game basketball = new Basketball();

		soccer.play();
		basketball.play();
	}
}