package beans;

import java.util.HashMap;
import java.util.Map;

public class Cart {

	private Map<Long, Integer> products; // LONG is the id of the product and INTEGER the quantity

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
		this.products = new HashMap<Long, Integer>();
	}

	public void addItem(long id, int quantity) {
		System.out.println(this.getClass().getName() + " - addItem " + id + " " + quantity);
		this.products.put(id, quantity);
	}

	public Map<Long, Integer> getProducts() {
		return products;
	}

	public void reset() {
		// TODO Auto-generated method stub
		this.products.clear();
	}

}
