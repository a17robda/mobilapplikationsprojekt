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
            return name + " is " + description + " that is primarily caught in the " +  location + "."  + "\n" + name + " is of the " + category + " family.";
        }

        public String statsGet() {
            return "Calories / 100g : " + calories + "Kcal" + "\n" + "Price / kg : " + cost + "SEK";
        }


}
