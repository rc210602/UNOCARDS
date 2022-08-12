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
public enum CardValue {

    ZERO(0, "Zero"),
    ONE(1, "One"),
    TWO(2, "Two"),
    THREE(3, "Three"),
    FOUR(4, "Four"),
    FIVE(5, "Five"),
    SIX(6, "Six"),
    SEVEN(7, "Seven"),
    EIGHT(8, "Eight"),
    NINE(9, "Nine"),
    SKIP(10, "Skip"),
    REVERSE(11, "Reverse"),
    DRAWTWO(12, "Draw two"),
    DRAWFOUR(13, "Draw four"),
    WILDCARD(14, "Wildcard"),;

    //private variables 
    private int index;
    private String name;

    //An argument constructor for the index and name.
    private CardValue(int index, String name) {

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
    /**
     * 
     * @return String name of the value
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Overridding the toString method for Displaying the output.
    @Override
    public String toString() {
        return String.format("%s", this.name);
    }
    

}