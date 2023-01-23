public class House {
	private double price;
	private int id;
	private boolean status;
	
	public House(double p, int id, boolean s) {
		this.price = p;
		this.id = id;
		this.status = s;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public void tostring() {
		System.out.println("House ID: #" + id);
		System.out.println("Price: $" + price);
		String available;
		if (status == false) {
			available = "Not available for Sale";
			System.out.println("Status: " + available);
		} else {
			available = "Available for Sale";
			System.out.println ("Status: " + available);
		}
	}

}
