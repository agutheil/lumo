package de.agutheil.lumo;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	Customer customer;
	Shop shop;
	boolean getNextCartWasCalled;
	Set<String> articlesAskedFor;
	Set<String> articlesAddedToCart;

	@Before
	public void setUp() throws Exception {
		articlesAskedFor = new HashSet<String>();
		articlesAddedToCart = new HashSet<String>();
		getNextCartWasCalled = false;
		shop = new Shop() {
			
			@Override
			public Cart getNextCart() {
				getNextCartWasCalled = true;
				return new Cart() {
					
					@Override
					public Set<Article> getArticles() {
						// TODO Auto-generated method stub
						return null;
					}
					
					@Override
					public void addArticle(Article article) {
						articlesAddedToCart.add(article.getName());
						
					}
				};
			}
			
			@Override
			public Article getArticleByName(String name) {
				articlesAskedFor.add(name);
				return new Article(name);
			}
		};
		
		customer = new DefaultCustomer(shop);
	}

	@Test
	public void thatGetCartReturnsNullAfterInitialization() {
		assertNull(customer.getCart());
	}
	
	@Test
	public void thatGetCartReturnsNewCartAfterPickCartFromShopWasCalled() {
		customer.pickCartFromShop();
		assertNotNull(customer.getCart());
		
	}

	@Test
	public void thatPickCartFromShopRequestsACartAtShop() {
		customer.pickCartFromShop();
		assertTrue(getNextCartWasCalled);
	}

	@Test
	public void thatPickArticleByNameAndAddToCartRequestsAnArticleAtShopAndAddsToCart() {
		//prepare
		customer.pickCartFromShop();
		//add Article
		String articleName = "Guiness";
		customer.pickArticleByNameAndAddToCart(articleName);
		//Test
		assertTrue(articlesAskedFor.contains(articleName));
		assertTrue(articlesAddedToCart.contains(articleName));
		
	}

}
