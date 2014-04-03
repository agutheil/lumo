package de.agutheil.lumo;

public interface Customer {

	public abstract Cart getCart();

	public abstract void pickCartFromShop();

	public abstract void pickArticleByNameAndAddToCart(String name);
	
	public abstract void proceedToCheckOut();

}