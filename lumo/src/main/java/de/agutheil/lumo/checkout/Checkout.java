package de.agutheil.lumo.checkout;

import de.agutheil.lumo.Bill;
import de.agutheil.lumo.Cart;

public interface Checkout {

	void take(Cart cart);

	void validate() throws ValidateCartException, CheckoutNotStartedException;

	boolean cartIsValidated();

	void createBill() throws BillCreationException;

	boolean billIsCreated();

	boolean isStarted();

	Bill getBill();

}
