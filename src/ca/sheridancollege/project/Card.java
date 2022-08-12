/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the
 * code should remember to add themselves as a modifier. Description Card class
 * creates a Card type that will be used to create a deck of cards
 *
 * @author dancye, 2018
 * @modified by Rahul,Kiret,Vassu,Chahat 2022
 */
public class Card {

    //data memebers 
    CardValue value;
    CardColor color;

    /**
     * no-argument Constructor
     */
    public Card() {
    }

    /**
     * Constructor
     *
     * @param value the value of the card
     * @param color the color of the card
     */
    public Card(CardValue value, CardColor color) {
        this.value = value;
        this.color = color;
    }

    /**
     *
     * @return the value of the card
     */
    public CardValue getValue() {
        return value;
    }

    /**
     *
     * @return the color of the card
     */
    public CardColor getColor() {
        return color;
    }

    /**
     *
     * @param value set the value
     */
    public void setValue(CardValue value) {
        this.value = value;
    }

    /**
     *
     * @param color set the color
     */
    public void setColor(CardColor color) {
        this.color = color;
    }

    /**
     *
     * @return a String representation of the Object
     */
    @Override
    public String toString() {

        return String.format("Card:%s with color: %s \n", value, color);

    }
}