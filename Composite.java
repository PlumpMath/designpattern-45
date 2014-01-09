class Employee {
	Employee boss;
	String name;
	int age;
	double salary;
	List<Employee> subordinates;

	public Employee(String name, int age, double salary, Employee boss) {
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.boss = boss;
	}

	public void add(Employee e) {
		subordinates.add(e);
	}
}

class Test {
	public static void main(String[] args) {
		Employee ceo = new Employee("John", 55, 500000, null);
		Employee e1 = new Employee("Summer", 25, 50000, ceo);
		ceo.add(e1);
	}
}