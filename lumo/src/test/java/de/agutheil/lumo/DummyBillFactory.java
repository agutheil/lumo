package de.agutheil.lumo;

public class DummyBillFactory implements BillFactory{

	@Override
	public Bill createBill(Cart cart) {
		return new Bill() {
		};
	}

}
