/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author DELL
 * @modified by Rahul,Kiret,Vassu,Chahat, 2022
 */


  //This Enum class is responsible for the colors of the Uno game cards.
 
public enum CardColor {

    RED(0, "Red"),
    YELLOW(1, "Yellow"),
    GREEN(2, "Green"),
    BLUE(3, "Blue"),;
    //data memeber
    private int index;
    private String name;

    //An argument constructor for the index and name.
    private CardColor(int index, String name) {

        this.index = index;
        this.name = name;

    }
    //getters and setters for the index and name.

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param color as a String
     * @return the color of the card
     */
    public static CardColor getEnumColor(String color) {
        for (CardColor c : CardColor.values()) {
            if (c.name.equalsIgnoreCase(color)) {
                return c;
            }
        }
        return null;
    }

    //Overridding the toString method for Displaying the output.
    @Override
    public String toString() {

        return String.format("%s", this.name);
    }

}