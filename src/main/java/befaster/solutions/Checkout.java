package befaster.solutions;

import java.util.HashMap;
import java.util.Map;

public class Checkout {
	
	private static final Map<Character, SKU> SKUS = new HashMap<>();
	
	static {
		SKU sku = new SKU();
		sku.addDeal(new Deal(5, 200));
		sku.addDeal(new Deal(3, 130));
		sku.addDeal(new Deal(1, 50));
		SKUS.put('A', sku);
		
		sku = new SKU();
		sku.addDeal(new Deal(1, 0, new Condition(2, 'E')));
		sku.addDeal(new Deal(2, 45));
		sku.addDeal(new Deal(1, 30));
		SKUS.put('B', sku);
		
		sku = new SKU();
		sku.addDeal(new Deal(1, 20));
		SKUS.put('C', sku);
		
		sku = new SKU();
		sku.addDeal(new Deal(1, 15));
		SKUS.put('D', sku);
		
		sku = new SKU();
		sku.addDeal(new Deal(1, 40));
		SKUS.put('E', sku);
		
		sku = new SKU();
		sku.addDeal(new Deal(3, 20));
		sku.addDeal(new Deal(1, 10));
		SKUS.put('F', sku);
	}
    
	public static Integer checkout(String items) {
    	return new Bill(items).value(SKUS);
    }
}
