package de.agutheil.lumo.checkout;

import de.agutheil.lumo.Bill;
import de.agutheil.lumo.Cart;

public class DefaultCheckout implements Checkout {
	private BillFactory billFactory;
	private CartValidator cartValidator;
	private Bill bill;
	private boolean billCreated;
	private Cart cart;
	private boolean cartValidated;
	private boolean started;
	public DefaultCheckout(BillFactory billFactory, CartValidator cartValidator) {
		super();
		cartValidated = false;
		billCreated = false;
		this.billFactory = billFactory;
		this.cartValidator = cartValidator;
	}

	@Override
	public void take(Cart cart) throws OneCartPerCheckoutException{
		if (started) {
			throw new OneCartPerCheckoutException();
		}
		this.cart = cart;
		started = true;
	}

	@Override
	public void validate() throws ValidateCartException, CheckoutNotStartedException{
		if (!isStarted()) {
			throw new CheckoutNotStartedException();
		}
		cartValidator.validate(cart);
		cartValidated = true;
	}

	@Override
	public boolean cartIsValidated() {
		return cartValidated;
	}

	@Override
	public void createBill() throws BillCreationException{
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

	@Override
	public boolean isStarted() {
		return started;
	}

	@Override
	public Bill getBill() {
		return bill;
	}

}
