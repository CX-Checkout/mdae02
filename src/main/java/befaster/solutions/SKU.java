package befaster.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SKU {

	private List<Deal> deals = new ArrayList<>(); 
	
	void addDeal(Deal deal) {
		deals.add(deal);
		Collections.sort(deals);
	}

	int valueOf(int purchaseQuantity) {
		int result = 0;
		for (Deal deal : deals) {
			while (purchaseQuantity >= deal.getQuantity()) {
				result += deal.getPrice();
				purchaseQuantity -= deal.getQuantity();
			}
		}
		return result;
	}

}
