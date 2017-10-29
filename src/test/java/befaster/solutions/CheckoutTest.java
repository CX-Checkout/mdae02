package befaster.solutions;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckoutTest {
	
	@Test
	public void testCheckoutValue(){
		assertEquals(new Integer(0), Checkout.checkout(""));
		assertEquals(new Integer(180+75), Checkout.checkout("AAAABBB"));
		assertEquals(new Integer(180+75+40+30), Checkout.checkout("ACAAADBBCBD"));
		assertEquals(new Integer(380+75+40+30), Checkout.checkout("ACAAADBBCBDAAAAA"));
	}
	
	@Test
	public void testConditions(){
		assertEquals(new Integer(380+45+40+30+80), Checkout.checkout("ACAAEADBBCBDAAEAAA"));
		assertEquals(new Integer(150), Checkout.checkout("RRRQ"));
		assertEquals(new Integer(300), Checkout.checkout("RRRRRRQQ"));
		assertEquals(new Integer(120), Checkout.checkout("NNNM"));
	}
	
	@Test
	public void testIllegalInput(){
		assertEquals(new Integer(-1), Checkout.checkout("a"));
	}
	
	@Test
	public void testGropuDiscount(){
		assertEquals(new Integer(135+17+20), Checkout.checkout("SSTTTXYZYYZ"));
	}

}
