import java.util.ArrayList;

public interface InventoryMng {
	public void Add(House h);
	public void Edit(int id, double price);
	public int Delete(int id);
	public House[] HousesBelowPrice(double p);
	public int findMin();
	void housesWithSamePrice();
}
