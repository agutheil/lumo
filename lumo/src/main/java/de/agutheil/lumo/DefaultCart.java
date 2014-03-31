package de.agutheil.lumo;

import java.util.HashSet;
import java.util.Set;

public class DefaultCart implements Cart {
	
	private Set<Article> articles;

	public DefaultCart() {
		super();
		articles = new HashSet<>();
	}

	/* (non-Javadoc)
	 * @see de.agutheil.lumo.Cart#getArticles()
	 */
	@Override
	public Set<Article> getArticles() {
		return articles;
	}

	/* (non-Javadoc)
	 * @see de.agutheil.lumo.Cart#addArticle(de.agutheil.lumo.Article)
	 */
	@Override
	public void addArticle(Article article) {
		articles.add(article);
		
	}

}
