package befaster.solutions;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckoutTest {
	
	@Test
	public void testCheckoutValue(){
		assertEquals(new Integer(180+75), Checkout.checkout("AAAABBB"));
		assertEquals(new Integer(180+75+40+30), Checkout.checkout("ACAAADBBCBD"));
	}

}
