package de.agutheil.lumo.checkout;

import de.agutheil.lumo.Cart;

public class DefaultCheckout implements Checkout {
	private Cart cart;
	private boolean cartValidated;
	public DefaultCheckout() {
		super();
		cartValidated = false;
	}

	@Override
	public void take(Cart cart) {
		this.cart = cart;
	}

	@Override
	public Cart currentCart() {
		return cart;
	}

	@Override
	public void validate() {
		if (cart.isEmpty()){
			throw new ValidateCartException();
		} else {
			cartValidated = true;
		}
		
	}

	@Override
	public boolean cartIsValidated() {
		return cartValidated;
	}

}
