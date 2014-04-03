package de.agutheil.lumo;

public interface Checkout {
	
	boolean isInitialized();

	void moveCartToCheckout(Cart cart);

	boolean isStarted();

	Bill createBill();

	boolean isBillCreated();

}
