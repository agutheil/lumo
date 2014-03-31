package de.agutheil.lumo;

public interface Customer {

	public abstract Cart getCart();

	public abstract void picksCartFromShop();

	public abstract void pickArticleByNameAndAddToCart(String name);

}