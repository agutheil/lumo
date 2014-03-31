package de.agutheil.lumo;

public class DefaultShop implements Shop {

	/* (non-Javadoc)
	 * @see de.agutheil.lumo.Shop#getNextCart()
	 */
	@Override
	public Cart getNextCart() {
		return new DefaultCart();
	}

	/* (non-Javadoc)
	 * @see de.agutheil.lumo.Shop#getArticleByName(java.lang.String)
	 */
	@Override
	public Article getArticleByName(String name) {
		return new Article(name);
	}

}
