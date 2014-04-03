package de.agutheil.lumo;

import java.util.Set;

public interface DummyCartObserver {

	public abstract void articlesAddedToCart(String articleName);

	public abstract Set<Article> getArticles();

}