package de.agutheil.lumo;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest implements DummyShopObserver{
	private Customer customer;
	private Shop shop;
	public Set<String> articlesAskedFor;
	public Set<String> articlesAddedToCart;
	public boolean getNextCartWasCalled;

	@Before
	public void setUp() throws Exception {
		articlesAskedFor = new HashSet<String>();
		articlesAddedToCart = new HashSet<String>();
		getNextCartWasCalled = false;
		shop = new DummyShop(this);
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

	@Override
	public void getNextCartWasCalled(boolean wasCalled){
		getNextCartWasCalled = wasCalled;
	}

	@Override
	public void articlesAskedFor(String articleName){
		articlesAskedFor.add(articleName);
	}
	
	@Override
	public void articlesAddedToCart(String articleName){
		articlesAddedToCart.add(articleName);
	}
}
