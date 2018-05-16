package com.example.rbn.mobilapplikationsprojekt;

public class Fish {

    private String name;
    private String location;
    private String category;
    private String calories;
    private String cost;
    private String description;

    public Fish (String inName, String inLocation, String inCategory, String inCalories, String inCost, String inDescription) {
        this.name = inName;
        this.location = inLocation;
        this.category = inCategory;
        this.calories = inCalories;
        this.cost = inCost;
        this.description = inDescription;

    }

        public String nameGet() {
            return name;
        }
        public String messageGet() {
            return name + " is located at: " + location  + "\n" + " and has a height of: " + category + "m";
        }


}