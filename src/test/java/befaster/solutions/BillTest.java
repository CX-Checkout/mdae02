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
		assertEquals(180+75, bill.value(makeSKUs()));
	}

	private Map<Character, SKU> makeSKUs() {
		Map<Character, SKU> result = new HashMap<>();
		
		SKU sku = new SKU();
		sku.addDeal(new Deal(1, 50));
		sku.addDeal(new Deal(3, 130));
		result.put('A', sku);
		
		sku = new SKU();
		sku.addDeal(new Deal(2, 45));
		sku.addDeal(new Deal(1, 30));
		result.put('B', sku);
		
		return result;
	}
}
