package befaster.solutions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupDiscount {
	
	private char[] items;
	private int quantity;
	private int price;

	GroupDiscount(char[] items, int quantity, int price) {
		this.items = items;
		this.quantity = quantity;
		this.price = price;
	}

	GroupDiscountResult apply(Map<Character, Integer> quantities, Map<Character, SKU> skus, Bill bill) {
		int totalItems = 0;
		for (char item : items) {
			totalItems += quantities.getOrDefault(item, 0);
		}
		
		Map<Integer, List<Character>> pricesToItems = getPricesToItems(skus, bill);
		
		ArrayList<Integer> prices = new ArrayList<>(pricesToItems.keySet());
		prices.sort(Comparator.reverseOrder());
		
		int applications = totalItems / quantity;
		int itemsToBuy = applications * quantity;
		
		HashMap<Character, Integer> results = new HashMap<>();
		for (Integer p : prices) {
			for (Character character : pricesToItems.get(p)) {
				int quantityToUse = Math.min(quantities.getOrDefault(character, 0) ,itemsToBuy);
				itemsToBuy -= quantityToUse;
				results.put(character, quantityToUse);
			}
		}
		return new GroupDiscountResult(results, applications * price);
	}

	/**
	 * TODO Make this fail fast if there are quantity discounts on the qualifying items, instead
	 * of silently getting it wrong.
	 */
	private Map<Integer, List<Character>> getPricesToItems(Map<Character, SKU> skus, Bill bill) {

		Map<Integer, List<Character>> pricesToItems = new HashMap<>();

		for (char item : items) {
			SKU sku = skus.get(item);
			int price = sku.valueOf(1, bill);
			List<Character> itemsWithThatPrice = pricesToItems.getOrDefault(price, new ArrayList<>());
			itemsWithThatPrice.add(item);
			pricesToItems.put(price, itemsWithThatPrice);
		}
		return pricesToItems;
	}

}
