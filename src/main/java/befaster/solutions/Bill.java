package befaster.solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Bill {

	Map<Character, Integer> quantities = new HashMap<>();
	
	public Bill(String items) {
		for (int i = 0; i < items.length(); i++) {
			char item = items.charAt(i);
			quantities.put(item, quantities.getOrDefault(item, 0)+1);
		}
	}

	int getQuantity(char item) {
		return quantities.get(item);
	}

	int value(Map<Character, SKU> skus) {
		int result = 0;
		for (Entry<Character, Integer> quantity : quantities.entrySet()) {
			if (skus.containsKey())
			result += skus.get(quantity.getKey()).valueOf(quantity.getValue());
		}
		return result;
	}

}
