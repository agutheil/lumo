package de.agutheil.lumo;

import java.util.Set;

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
}