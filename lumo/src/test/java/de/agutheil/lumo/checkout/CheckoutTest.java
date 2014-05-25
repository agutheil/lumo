package de.agutheil.lumo.checkout;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.agutheil.lumo.Article;
import de.agutheil.lumo.Cart;

public class CheckoutTest {

	Checkout checkout;
	Cart cart;
	DummyCartValidator dummyCartValidator;
	
	@Before
	public void setUp() throws Exception {
		dummyCartValidator = new DummyCartValidator();
		checkout = new DefaultCheckout(new DummyBillFactory(), dummyCartValidator);
		cart = new DummyCart();
	}

	@Test
	public void thatCheckoutStartsByTakingACart() {
		checkout.take(cart);
		assertTrue(checkout.isStarted());
	}
	
	@Test
	public void thatCheckoutIsNotStartedWithoutAddingCart() {
		assertFalse(checkout.isStarted());
	}
	
	@Test(expected=CheckoutNotStartedException.class)
	public void thatExceptionIsThrownWhenValidationIsCalledWithoutAddingACart() {
		checkout.validate();
	}
	
	@Test(expected=ValidateCartException.class)
	public void thatExceptionIsThrownWhenCartCannotBeValidated() {
		dummyCartValidator.setThrowException(true);
		checkout.take(cart);
		checkout.validate();
	}
	
	@Test
	public void thatCartIsValidatedByCheckoutWhenItIsNotEmpty() {
		cart.addArticle(new Article("Test"));
		checkout.take(cart);
		checkout.validate();
		assertTrue(checkout.cartIsValidated());
	}

	@Test
	public void thatBillIsCreatedForValidCart() {
		dummyCartValidator.setThrowException(false);
		dummyCartValidator.setValid(true);
		checkout.take(cart);
		checkout.validate();
		checkout.createBill();
		assertTrue(checkout.billIsCreated());
	}
	
	@Test(expected=BillCreationException.class)
	public void thatBillIsNotCreatedWhenValidationWasntCalled() {
		checkout.take(cart);
		checkout.createBill();
	}
	
	@Test(expected=BillCreationException.class)
	public void thatBillIsNotCreatedWhenNoCartWasAdded() {
		checkout.createBill();
	}
	
	@Test(expected=BillCreationException.class)
	public void thatBillIsNotCreatedWhenCartWasInvalid() {
		dummyCartValidator.setThrowException(true);
		checkout.take(cart);
		try {
			checkout.validate();
		} catch (ValidateCartException e) {
			// We expected this error. 
		}
		checkout.createBill();
	}

	@Test
	public void thatThereIsNoBillWhenNoBillIsCreated(){
		assertNull(checkout.getBill());
	}
	
	@Test
	public void thatBillIsReturnedWhenCreateBillIsCalled() {
		dummyCartValidator.setThrowException(false);
		dummyCartValidator.setValid(true);
		checkout.take(cart);
		checkout.validate();
		checkout.createBill();
		assertNotNull(checkout.getBill());
	}
}
