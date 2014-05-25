package de.agutheil.lumo.checkout;

import de.agutheil.lumo.Bill;

public class DummyBillFactory implements BillFactory {

	@Override
	public Bill createBill(Checkout checkout) {
		return new Bill() {
		};
	}

}
