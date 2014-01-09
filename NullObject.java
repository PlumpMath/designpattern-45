abstract class AbstractCustomer {
	String name;
	abstract boolean ifNull();
}

class RealCustomer extends AbstractCustomer {
	public RealCustomer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public boolean ifNull() {
		return false;
	}
}

class NilCustomer extends AbstractCustomer {
	public boolean isNull() {
		return true;
	}

	public String getName() {
		return "No name can be returned!";
	}
}

class CustomerFactory {
	Set<String> nameSet = new HashSet<String>();

	public CustomerFactory(List<String> names) {
		for (String name : names) {
			nameSet.add(name);
		}
	}

	public AbstractCustomer createCustomer(String name) {
		if(nameSet.contains(name)) {
			return new RealCustomer(name);
		}
		else {
			return new NilCustomer();
		}
	}
}

class Test {
	public static void main(String[] args) {
		List<String> nameList = new ArrayList<String>();
		nameList.add("Tom");
		CustomerFactory cf = new CustomerFactory(nameList);
		AbstractCustomer c1 = cf.createCustomer("Tom");
		AbstractCustomer c2 = cf.createCustomer("John");
	}
}