interface Image {
	void display();
}

class RealImage implements Image {
	String fileName;
	public RealImage(String fileName) {
		loadFromDisk(fileName);
		this.fileName = fileName;
	}

	private void loadFromDisk(String fileName) {
		System.out.println("Loading from disk " + fileName);
	}

	public void display() {
		System.out.println("Displaying " + fileName);
	}
}

class ProxyImage implements Image {
	Image realImage;
	String fileName;

	public ProxyImage(String fileName) {
		this.fileName = fileName;
	}

	public void display() {
		if (realImage == null) {
			realImage = new RealImage(fileName);
		}
		realImage.display();
	}
}

class Test {
	public static void main(String[] args) {
		Image proxyImage = new ProxyImage("sky.jpg");
		proxyImage.display();
		proxyImage.display();
	}
}