package de.agutheil.lumo;

public class DefaultCustomer implements Customer {
	
	private Shop shop;
	
	public DefaultCustomer(Shop shop) {
		super();
		this.shop = shop;
	}

	private Cart cart;
	
	/* (non-Javadoc)
	 * @see de.agutheil.lumo.Customer#getCart()
	 */
	@Override
	public Cart getCart() {
		return cart;
	}

	/* (non-Javadoc)
	 * @see de.agutheil.lumo.Customer#picksCartFromShop()
	 */
	@Override
	public void picksCartFromShop() {
		cart = shop.getNextCart();
	}

	/* (non-Javadoc)
	 * @see de.agutheil.lumo.Customer#pickArticleByNameAndAddToCart(java.lang.String)
	 */
	@Override
	public void pickArticleByNameAndAddToCart(String name) {
		Article article = shop.getArticleByName(name);
		cart.addArticle(article);
		
	}

}
