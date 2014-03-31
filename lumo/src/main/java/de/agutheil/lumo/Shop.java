package de.agutheil.lumo;

public interface Shop {

	public abstract Cart getNextCart();

	public abstract Article getArticleByName(String name);

}