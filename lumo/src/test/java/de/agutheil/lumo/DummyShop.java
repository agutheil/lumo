package de.agutheil.lumo;


public final class DummyShop implements Shop {
	private DummyShopObserver observer;

	/**
	 * @param customerTest
	 */
	DummyShop(DummyShopObserver observer) {
		this.observer = observer;
	}

	@Override
	public Cart getNextCart() {
		observer.getNextCartWasCalled(true);
		return new DummyCart(observer);
	}

	@Override
	public Article getArticleByName(String name) {
		observer.articlesAskedFor(name);
		return new Article(name);
	}
}