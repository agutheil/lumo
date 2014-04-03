package de.agutheil.lumo;

public class StartedState implements CheckoutState {
	
	private BillFactory billFactory;
	private Cart cart;

	public StartedState(BillFactory billFactory, Cart cart) {
		super();
		this.billFactory = billFactory;
		this.cart = cart;
	}

	@Override
	public void moveCartToCheckout(Cart cart) {
		throw new CheckoutStateException();
	}

	@Override
	public boolean isStarted() {
		return true;
	}

	@Override
	public Bill createBill() {
		Bill bill = billFactory.createBill(cart);
		return bill;
	}

	@Override
	public boolean isBillCreated() {
		return false;
	}

	@Override
	public boolean isInitialized() {
		return false;
	}

}
