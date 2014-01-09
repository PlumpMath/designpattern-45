interface Order {
	void execute();
}

public class Stock {
	private String name = "ABC";
	private int quantity = 10;

	public void buy() {
		System.out.println("Buy stock");
	}

	public void sell() {
		System.out.println("Sell stock");
	}
}

public class BuyStock implements Order {
	Stock stock;

	public BuyStock(Stock stock) {
		this.stock = stock;
	}

	public void execute() {
		stock.buy();
	}
}

public class SellStock implements Order {
	Stock stock;

	public SellStock(Stock stock) {
		this.stock = stock;
	}

	public void execute() {
		stock.sell();
	}
}

class Broker {
	List<Order> orderList = new ArrayList<Order>();

	public void takeOrder(Order order) {
		orderList.add(order);
	}

	public void executeOrders() {
		for (Order order : orderList) {
			order.execute();
		}

		orderList.clear();
	}
}

class Test {
	public static void main(String[] args) {
		Broker b = new Broker();
		Stock s = new Stock();
		b.takeOrder(new BuyStock(s));
		b.takeOrder(new SellStock(s));

		b.executeOrders();
	}
}