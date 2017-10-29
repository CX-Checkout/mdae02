package befaster.solutions;

import java.util.HashMap;
import java.util.Map;

public class Checkout {
	
	private static final Map<Character, SKU> SKUS = new HashMap<>();
	
	static final GroupDiscount GROUP_DISCOUNT = new GroupDiscount(new char[]{'S', 'T', 'X', 'Y', 'Z'}, 3, 45); 
	
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
		
		sku = new SKU();
		sku.addDeal(new Deal(1, 20));
		SKUS.put('G', sku);
		
		sku = new SKU();
		sku.addDeal(new Deal(10, 80));
		sku.addDeal(new Deal(5, 45));
		sku.addDeal(new Deal(1, 10));
		SKUS.put('H', sku);
		
		sku = new SKU();
		sku.addDeal(new Deal(1, 35));
		SKUS.put('I', sku);
		
		sku = new SKU();
		sku.addDeal(new Deal(1, 60));
		SKUS.put('J', sku);
		
		sku = new SKU();
		sku.addDeal(new Deal(2, 120));
		sku.addDeal(new Deal(1, 70));
		SKUS.put('K', sku);
		
		sku = new SKU();
		sku.addDeal(new Deal(1, 90));
		SKUS.put('L', sku);
		
		sku = new SKU();
		sku.addDeal(new Deal(1, 0, new Condition(3, 'N')));
		sku.addDeal(new Deal(1, 15));
		SKUS.put('M', sku);
		
		sku = new SKU();
		sku.addDeal(new Deal(1, 40));
		SKUS.put('N', sku);
		
		sku = new SKU();
		sku.addDeal(new Deal(1, 10));
		SKUS.put('O', sku);
		
		sku = new SKU();
		sku.addDeal(new Deal(5, 200));
		sku.addDeal(new Deal(1, 50));
		SKUS.put('P', sku);
		
		sku = new SKU();
		sku.addDeal(new Deal(1, 0, new Condition(3, 'R')));
		sku.addDeal(new Deal(3, 80));
		sku.addDeal(new Deal(1, 30));
		SKUS.put('Q', sku);
		
		sku = new SKU();
		sku.addDeal(new Deal(1, 50));
		SKUS.put('R', sku);
		
		sku = new SKU();
		sku.addDeal(new Deal(1, 20));
		SKUS.put('S', sku);
		
		sku = new SKU();
		sku.addDeal(new Deal(1, 20));
		SKUS.put('T', sku);
		
		sku = new SKU();
		sku.addDeal(new Deal(4, 120));
		sku.addDeal(new Deal(1, 40));
		SKUS.put('U', sku);
		
		sku = new SKU();
		sku.addDeal(new Deal(3, 130));
		sku.addDeal(new Deal(2, 90));
		sku.addDeal(new Deal(1, 50));
		SKUS.put('V', sku);
		
		sku = new SKU();
		sku.addDeal(new Deal(1, 20));
		SKUS.put('W', sku);
		
		sku = new SKU();
		sku.addDeal(new Deal(1, 17));
		SKUS.put('X', sku);
		
		sku = new SKU();
		sku.addDeal(new Deal(1, 20));
		SKUS.put('Y', sku);
		
		sku = new SKU();
		sku.addDeal(new Deal(1, 21));
		SKUS.put('Z', sku);
		
	}
    
	public static Integer checkout(String items) {
    	return new Bill(items).value(SKUS, GROUP_DISCOUNT);
    }
}
