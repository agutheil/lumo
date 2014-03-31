package de.agutheil.lumo;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class DomTest {
	Cart cart;
	Customer customer;
	Shop shop;
	
	@Before
	public void setupDom(){
		cart = new DefaultCart();
		shop = new DefaultShop();
		customer = new DefaultCustomer(shop);
	}
	
	@Test
	public void getNextCartFromShop() {
		Cart cart = shop.getNextCart();
		assertNotNull("Cart should not be null", cart);
	}
	
	@Test
	public void thatShopCreatesNewCartsEachTime() {
		Cart firstCart = shop.getNextCart();
		Cart secondCart = shop.getNextCart();
		Cart thirdCard = shop.getNextCart();
		assertNotEquals(firstCart, secondCart);
		assertNotEquals(firstCart, thirdCard);
		assertNotEquals(secondCart, thirdCard);
	}
	
	@Test
	public void thatCustomerPicksACart() {
		customer.picksCartFromShop();
		assertNotNull(customer.getCart());
	}
	
	@Test
	public void thatCustomerAddsArticleToCart() {
		customer.picksCartFromShop();
		customer.pickArticleByNameAndAddToCart("Guiness");
		customer.pickArticleByNameAndAddToCart("Jever");
		customer.pickArticleByNameAndAddToCart("Becks");
		
		Set<Article> articles = customer.getCart().getArticles();
		boolean guiness = articles.contains(new Article("Guiness"));
		boolean jever = articles.contains(new Article("Jever"));
		boolean becks = articles.contains(new Article("Becks"));
		
		assertTrue(guiness && jever && becks);
		
	}

}
