package de.agutheil.lumo.checkout;

import de.agutheil.lumo.Cart;

public class DummyCartValidator implements CartValidator {
	
	private boolean throwException;
	private boolean valid;

	@Override
	public boolean validate(Cart cart) throws ValidateCartException {
		if(throwException){
			throw new ValidateCartException();
		}
		return valid;
	}

	public boolean isThrowException() {
		return throwException;
	}

	public void setThrowException(boolean throwException) {
		this.throwException = throwException;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

}
