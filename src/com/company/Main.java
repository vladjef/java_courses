package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Location garden = new Location("Garden");
        garden.setDescription("Вы в прекрасном саду.\n" +
                "Прямо по курсу находится колодец.\n" +
                "На востоке дверь в дом.");

        Location livingRoom = new Location("LivingRoom");
        livingRoom.setDescription("Вы находитесь в гостиной в доме волшебника.\n" +
                "А вот и он сам громко храпит на кровати.\n" +
                "На западе от вас есть дверь, рядом лестница наверх.");

        Location attic = new Location("Attic");
        attic.setDescription("Вы на чердаке старого дома.\n" +
                "В углу видна гигантская горелка.\n" +
                "Вниз ведет лестница.");

		livingRoom.setMap(Direction.НАВЕРХ, attic);
        livingRoom.setMap(Direction.ВОСТОК, garden);
		garden.setMap(Direction.ЗАПАД, livingRoom);
		attic.setMap(Direction.ВНИЗ, livingRoom);


        Item whiskey = new Item("виски", "бутылка виски", Moveable.MOBILE);
        Item basket = new Item("ведро", "пустое ведро", Moveable.MOBILE);

        Item frog = new Item("лягушка", "лягушка", Moveable.MOBILE);
        Item chain = new Item("цепь", "цепь", Moveable.MOBILE);
        Item well = new Item("колодец", "колодец", Moveable.STATIONARY);
        Item burner = new Item("горелка", "огромная горелка", Moveable.STATIONARY);
        Item bad = new Item("кровать", "кровать", Moveable.STATIONARY);
        
		livingRoom.addToInventory(whiskey);
		livingRoom.addToInventory(basket);
		livingRoom.addToInventory(bad);
		attic.addToInventory(burner);
		garden.addToInventory(well);
		garden.addToInventory(frog);
		garden.addToInventory(chain);

        Player player = new Player();
        player.setLocation(livingRoom);
		
		player.start();
        
    }
}
