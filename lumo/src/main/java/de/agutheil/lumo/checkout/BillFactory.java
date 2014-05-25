package de.agutheil.lumo.checkout;

import de.agutheil.lumo.Bill;

public interface BillFactory {

	Bill createBill(Checkout checkout);

}
