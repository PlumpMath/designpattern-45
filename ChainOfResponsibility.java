abstract class AbstractLogger {
	public static int INFO = 1;
	public static int ERROR = 1;
	public static int DEBUG = 3;

	AbstractLogger nextLogger;

	public void setNextLogger(AbstractLogger nextLogger) {
		this.nextLogger = nextLogger;
	}

	public void logMessage(int level, String message) {
		if (this.level <= level) {
			write(message);
		}
		else if (nextLogger != null)
			nextLogger.logMessage(level, message);
		}
	}

	abstract void write(String message);
}

class INFOLogger extends AbstractLogger {
	int level;

	public INFOLogger(int level) {
		this.level = level;
	}

	public void write(String message) {
		System.out.println("INFO: " + message);
	}
}

class ERRORLogger extends AbstractLogger {
	int level;

	public ERRORLogger(int level) {
		this.level = level;
	}

	public void write(String message) {
		System.out.println("ERROR: " + message);
	}
}

class DEBUGLogger extends AbstractLogger {
	int level;

	public DEBUGLogger(int level) {
		this.level = level;
	}

	public void write(String message) {
		System.out.println("DEBUG: " + message);
	}
}

class Test {
	public static void main(String[] args) {
		AbstractLogger l1 = new INFOLogger(AbstractLogger.INFO);
		AbstractLogger l2 = new ERRORLogger(AbstractLogger.ERROR);
		AbstractLogger l3 = new DEBUGLogger(AbstractLogger.DEBUG);

		l3.setNextLogger(l2);
		l2.setNextLogger(l1);

		l3.logMessage(AbstractLogger.INFO, "INFO");
	}
}