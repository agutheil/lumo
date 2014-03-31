package de.agutheil.lumo;

import java.util.Set;

public interface Cart {

	public abstract Set<Article> getArticles();

	public abstract void addArticle(Article article);

}