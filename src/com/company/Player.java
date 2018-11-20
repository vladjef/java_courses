package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private Location location;
    private Inventory inventory = new Inventory();
    private ArrayList<Item> items = new ArrayList<Item>();
	boolean isRunning = true;
	private Combo combo = new Combo();
	

	public void start() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println(getLocation().getDescription());
        lookAround();

		while(isRunning) {
            System.out.print("> ");
            String command = scanner.nextLine();

            if (command.contains("смотр")) {
                System.out.println(getLocation().getDescription());
                lookAround();
            } else if (command.contains("взять")) {
                String[] twoWordComand = command.split(" ");
                if (twoWordComand.length == 2) {
                    if (location.itemIsInLocation(twoWordComand[1]) != null && location.itemIsInLocation(twoWordComand[1]).getMoveable() == Moveable.MOBILE) {
                        take(location.itemIsInLocation(twoWordComand[1]));
                        location.removeItem(location.itemIsInLocation(twoWordComand[1]));
                    } else {
                        System.out.println("Вы не можете это взять.");
                    }
                }
            } else if (command.equals("инвентарь")) {
                System.out.print("У Вас есть: ");
                inventory.show();
            } else if (command.contains("идти")) {
                String[] twoWordComand = command.split(" ");
                if (twoWordComand.length == 2) {
                    go(twoWordComand[1]);
                }
            } else if (command.contains("использовать")) {
                String[] twoWordComand = command.split(" ");
                if (twoWordComand.length == 3) {
                    if (location.itemIsInLocation(twoWordComand[2]) != null && inventory.itemIsInInventory(twoWordComand[1]) != null) {
                        use(twoWordComand[1], twoWordComand[2]);
                    }
                }

            } else if (command.equals("выход")) {
                System.out.println("Пока!");
                isRunning = false;
            }
        }
	}

    public void lookAround() {
        location.show();
    }

    public Location getLocation() {
        return location;
    }


    public void take(Item item) {
        inventory.add(item);
        System.out.println("Вы взяли " + item.getDescription());
        if (item.getDescription() == "кристал") {
            isRunning = false;
        }
    }

    public void go(String direction) {

        Direction direct = Direction.valueOf(direction.toUpperCase());
        Location loc = location.getLocation(direct);
        if (loc != null) {
            setLocation(loc);
            System.out.println(getLocation().getDescription());
            lookAround();
        } else {
            System.out.println("Вы не можете туда идти.");
        }
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void use(String object, String subject) {
	    Item objectTochange = new Item ("","",null);
	    Item subjectToChange = new Item ("","",null);

	    for (Item tmp : inventory.getItems()) {
            if (tmp.getName().equals(object)) {
                for (Item temp : location.getItems()) {
                    if (temp.getName().equals(subject)) {
                        objectTochange = tmp;
                        subjectToChange = temp;
                    }
                }
            }
        }
        if (combo.createNewObject(objectTochange, subjectToChange) != null) {
            take(combo.createNewObject(objectTochange, subjectToChange));
            inventory.remove(objectTochange);
            if (subjectToChange.getMoveable() == Moveable.MOBILE) {
                location.removeItem(subjectToChange);
            }
        } else {
            System.out.println("Ничего хорошего из этого не получится.");
        }

    }
}
