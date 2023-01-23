import java.util.*;
import java.util.Scanner;

import InventoryMng;

import java.util.ArrayList;
public class HouseInventory implements InventoryMng{
	
	private ArrayList <House> myHouses = new ArrayList <>();
	
	public HouseInventory() {}
	
	public ArrayList <House> getHouse(){
		return myHouses;
	}
	public void setList(ArrayList<House> myHouses) {
		this.myHouses = myHouses;
	}
	@Override
	public void Add(House h) {
		myHouses.add(h);
	}

	@Override
	public void Edit(int id, double price) {
		Scanner input = new Scanner(System.in);
		boolean houseFound=false;
		for(int i = 0; i<myHouses.size(); i++){
			if(myHouses.get(i).getId()==id){
				myHouses.get(i).setPrice(price);
				System.out.print("Is the House Available for Sale (Y/N)? ");
				String sale = input.next().toUpperCase();
				//change the input 
				if(sale.equals("Y")) {
					myHouses.get(i).setStatus(true);
				}
				else {
					myHouses.get(i).setStatus(false);
				}
				System.out.println();
				houseFound=true;
				System.out.println();
				System.out.println("Successfully Edited!");
				System.out.println();
				break;
			}
		}
		if(!houseFound) {
			System.out.println();
			System.out.println("House doesn't exist!");
			System.out.println();
		} 
	}
	
	@Override
	public int Delete(int id) {
        for (int i = 0; i < myHouses.size(); i++) {
            if (myHouses.get(i).getId() == id) {
                myHouses.remove(i);
                return 1;
            }
        }
        return 0;
    }

	public House[] HousesBelowPrice(double p) {
		House[] housesBelowPrice=new House[myHouses.size()];
			for (int i =0; i <myHouses.size(); i++) {
				if(myHouses.get(i).getPrice() < p) {
					housesBelowPrice[i]= myHouses.get(i); 
				}
			} 
			if (housesBelowPrice.length == 0) {
				System.out.println("There are currently no houses below the price $" + p);
				System.out.println();
			}
			
		return housesBelowPrice;
	}
	public int findMin() {
		int minHouse = 0;
		for (int i = 0; i<myHouses.size(); i++) {
			if (myHouses.get(i).getPrice() < myHouses.get(minHouse).getPrice()) 
				minHouse = i;
		} if (myHouses.size() == 0) {
			return 0;
		}
		return myHouses.get(minHouse).getId();
	}
	
	@Override
	public void housesWithSamePrice() {
        ArrayList<Integer> duplicateIds = new ArrayList<>();
        for (int i = 0; i < myHouses.size(); i++) {
            for (int j = i + 1; j < myHouses.size(); j++) {
                if (myHouses.get(i).getPrice() == myHouses.get(j).getPrice()) {
                    duplicateIds.add(myHouses.get(i).getId());
                    duplicateIds.add(myHouses.get(j).getId());
                } 
            }
        }
        if (duplicateIds.isEmpty()) {
            System.out.println("The arraylist of houses has zero duplicates.");
        } else {
            System.out.println("Houses with the same price: " + duplicateIds);
        }
    }
}
