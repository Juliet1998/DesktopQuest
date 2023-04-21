package DesktopQuest.ui.model;

import java.util.ArrayList;
import java.util.List;

public class Events {
    private List<EventItem> EventList;
    private EventItem StartEvent;
    private EventItem FinalEvent;
    private EventItem ShopEvent;

    public Events() {
        EventList = new ArrayList<EventItem>();
        EventItem Event = new EventItem();
        Event.setEventLog("You find a box. It has black snack drawn on it.");
        String[] resultAction = {"HP","-3"};
        Event.addEventAction("Open the box.",Event.new Eventresult("It is full of poisoned snack. You take three damage.",resultAction));
        resultAction = new String[]{"null","null"};
            Event.addEventAction("SNAAAACK!!!",Event.new Eventresult("Nothing happened.\nYou continue on the quest.",resultAction));
        resultAction = new String[]{"EXP","50"};
        Event.addEventAction("Throw your weapon at the box.",Event.new Eventresult("You cracked the box and kill the snack. You gained 50 exp.",resultAction));
        EventList.add(Event);

        Event = new EventItem();
        Event.setEventLog("You find a box. It has Angels drawn on it.");
        resultAction = new String[]{"ITEM","coffee","tea"};
        Event.addEventAction("Open the box.",Event.new Eventresult("You find a item.\nYou put the item into your bag.",resultAction));
        resultAction = new String[]{"null","null"};
        Event.addEventAction("Leave the box.",Event.new Eventresult("Nothing happened.\nYou continue on the quest.",resultAction));
        resultAction = new String[]{"MP","-3"};
        Event.addEventAction("Throw your weapon at the box.",Event.new Eventresult("You destroy the holy box, you lose 3 Magic point for doing that.",resultAction));
        EventList.add(Event);

        Event = new EventItem();
        Event.setEventLog("You reach a room with three chests.\nThe three chests are labeled with sun, moon and star.\n" +
                "There is also a note on the ground saying \"Choose One.\".");
        resultAction = new String[]{"ITEM","coffee","tea", "donut", "donut"};
        Event.addEventAction("Open Sun Chest.",Event.new Eventresult("You find a item.\nYou put the item into your bag.",resultAction));
        resultAction = new String[]{"ITEM","key","check","SSD"};
        Event.addEventAction("Open Moon Chest.",Event.new Eventresult("You find a item.\nYou put the item into your bag.",resultAction));
        resultAction = new String[]{"EQUI","1"};
        Event.addEventAction("Open Star Chest.",Event.new Eventresult("You find an equipment.\nYou put the equipment into your bag.",resultAction));
        EventList.add(Event);

        Event = new EventItem();
        Event.setEventName("java");
        Event.setEventLog("You find a box. It says \"Java\" on it.");
        resultAction = new String[]{"ITEM","java"};
        Event.addEventAction("Open the box.",Event.new Eventresult("You find a \"Coffee\".\nYou put a \"Coffee\" into your bag.",resultAction));
        resultAction = new String[]{"null","null"};
        Event.addEventAction("Leave the box.",Event.new Eventresult("Nothing happened.\nYou continue on the quest.",resultAction));
        resultAction = new String[]{"HP","-10"};
        Event.addEventAction("Throw your weapon at the box.",Event.new Eventresult("You destroy the box.\nYou ruined a box of coffee.\nYou take 10 damage because of shocking.",resultAction));
        EventList.add(Event);


        Event = new EventItem();
        Event.setEventLog("A locked door blocks your way ahead.");
        resultAction = new String[]{"CHECK","key","ITEM","check","SSD"};
        Event.addEventAction("Use a Key.",Event.new Eventresult("You successfully unlock the door with the Key.\nYou also find a item behind the door.\nYou continue on the quest.",resultAction));
        resultAction = new String[]{"MP","-5"};
        Event.addEventAction("Use Magic to break it.(5)",Event.new Eventresult("The magic successfully break the door.\nYou lose 5 magic points.\nYou continue on the quest.",resultAction));
        resultAction = new String[]{"SAVE","STRG", "10", "HP","-6", "GOLD", "50"};
        Event.addEventAction("Force it open.(Strength Save 10+)",Event.new Eventresult("You break the door apart rudely.\nYou find 50 gold from the fragments.\nYou continue on the quest.",resultAction));
        EventList.add(Event);

        Event = new EventItem();
        Event.setEventLog("You entered a chest room.\nSuddenly a huge rock appears over your head.");
        resultAction = new String[]{"SAVE","CONST", "12", "HP","-12", "EQUI","1", "ITEMR", "2"};
        Event.addEventAction("Withstand the shock.(Vitality Save 12+)",Event.new Eventresult("You stand the shock.\nYou approach the chest.\nYou find one equipment and two items in the chest.\nYou continue on the quest.",resultAction));
        resultAction = new String[]{"SAVE","SPEED", "10", "HP","-10", "EQUI","1"};
        Event.addEventAction("Dodge it.(Speed Save 10+)",Event.new Eventresult("You dodge the rock.\nYou approach the chest.\nYou find one equipment in the chest.\nYou continue on the quest.",resultAction));
        resultAction = new String[]{"null","null"};
        Event.addEventAction("Leave the room immediately.",Event.new Eventresult("The rock blocks the way to chest.\nYou gained nothing.\nYou continue on the quest.",resultAction));
        EventList.add(Event);

        initStartEvent();
        initFinalEvent();
        initShopEvent();
    }

