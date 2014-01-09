interface Package {
	void pack();
}

class Bottle implements Package {
	public void pack() {
		System.out.println("Bottle");
	}
}

class Wrapper implements Package {
	public void pack() {
		System.out.println("Wrapper");
	}
}

interface Item {
	public String name();
	public Package package();
	public float price();
}

abstract class Burger implements Item {
	public Package package() {
		return new Wrapper();
	}

	abstract String name();
	abstract float price();
}

abstract class Drink implements Item {
	public Package package() {
		return new Bottle();
	}

	abstract String name();
	abstract float price();
}

class BigMac implements Burger {
	public String name() {
		return "BigMac";
	}

	public float price() {
		return 1.5;
	}
}

class Coke implements Drink {
	public String name() {
		return "Coke";
	}

	public float price() {
		return 0.23;
	}
}

class Meal {
	List<Item> items = new ArrayList<Item>();

	public void addItem(Item item) {
		items.add(item);
	}

	public void displayPrice() {
		float sum = 0;
		for (Item item : items) {
			sum += item.price();
		}
		System.out.println("Total Price: " + sum);
	}
}

class MealBuilder {
	public static Meal prepareNumberOne() {
		Meal meal = new Meal();
		meal.addItem(new BigMac());
		meal.addItem(new Coke());
		return meal;
	}
}

public class Test {
	Meal m1 = MealBuilder.prepareNumberOne();
	m1.displayPrice();
}