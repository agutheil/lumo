package de.agutheil.lumo.checkout;

import java.util.Set;

import de.agutheil.lumo.Article;
import de.agutheil.lumo.Cart;

public final class DummyCart implements Cart {
	/**
	 * 
	 */
	private DummyCartObserver observer;

	/**
	 * @param dummyShop
	 */
	DummyCart(DummyCartObserver observer) {
		this.observer = observer;
	}

	@Override
	public Set<Article> getArticles() {
		return observer.getArticles();
	}

	@Override
	public void addArticle(Article article) {
		observer.articlesAddedToCart(article.getName());
		
	}

	@Override
	public boolean isEmpty() {
		return observer.getArticles().isEmpty();
	}
}