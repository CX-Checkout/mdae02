package befaster.solutions;

public class Deal implements Comparable<Deal>{
	
	private int quantity;
	private int price;
	private ICondition condition;

	Deal(int quantity, int price) {
		this(quantity, price, new NullCondition());
	}

	Deal(int quantity, int price, ICondition condition) {
		this.quantity = quantity;
		this.price = price;
		this.condition = condition;
	}

	int getPrice() {
		return price;
	}

	int getQuantity() {
		return quantity;
	}

	@Override
	public int compareTo(Deal o) {
		return o.quantity - quantity;
	}

	int getNumberOfApplications(int purchaseQuantity, Bill bill) {
		return Math.min(purchaseQuantity/quantity, condition.getNumberOfApplications(bill));
	}
}
