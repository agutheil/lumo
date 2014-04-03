package de.agutheil.lumo;

public class DefaultCheckout implements Checkout{
	private Cart cart;
	private BillFactory billFactory;
	private CheckoutState checkoutState;	
	public DefaultCheckout(BillFactory billFactory) {
		super();
		this.billFactory = billFactory;
		checkoutState = new InitializedState();
	}

	@Override
	public void moveCartToCheckout(Cart cart) {
		checkoutState.moveCartToCheckout(cart);
		checkoutState = new StartedState(billFactory, cart);
	}

	@Override
	public boolean isStarted() {
		return checkoutState.isStarted();
	}

	@Override
	public Bill createBill() {
	    Bill bill = checkoutState.createBill();
		checkoutState = new BillCreatedState();
		return bill;
	}

	@Override
	public boolean isBillCreated() {
		return checkoutState.isBillCreated();
	}

	@Override
	public boolean isInitialized() {
		return checkoutState.isInitialized();
	}

}
