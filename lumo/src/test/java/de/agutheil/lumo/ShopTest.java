package de.agutheil.lumo;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class ShopTest {
	Cart cart;
	Customer customer;
	Shop shop;
	
	@Before
	public void setup(){
		shop = new DefaultShop();
	}
	
	@Test
	public void thatGetNextCartFromShopReturnsACart() {
		Cart cart = shop.getNextCart();
		assertNotNull("Cart should not be null", cart);
	}
	
	@Test
	public void thatShopCreatesNewCartsEachTimeItIsCalled() {
		Cart firstCart = shop.getNextCart();
		Cart secondCart = shop.getNextCart();
		Cart thirdCard = shop.getNextCart();
		assertNotEquals(firstCart, secondCart);
		assertNotEquals(firstCart, thirdCard);
		assertNotEquals(secondCart, thirdCard);
	}
	
	@Test
	public void thatGetArticleByNameReturnsAnArticle() {
		assertNotNull(shop.getArticleByName("Jever"));
	}
	
	@Test
	public void thatGetArticleByNameReturnsSameArticleForSameName() {
		Article previousArticle = shop.getArticleByName("Jever");
		assertEquals(previousArticle, shop.getArticleByName("Jever"));
	}
	
	@Test
	public void thatGetArticleByNameReturnsDifferentArticleDifferentName() {
		Article previousArticle = shop.getArticleByName("Jever");
		assertNotEquals(previousArticle, shop.getArticleByName("Becks"));
	}

}
