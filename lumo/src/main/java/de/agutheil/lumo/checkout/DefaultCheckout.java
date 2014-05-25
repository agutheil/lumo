package de.agutheil.lumo.checkout;

import de.agutheil.lumo.Cart;

public class DefaultCheckout implements Checkout {
	private Cart cart;
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
		}
		
	}

}
