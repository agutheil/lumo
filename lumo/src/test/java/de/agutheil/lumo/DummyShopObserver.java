package de.agutheil.lumo;

public interface DummyShopObserver extends DummyCartObserver{

	public abstract void getNextCartWasCalled(boolean wasCalled);

	public abstract void articlesAskedFor(String articleName);

}