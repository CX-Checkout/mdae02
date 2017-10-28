package befaster.solutions;

import static org.junit.Assert.*;
import org.junit.Test;


public class SKUTest {

	@Test
	public void testSKU(){
		SKU sku = new SKU();
		sku.addDeal(new Deal(3, 130));
		sku.addDeal(new Deal(1, 50));
		
		Bill bill = new Bill("EE");
		
		assertEquals(50, sku.valueOf(1, bill));
		assertEquals(100, sku.valueOf(2, bill));
		assertEquals(130, sku.valueOf(3, bill));
		assertEquals(230, sku.valueOf(5, bill));
	}
	
	@Test
	public void testSKUWithConditions(){
		SKU sku = new SKU();
		
		sku.addDeal(new Deal(1, 0, new Condition(2, 'E')));
		sku.addDeal(new Deal(3, 130));
		sku.addDeal(new Deal(1, 50));
		
		
		Bill bill = new Bill("EE");
		
		assertEquals(0, sku.valueOf(1,bill));
		assertEquals(50, sku.valueOf(2, bill));
		assertEquals(100, sku.valueOf(3, bill));
		assertEquals(230, sku.valueOf(6, bill));
	}
}
