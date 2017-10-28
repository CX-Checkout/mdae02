package befaster.solutions;

import java.util.ArrayList;
import java.util.List;

public class SKU {

	private List<Deal> deals = new ArrayList<>(); 
	
	void addDeal(Deal deal) {
		deals.add(deal);
	}

	int valueOf(int purchaseQuantity, Bill bill) {
		int result = 0;
		for (Deal deal : deals) {
			int numberOfApplications = deal.getNumberOfApplications(purchaseQuantity, bill);
			result += deal.getPrice() * numberOfApplications;
				purchaseQuantity -= deal.getQuantity() * numberOfApplications;
		}
		return result;
	}
}
