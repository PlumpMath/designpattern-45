interface Iterator {
	boolean hasNext();
	Object next();
}

interface Container {
	Iterator getIterator();
}

class MyList {
	double[] data;

	public MyList(int len) {
		data = new double[len];
	}

	public Iterator getIterator() {
		return new Iterator();
	}

	public class MyIterator implements Iterator{
		int index;

		public boolean hasNext() {
			return index >= data.length;
		}

		public Object next() {
			return data[index++];
		}
	}
}

class Test {
	public static void main(String[] args) {
		MyList list = new MyList(10);
		for (Iterator iter = list.getIterator(); iter.hasNext();) {
			System.out.println((double)iter.next());
		}
	}
}