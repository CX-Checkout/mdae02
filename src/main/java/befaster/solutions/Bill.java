package befaster.solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Bill {

	Map<Character, Integer> quantities = new HashMap<>();
	
	public Bill(String items) {
		for (int i = 0, n = items.length(); i < n; i++) {
			char item = items.charAt(i);
			quantities.put(item, quantities.getOrDefault(item, 0)+1);
		}
	}

	int getQuantity(char item) {
		return quantities.getOrDefault(item, 0);
	}

	int value(Map<Character, SKU> skus) {
		int result = 0;
		for (Entry<Character, Integer> quantity : quantities.entrySet()) {
			if (skus.containsKey(quantity.getKey())) {
				result += skus.get(quantity.getKey()).valueOf(quantity.getValue(), this);
			}else {
				return -1;
			}
		}
		return result;
	}

}
