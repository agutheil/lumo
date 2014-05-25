package de.agutheil.lumo.checkout;

import de.agutheil.lumo.Bill;

public class DummyPaymentProvider implements PaymentProvider {
	private boolean throwException;
	private boolean payed;

	@Override
	public Bill pay(Bill bill) {
		if (throwException) {
			throw new PaymentException();
		}
		bill.setPayed(payed);
		return bill;

	}

	public void setThrowException(boolean throwException) {
		this.throwException = throwException;
	}

	public void setPayed(boolean payed) {
		this.payed = payed;
	}

}
