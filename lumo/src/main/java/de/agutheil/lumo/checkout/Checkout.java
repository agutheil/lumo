package de.agutheil.lumo.checkout;

import de.agutheil.lumo.Cart;

public interface Checkout {

	void take(Cart cart) throws OneCartPerCheckoutException;

	void validate() throws ValidateCartException, CheckoutNotStartedException;

	boolean cartIsValid();

	void createBill() throws BillCreationException;

	boolean billIsCreated();

	boolean isStarted();

	void payBill() throws NoBillCreatedException, PaymentException;

	boolean billIsPayed();

}
