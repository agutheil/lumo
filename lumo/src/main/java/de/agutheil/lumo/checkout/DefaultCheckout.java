package de.agutheil.lumo.checkout;

import de.agutheil.lumo.Bill;
import de.agutheil.lumo.Cart;

public class DefaultCheckout implements Checkout {
	private Cart cart;
	private boolean cartValidated;
	private BillFactory billFactory;
	private Bill bill;
	private boolean billCreated;
	public DefaultCheckout(BillFactory billFactory) {
		super();
		cartValidated = false;
		billCreated = false;
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
	public void createBill() {
		if (!cartValidated){
			throw new BillCreationException();
		}
		bill = billFactory.createBill(this);
		billCreated = true;
	}

	@Override
	public boolean billIsCreated() {
		return billCreated;
	}

}
