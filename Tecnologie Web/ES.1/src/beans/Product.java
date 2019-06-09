package beans;

public class Product {

	private long id;
	private String name;
	private int quantity;
	private double amount;

	public Product(long id, String name, int quantity, double amount) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.amount = amount;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getAmount() {
		return amount;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void updateQuantity(int integer) {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getName() + " - updateQuantity " + integer);
		this.quantity -= integer;
	}

}
