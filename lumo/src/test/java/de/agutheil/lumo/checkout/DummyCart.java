package de.agutheil.lumo.checkout;

import java.util.Set;

import de.agutheil.lumo.Article;
import de.agutheil.lumo.Cart;

public class DummyCart implements Cart {

	@Override
	public Set<Article> getArticles() {
		return null;
	}

	@Override
	public void addArticle(Article article) {
		
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

}
