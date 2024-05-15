package Entity;

public class Cart {
	private int cartID;
    private int accountId;
    private int productId;
    private int amount;
    private double price; // New variable to store product price
    
    public Cart() {
		// TODO Auto-generated constructor stub
	}
    
    
    
	public Cart(int accountId, int productId, int amount) {
		super();
		this.accountId = accountId;
		this.productId = productId;
		this.amount = amount;
	}



	public Cart(int cartID, int accountId, int productId, int amount, double price) {
		super();
		this.cartID = cartID;
		this.accountId = accountId;
		this.productId = productId;
		this.amount = amount;
		this.price = price;
	}

	public int getCartID() {
		return cartID;
	}

	public void setCartID(int cartID) {
		this.cartID = cartID;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

    
    
}
