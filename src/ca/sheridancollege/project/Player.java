/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 * @author dancye, 2018
 * // @modified by Rahul, Kiret, Vassu, Chahat, 2022
 */
import java.util.ArrayList;
import java.util.List;
 
public class Player {

    private String playerID; //the unique ID for this player
    private List<Card> hand;

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * 
     */
    public Player(String name) {
        playerID = name;
    }

    /**
     * no argument Constructor
     */
    public Player() {
        this.hand = new ArrayList<Card>();
    }

    /**
     *
     * @return a hand of card as List
     */
    public List<Card> getHandOfCards() {
        return hand;
    }

    /**
     * @return the playerID
     */
    public String getPlayerID() {
        return playerID;
    }

    
    public static boolean checkId(String name) {
        if(name.length() >= 3) {
            return true;
        }
        return false;
    }

    
    public static boolean checkChar(String name) {
        for (int i = 0; i < name.length(); i++) {
            int ch = name.charAt(i);
            if (!Character.isLetterOrDigit(ch)) {
                return true;
            }
        }
        return false;
    }

    
    public static boolean checkUnique(String player1, String player2) {

        if (player1.equals(player2)) {
            throw new IllegalArgumentException("Error, Enter unique user Id");
        }

        return true;
    }

    
     
    public void setPlayerID(String givenID) {
        if (checkId(givenID)
                && checkChar(givenID)) {

            this.playerID = givenID;

        } else {
            throw new IllegalArgumentException("Wrong value, please try again!");
        }
    }

    /**
     *
     * @return a String representation of the Player
     */
    @Override
    public String toString() {
        return String.format("Player: %s", this.playerID);
    }
}