package befaster.solutions;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class BillTest {

	@Test
	public void testBillConstruction(){
		Bill bill = new Bill("AAAABBB");
		assertEquals(4, bill.getQuantity('A'));
		assertEquals(3, bill.getQuantity('B'));
	}
	
	@Test
	public void testBillValue(){
		Bill bill = new Bill("AAAABBB");
		assertEquals(180+75, bill.value(makeSKUs(), getGroupDiscount()));
	}

	private GroupDiscount getGroupDiscount() {
		return new GroupDiscount(new char[]{}, 0, 0) {
			@Override
			GroupDiscountResult apply(Map<Character, Integer> quantities, Map<Character, SKU> skus, Bill bill){
				return new GroupDiscountResult(new HashMap<>(), 0);
			}
		};
	}

	private Map<Character, SKU> makeSKUs() {
		Map<Character, SKU> result = new HashMap<>();
		
		SKU sku = new SKU();
		sku.addDeal(new Deal(3, 130));
		sku.addDeal(new Deal(1, 50));
		result.put('A', sku);
		
		sku = new SKU();
		sku.addDeal(new Deal(2, 45));
		sku.addDeal(new Deal(1, 30));
		result.put('B', sku);
		
		return result;
	}
}
