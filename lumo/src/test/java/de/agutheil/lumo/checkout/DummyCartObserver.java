package de.agutheil.lumo.checkout;

import java.util.Set;

import de.agutheil.lumo.Article;

public interface DummyCartObserver {

	public abstract void articlesAddedToCart(String articleName);

	public abstract Set<Article> getArticles();

}