package de.agutheil.lumo.checkout;

import de.agutheil.lumo.Bill;

public interface PaymentProvider {

	Bill pay(Bill bill) throws PaymentException;

}
