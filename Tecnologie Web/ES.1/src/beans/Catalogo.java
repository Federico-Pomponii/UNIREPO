package beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Catalogo {

	private List<Product> products;
	private Map<Long, Cart> carts; // ID_GROUP, Cart

	public Catalogo() {
		super();
		// TODO Auto-generated constructor stub
		// INITIALIZE ITEMS
		products = new ArrayList<Product>();
		carts = new HashMap<Long, Cart>();

		products.add(new Product(1L, "Coca Cola", 3, 1.23));
		products.add(new Product(2L, "Fanta", 4, 1.4));
		products.add(new Product(3L, "Pepsi", 2, 2));
	}

	public List<Product> getProducts() {
		return products;
	}

	public boolean isAvailableForPurchase(long id, int quantity) {
		for (Product p : products)
			if (id == p.getId() && p.getQuantity() > quantity)
				return true;
		return false;
	}

	public Cart getCart(long idGroup) {
		return carts.get(idGroup);
	}

	public Product getProduct(long idProduct) {
		for (Product p : products)
			if (p.getId() == idProduct)
				return p;
		return null;
	}

	public void addProductToCart(long idGroup, long idItem, int quantity) {
		System.out.println(this.getClass().getName() + " add product to cart");
		if (null == carts.get(idGroup))
			carts.put(idGroup, new Cart());

		carts.get(idGroup).addItem(idItem, quantity);
	}

	public synchronized String checkoutCart(long idGroup) {
		try {
			Cart cart = carts.get(idGroup);
			if (null == cart)
				return "Nessun carrello";
			for (long productId : cart.getProducts().keySet())
				if (getProduct(productId).getQuantity() < cart.getProducts().get(productId))
					return "Prodotti non più disponibili";

			for (long productId : cart.getProducts().keySet())
				getProduct(productId).updateQuantity(cart.getProducts().get(productId));

			System.out.println(this.getClass().getName() + " - Checkout completato");
			this.carts.get(idGroup).reset();
			return "Ordine completato";
		} catch (NullPointerException e) {
			// TODO: handle exception
			return "Errore sconosciuto";
		}
	}
}
