package befaster.solutions;

import java.util.HashMap;
import java.util.Map;

public class Checkout {
	
	private static final Map<Character, SKU> SKUS = new HashMap<>();
	
	static {
		SKU sku = new SKU();
		sku.addDeal(new Deal(1, 50));
		sku.addDeal(new Deal(3, 130));
		SKUS.put('A', sku);
		
		sku = new SKU();
		sku.addDeal(new Deal(1, 30));
		sku.addDeal(new Deal(2, 45));
		SKUS.put('B', sku);
		
		sku = new SKU();
		sku.addDeal(new Deal(1, 20));
		SKUS.put('C', sku);
		
		sku = new SKU();
		sku.addDeal(new Deal(1, 15));
		SKUS.put('D', sku);
	}
    
	public static Integer checkout(String items) {
    	return new Bill(items).value(SKUS);
    }
}
