package de.agutheil.lumo;

public class BillCreatedState implements CheckoutState {

	@Override
	public boolean isInitialized() {
		return false;
	}

	@Override
	public void moveCartToCheckout(Cart cart) {
		throw new CheckoutStateException();
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
		return true;
	}

}
