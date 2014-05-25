package de.agutheil.lumo.checkout;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import de.agutheil.lumo.Article;
import de.agutheil.lumo.Cart;

public class CheckoutTest implements DummyCartObserver{

	Checkout checkout;
	Cart cart;
	Set<Article> articles;
	
	@Before
	public void setUp() throws Exception {
		checkout = new DefaultCheckout();
		articles = new HashSet<Article>();
	}

	@Test
	public void thatCheckoutTakesCart() {
		cart = new DummyCart(this);
		checkout.take(cart);
		assertEquals(cart, checkout.currentCart());
	}
	
	@Test(expected=ValidateCartException.class)
	public void thatCartIsNotValidatedByCheckoutWhenEmpty() {
		cart = new DummyCart(this);
		checkout.take(cart);
		checkout.validate();
	}
	
	@Test
	public void thatCartIsValidatedByCheckoutWhenItIsNotEmpty() {
		cart = new DummyCart(this);
		cart.addArticle(new Article("Test"));
		checkout.take(cart);
		checkout.validate();
		assertTrue(checkout.cartIsValidated());
	}

	@Override
	public void articlesAddedToCart(Article article) {
		articles.add(article);
		
	}

	@Override
	public Set<Article> getArticles() {
		return articles;
	}

}
