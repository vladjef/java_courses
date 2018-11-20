package com.company;

public class Combo {
    private Item object;
    private Item subject;
    private Item result;
    private String message;

    Item basketWithChainInside = new Item("ведро", "ведро с цепью", Moveable.MOBILE);
    Item basketOnChain = new Item("ведро", "ведро на цепи", Moveable.MOBILE);
    Item basketWithWoter = new Item("ведро", "ведро с водой", Moveable.MOBILE);
    Item crystal = new Item("кристал", "кристал", Moveable.MOBILE);

    public Item createNewObject(Item object, Item subject) {
        if (object.getDescription().equals("пустое ведро") && subject.getDescription().equals("цепь")) {
            return basketWithChainInside;
        } else if (object.getDescription().equals("ведро с цепью") && subject.getDescription().equals("огромная горелка")) {
            return basketOnChain;
        } else if (object.getDescription().equals("ведро на цепи") && subject.getDescription().equals("колодец")) {
            return basketWithWoter;
        } else if (object.getDescription().equals("ведро с водой") && subject.getDescription().equals("кровать")) {
            //System.out.println("Волшебник вскакивает и начинает отряхиваться. Приведя себя в порядок, он благодарит вас за помощь и протягивает вам магический кристалл. Вы выиграли!");
            return crystal;
        }
        return null;
    }
}
