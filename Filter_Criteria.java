class Person {
	String name;
	int age;
	String gender;

	public Person(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}
}

interface Criteria {
	List<Person> meetCriteria(List<Person> persons);
}

class CriteriaMale implements Criteria {
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> malePersons = new ArrayList<Person>();
		for (Person person: persons) {
			if (person.getGender().equalsIgnoreCase("male")) {
				malePersons.add(person);
			}
		}
		return malePersons;
	}
}

class CriteriaAnd implements Criteria {
	Criteria c1, c2;
	public CriteriaAnd(Criteria c1, Criteria c2) {
		this.c1 = c1;
		this.c2 = c2;
	}

	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> firstCriterias = c1.meetCriteria(persons);
		return c2.meetCriteria(persons);
	}
}

class Test {
	public static void main(String[] args) {
		Criteria maleCriteria = new CriteriaMale();
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("Tom", 34, "Male"));

		List<Person> malePersons = maleCriteria.meetCriteria(persons);
	}
}

