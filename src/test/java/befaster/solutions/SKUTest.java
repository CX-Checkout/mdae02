package befaster.solutions;

import static org.junit.Assert.*;
import org.junit.Test;


public class SKUTest {

	@Test
	public void testSKU(){
		SKU sku = new SKU();
		sku.addDeal(new Deal(1, 50));
		sku.addDeal(new Deal(3, 130));
		assertEquals(50, sku.valueOf(1));
		assertEquals(100, sku.valueOf(2));
		assertEquals(130, sku.valueOf(3));
		assertEquals(230, sku.valueOf(5));
	}
}
