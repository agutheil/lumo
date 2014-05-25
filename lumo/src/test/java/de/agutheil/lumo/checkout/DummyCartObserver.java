package de.agutheil.lumo.checkout;

import java.util.Set;

import de.agutheil.lumo.Article;

public interface DummyCartObserver {

	public abstract void articlesAddedToCart(Article article);

	public abstract Set<Article> getArticles();

}