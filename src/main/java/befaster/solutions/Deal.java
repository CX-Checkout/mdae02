package befaster.solutions;

public class Deal implements Comparable<Deal>{
	
	private int quantity;
	private int price;

	Deal(int quantity, int price) {
		this.quantity = quantity;
		this.price = price;
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
	

}
