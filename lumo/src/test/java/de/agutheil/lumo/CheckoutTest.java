package de.agutheil.lumo;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class CheckoutTest implements DummyCartObserver{
	Checkout checkout;

	@Before
	public void setUp() throws Exception {
		checkout = new DefaultCheckout(new DummyBillFactory());
	}
	
	@Test
	public void thatCheckoutIsInitialized() {
		assertTrue(!checkout.isStarted() && checkout.isInitialized() && !checkout.isBillCreated());
	}

	@Test
	public void thatCheckoutProcessIsStartedWhenCartIsMovedToCheckout() {
		Cart cart = new DummyCart(this);
		checkout.moveCartToCheckout(cart);
		assertTrue(checkout.isStarted() && !checkout.isInitialized() && !checkout.isBillCreated());
	}
	
	@Test(expected = CheckoutStateException.class)
	public void thatCarCannotBeMovedToCheckpoutMoreThanOnce() {
		Cart cart = new DummyCart(this);
		checkout.moveCartToCheckout(cart);
		checkout.moveCartToCheckout(cart);
	}
	
	@Test(expected = CheckoutStateException.class)
	public void thatCreateBillThrowsExceptionWhenCartWasNotAddedBefore(){
		Bill bill = checkout.createBill();
	}
	
	@Test(expected = CheckoutStateException.class)
	public void thatCreateBillThrowsExceptionWhenCalledSeveralTimes(){
		Cart cart = new DummyCart(this);
		checkout.moveCartToCheckout(cart);
		checkout.createBill();
		checkout.createBill();		
	}
	
	@Test
	public void thatBillCanCreatedWhenCheckoutIsStarted(){
		Cart cart = new DummyCart(this);
		checkout.moveCartToCheckout(cart);
		Bill bill = checkout.createBill();
		assertNotNull(bill);
		assertTrue(!checkout.isStarted() && !checkout.isInitialized() && checkout.isBillCreated());
	}
	
	@Test(expected = CheckoutStateException.class)
	public void thatCartCannotBeAddedWhenBillAlreadyCreated() {
		Cart cart = new DummyCart(this);
		checkout.moveCartToCheckout(cart);
		Bill bill = checkout.createBill();
		checkout.moveCartToCheckout(cart);
	}

	@Override
	public void articlesAddedToCart(String articleName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<Article> getArticles() {
		// TODO Auto-generated method stub
		return null;
	}

}
