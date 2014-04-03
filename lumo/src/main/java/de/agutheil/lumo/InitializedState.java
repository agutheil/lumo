package de.agutheil.lumo;

public class InitializedState implements CheckoutState {
	private Cart cart;
	@Override
	public void moveCartToCheckout(Cart cart) {
		this.cart = cart;
	}

	@Override
	public boolean isStarted() {
		return false;
	}

	@Override
	public Bill createBill() {
		throw new CheckoutStateException();
	}

	@Override
	public boolean isBillCreated() {
		return false;
	}

	@Override
	public boolean isInitialized() {
		return true;
	}

}
