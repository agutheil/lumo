package de.agutheil.lumo.checkout;

import de.agutheil.lumo.Bill;
import de.agutheil.lumo.Cart;

public class DefaultCheckout implements Checkout {
	private Cart cart;
	private boolean cartValidated;
	private BillFactory billFactory;
	public DefaultCheckout(BillFactory billFactory) {
		super();
		cartValidated = false;
		this.billFactory = billFactory;
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

	@Override
	public Bill createBill() {
		if (!cartValidated){
			throw new BillCreationException();
		}
		return billFactory.createBill(this);
	}

}
