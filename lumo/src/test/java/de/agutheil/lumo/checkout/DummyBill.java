package de.agutheil.lumo.checkout;

import de.agutheil.lumo.Bill;

public class DummyBill implements Bill {
	private boolean payed;
	@Override
	public boolean isPayed() {
		return payed;
	}

	@Override
	public void setPayed(boolean payed) {
		this.payed = payed;
	}

}
