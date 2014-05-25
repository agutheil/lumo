package de.agutheil.lumo.checkout;

import de.agutheil.lumo.Bill;
import de.agutheil.lumo.Cart;

public interface Checkout {

	void take(Cart cart);

	Cart currentCart();

	void validate();

	boolean cartIsValidated();

	void createBill();

	boolean billIsCreated();

}
