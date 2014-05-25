package de.agutheil.lumo.checkout;

import de.agutheil.lumo.Bill;
import de.agutheil.lumo.Cart;

public class DefaultCheckout implements Checkout {
	private BillFactory billFactory;
	private CartValidator cartValidator;
	private PaymentProvider paymentProvider;
	private Bill bill;
	private Cart cart;
	private boolean cartValid;
	private boolean started;
	public DefaultCheckout(BillFactory billFactory, CartValidator cartValidator, PaymentProvider paymentProvider) {
		super();
		cartValid = false;
		this.billFactory = billFactory;
		this.cartValidator = cartValidator;
		this.paymentProvider = paymentProvider;
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
		cartValid = cartValidator.validate(cart);
	}

	@Override
	public boolean cartIsValid() {
		return cartValid;
	}

	@Override
	public void createBill() throws BillCreationException{
		if (!cartValid){
			throw new BillCreationException();
		}
		bill = billFactory.createBill(this);
	}

	@Override
	public boolean billIsCreated() {
		return bill != null;
	}

	@Override
	public boolean isStarted() {
		return started;
	}

	@Override
	public void payBill() throws NoBillCreatedException, PaymentException {
		if (bill == null) {
			throw new NoBillCreatedException();
		}
		bill = paymentProvider.pay(bill);
	}

	@Override
	public boolean billIsPayed() {
		return bill.isPayed();
	}

}
