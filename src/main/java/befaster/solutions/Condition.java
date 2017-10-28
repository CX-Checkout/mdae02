package befaster.solutions;

class Condition implements ICondition{

	private int quantity;
	private char item;

	Condition(int quantity, char item) {
		this.quantity = quantity;
		this.item = item;
	}

	@Override
	public int getNumberOfApplications(Bill bill) {
		return bill.getQuantity(item) / quantity;
	}

}
