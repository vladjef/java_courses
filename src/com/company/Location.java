package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Location {
    private String name;
    private String description;
    private Inventory inventory = new Inventory();
    private HashMap<Direction, Location> direction;
    private ArrayList<Item> items = new ArrayList<Item>();

    public Location (String name) {
        direction = new HashMap<Direction, Location>();
        this.name = name;
    }

    public ArrayList<Item> getItems() {
        return inventory.getItems();
    }

    public void setMap (Direction direction, Location location) {
        this.direction.put(direction, location);
    }

    public Location getLocation(Direction direct) {
        return direction.get(direct);
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public Item itemIsInLocation(String thing) {

		return inventory.itemIsInInventory(thing);
	}
	
    public String getDescription() {
        return description;
    }

    public void show() {
		System.out.print("Тут есть: ");
		inventory.show();
    }

    public void addToInventory(Item item) {
        inventory.add(item);
    }
	
	public void removeItem(Item item) {
		inventory.remove(item);
	}
}
