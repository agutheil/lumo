package de.agutheil.lumo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DefaultCartTest {
	private Cart cart;

	@Before
	public void setUp() throws Exception {
		cart = new DefaultCart();
	}

	@Test
	public void testGetArticlesRetrunsEmptySetAfterCreation() {
		assertTrue(cart.getArticles().isEmpty());
	}

	@Test
	public void testAddArticle() {
		Article article = new Article("Heineken");
		cart.addArticle(article);
		assertTrue(cart.getArticles().contains(article));
	}

}
