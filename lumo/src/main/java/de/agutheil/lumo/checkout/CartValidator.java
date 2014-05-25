package de.agutheil.lumo.checkout;

import de.agutheil.lumo.Cart;

public interface CartValidator {

	boolean validate(Cart cart) throws ValidateCartException;

}
