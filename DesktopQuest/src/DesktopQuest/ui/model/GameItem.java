package DesktopQuest.ui.model;

import java.util.ArrayList;

public class GameItem {

    private String name; //name in the dictionary
    private String title; //the shown name
    private int type;
    private String path;
    private String effect;
    private String description;
    private String[] equiplist;
    private String[] action;

    public static int EQUIPMENT = 0;
    public static int CONSUME = 1;

    public static String HEAD = "Head";
    public static String LEFTHAND = "Left Hand";
    public static String RIGHTHAND = "Right Hand";
    public static String BODY = "Body";
    public static String FEET = "Feet";

    public GameItem(String n) {
        name = n;
        title = n;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String[] getEquiplist() {
        return equiplist;
    }

    public void setEquiplist(String[] equiplist) {
        this.equiplist = equiplist;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String[] getAction() {
        return action;
    }

    public void setAction(String[] action) {
        this.action = action;
    }
}
