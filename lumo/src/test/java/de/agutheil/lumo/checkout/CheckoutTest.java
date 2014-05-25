package de.agutheil.lumo.checkout;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.agutheil.lumo.Cart;

public class CheckoutTest {

	Checkout checkout;
	Cart cart;
	DummyCartValidator cartValidator;
	DummyPaymentProvider paymentProvider;
	
	@Before
	public void setUp() throws Exception {
		cartValidator = new DummyCartValidator();
		paymentProvider = new DummyPaymentProvider();
		checkout = new DefaultCheckout(new DummyBillFactory(), cartValidator, paymentProvider);
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
	
	@Test
	public void thatNoBillWasCreatedWhithoutCallingCreateBill() {
		assertFalse(checkout.billIsCreated());
	}
	
	@Test(expected=CheckoutNotStartedException.class)
	public void thatExceptionIsThrownWhenValidationIsCalledWithoutAddingACart() {
		checkout.validate();
	}
	
	@Test(expected=ValidateCartException.class)
	public void thatExceptionIsThrownWhenCartCannotBeValidated() {
		cartValidator.setThrowException(true);
		checkout.take(cart);
		checkout.validate();
	}
	
	@Test
	public void thatCartIsValidatedByCheckoutForValidCart() {
		cartValidator.setValid(true);
		checkout.take(cart);
		checkout.validate();
		assertTrue(checkout.cartIsValid());
	}

	@Test
	public void thatBillIsCreatedForValidCart() {
		cartValidator.setThrowException(false);
		cartValidator.setValid(true);
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
		cartValidator.setThrowException(true);
		checkout.take(cart);
		try {
			checkout.validate();
		} catch (ValidateCartException e) {
			// We expected this error. 
		}
		checkout.createBill();
	}
	
	@Test
	public void thatBillIsCreatedWhenCreateBillIsCalled() {
		cartValidator.setThrowException(false);
		cartValidator.setValid(true);
		checkout.take(cart);
		checkout.validate();
		checkout.createBill();
		assertTrue(checkout.billIsCreated());
	}
	
	@Test(expected=OneCartPerCheckoutException.class)
	public void thatCheckoutTakesOnlyOneCart() {
		checkout.take(cart);
		checkout.take(cart);
	}
	
	@Test
	public void thatBillIsPayed() {
		cartValidator.setThrowException(false);
		cartValidator.setValid(true);
		paymentProvider.setPayed(true);
		checkout.take(cart);
		checkout.validate();
		checkout.createBill();
		checkout.payBill();
		assertTrue(checkout.billIsPayed());
	}
	
	@Test(expected=NoBillCreatedException.class)
	public void thatExceptionIsThrownWhilePayingWhenNoBillWasCreated() {
		checkout.payBill();
	}
	
	@Test(expected=PaymentException.class)
	public void thatPaymentExceptionIsThrownThroughCheckout() {
		cartValidator.setThrowException(false);
		cartValidator.setValid(true);
		paymentProvider.setThrowException(true);
		checkout.take(cart);
		checkout.validate();
		checkout.createBill();
		checkout.payBill();
	}
	
}
