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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addArticle(Article article) {
		observer.articlesAddedToCart(article.getName());
		
	}
}