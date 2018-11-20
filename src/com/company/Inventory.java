package com.company;

import java.util.ArrayList;

public class Inventory {
	private ArrayList<Item> items = new ArrayList<Item>();
	
	public void add(Item item) {
		items.add(item);
	}

    public ArrayList<Item> getItems() {
        return items;
    }

    public void remove(Item item) {
		items.remove(item);
	}
	
	public void show() {
		if (items.size() > 0) {
            for (int i = 0; i < items.size(); i++) {
                System.out.print(items.get(i).getDescription());
                if (items.size() == 1) {
                    System.out.println(".");
                } else if (items.size() > (i + 1) ){
                    System.out.print(", ");
                } else if (items.size() == (i + 1) ){
                    System.out.println(".");
                }
            }
        } else if (items.size() == 0) {
			System.out.println("ничего нет.");
		}
	}
	
	public Item itemIsInInventory(String thing) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getName().equals(thing)) {
				return items.get(i);
			}
		}
		return null;
		
	}
}