    private void initStartEvent() {
        StartEvent = new EventItem();
        StartEvent.setEventLog("Welcome to the Desktop Quest Adventure.\n\nAs your first quest, choose an advantage to start your trial.");
        String[] resultAction = {"EQUI","2"};
        StartEvent.addEventAction("Two Equipments", StartEvent.new Eventresult("You get an equipment.\nYou put it into the bag.",resultAction));
        resultAction = new String[]{"EXP", "51"};
        StartEvent.addEventAction("One Level Up", StartEvent.new Eventresult("Your level increases 1.\nYou are now level 2.",resultAction));
        resultAction = new String[]{"ITEMST", "3"};
        StartEvent.addEventAction("Three Items",StartEvent.new Eventresult("You get three items.\n You put them into the bag.",resultAction));
    }

    private void initFinalEvent() {
        FinalEvent = new EventItem();
        FinalEvent.setEventLog("You reached the last trial of Desktop Quest.\n\nProve yourself to pass this trial.");
        String[] resultAction = {"HP","-30"};
        FinalEvent.addEventAction("Take 30 Damage", FinalEvent.new Eventresult("You survive the last trial.\n\nYou have completed all Desktop Quests.\n Congratulations!",resultAction));
        resultAction = new String[]{"CHECK", "java"};
        FinalEvent.addEventAction("Show the \"Coffee\"", FinalEvent.new Eventresult("You show the real spirit of java.\n\nYou have completed all Desktop Quests.\n Congratulations!",resultAction));
        resultAction = new String[]{"SAVE","CONST", "15", "HP","-99"};
        FinalEvent.addEventAction("Show Vitality.(Vitality Save 15+)",FinalEvent.new Eventresult("You pass the Vitality check.\nThough you know this is actually not a dnd game.\n\nYou have completed all Desktop Quests.\n Congratulations!"
                ,resultAction));
    }

    private void initShopEvent(){
        ShopEvent = new EventItem();
        ShopEvent.setEventLog("\"Welcome to the Desktop Quest Souvenir Shop!\n\nTake a look around, there must be something you really want!\"");
        String[] resultAction = {"BUY","100","win95"};
        ShopEvent.addEventAction("Buy Windows 95 (100 Gold)", ShopEvent.new Eventresult("You paid 100 gold.\n\"Going for the classic ha?\nWish you like it!\"",resultAction));
        resultAction = new String[]{"BUY", "200", "clip"};
        ShopEvent.addEventAction("Buy a Totally Normal Paper Clip (200 Gold)", ShopEvent.new Eventresult("You paid 200 gold.\n\"I promise you'd never regret it.never.\"",resultAction));
        resultAction = new String[]{"null", "null"};
        ShopEvent.addEventAction("Walk Away",ShopEvent.new Eventresult("\"You don't have enough money, am I right?\nCome visit here next time!\"",resultAction));
    }

    public List<EventItem> getEventList() {
        return EventList;
    }

    public EventItem getStartEvent() {
        return StartEvent;
    }

    public EventItem getFinalEvent() {
        return FinalEvent;
    }

    public EventItem getShopEvent() {
        return ShopEvent;
    }
}
