/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author DELL
 */

import java.util.Scanner;

/**
 * Class that models the main class of the UNO game application
 *
 * @author Rahul,Kiret,Vassu,Chahat, 2022
 */
public class UnoGame {

  public static void main(String[] args) {
    boolean isValid = true;
    boolean valid = true;
    boolean valid2 = true;

    // creating player 1 & player 2 objects
    Player player1 = new Player();
    Player player2 = new Player();

    Scanner sc = new Scanner(System.in);

    // the game object
    Game game = new Game();
    // the groupofcards object
    GroupOfCards deck = new GroupOfCards();

    System.out.println("-----------WELCOME TO UNO Game-----------");

    // displaying the size of the deck
    System.out.println("Size of deck is: " + deck.getSizeOfCardPile());
    deck.shuffle(); // shuffling the deck

    do {
      String playerInput;
      do {
        try {
          System.out.print("Enter Player 1 ID: ");
          playerInput = sc.nextLine();
          player1.setPlayerID(playerInput);
          isValid = false;
        } catch (IllegalArgumentException e) {
          System.out.println(e.getMessage());
          System.out.print("Enter Player 1 ID: ");
          playerInput = sc.nextLine();
        }
      } while (isValid);

      String player2Input;
      do {
        try {
          /**
           * this is the second player
           */
          System.out.print("Enter Player 2 ID: ");
          player2Input = sc.nextLine();
          valid = false;
          player2.setPlayerID(player2Input);
        } catch (IllegalArgumentException e) {
          System.out.println(e.getMessage());
          System.out.print("Enter Player 2 ID: ");
          player2Input = sc.nextLine();
        }
      } while (valid);
      try {
        Player.checkUnique(playerInput, player2Input);
        valid2 = false;
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    } while (valid2);

    /**
     * dealCard for the first player
     */
    deck.dealCard(player1);
    System.out.println(
      "Size of deck after dealing a hand of " +
      "cards to player 1 is: " +
      deck.getSizeOfCardPile()
    );

    /**
     * dealCard for the first player
     */
    deck.dealCard(player2);
    System.out.println(
      "Size of deck after dealing a" +
      " hand of cards to player 2 is: " +
      deck.getSizeOfCardPile()
    );

    System.out.println(
      "Hand of " +
      player1.getPlayerID() +
      " is: " +
      player1.getHandOfCards().size()
    );

    System.out.println(
      "Hand of " +
      player2.getPlayerID() +
      " is: " +
      player2.getHandOfCards().size()
    );

    /**
     * this when the game start
     */
    int currentPlayerIndex = 1;
    Player currentPlayer = player1;
    Card previousCard = null;

    while (
      !player1.getHandOfCards().isEmpty() && !player2.getHandOfCards().isEmpty()
    ) {
        int inputCardIndex = -1;
      while (inputCardIndex == -1) {
        if (currentPlayerIndex == 1) {
          currentPlayer = player1;
        
        } else {
          currentPlayer = player2;
        
        }

        printInHandCards(currentPlayer);

        // What card would you like to play
        System.out.println(
          currentPlayer.toString() +
          ": Enter the card index you would like to play between ? "
        );
        inputCardIndex = -1;
        inputCardIndex = sc.nextInt();
        if (inputCardIndex > currentPlayer.getHandOfCards().size()) {
          System.out.println("Invalid card index .. please try again!");
          inputCardIndex = -1;
          continue;
        }

        // Check if player have any valid card
        if (previousCard != null) {
          Boolean canMove = haveValidCardToMove(currentPlayer, previousCard);
          if (canMove == false) {
            System.out.println(
              "No valid card available for current player, new card picked from deck!!"
            );
            deck.getOneCard(currentPlayer);
            printInHandCards(currentPlayer);

            canMove = haveValidCardToMove(currentPlayer, previousCard);
            if (canMove == true) {
              // System.out.println(currentPlayer.toString() + ": Enter the card index you would like to play between ? ");
              inputCardIndex = -1;
              continue;
            } else {
              System.out.println(
                "You do not have valid card to move, so next player turn!!"
              );
              currentPlayerIndex = nextPlayer(currentPlayerIndex);
              inputCardIndex = -1;
              continue;
            }
          }
        }

        Card selectedCard = currentPlayer
          .getHandOfCards()
          .get(inputCardIndex - 1);
        currentPlayerIndex = nextPlayer(currentPlayerIndex);
        if (previousCard != null) {
          if (
            selectedCard.color.getIndex() == previousCard.color.getIndex() ||
            selectedCard.value.getIndex() == previousCard.value.getIndex()
          ) {
            if (selectedCard.getValue() == CardValue.SKIP) {
            //   currentPlayerIndex = nextPlayer(currentPlayerIndex);
              inputCardIndex = -1;
              continue;
            }
            // currentPlayerIndex = nextPlayer(currentPlayerIndex);
            currentPlayer.getHandOfCards().remove(inputCardIndex - 1);
            previousCard = selectedCard;
          } else {
            System.out.println("Invalid card index .. please try again!");
            inputCardIndex = -1;
            continue;
          }
        } else {
          if (selectedCard.getValue() == CardValue.SKIP) {
            // currentPlayerIndex = nextPlayer(currentPlayerIndex);
            inputCardIndex = -1;
            continue;
          }
        //   currentPlayerIndex = nextPlayer(currentPlayerIndex);
          currentPlayer.getHandOfCards().remove(inputCardIndex - 1);
          previousCard = selectedCard;
        }
        System.out.println("_________________________");
        System.out.println(
          "---------" +
          previousCard.value.toString() +
          " " +
          previousCard.color.toString() +
          "--------"
        );
        System.out.println("_________________________");
      }
    }
    /**
     * declare the winner
     */
    game.declareWinner();
  }

  private static int nextPlayer(int currentPlayerIndex) {
    if (currentPlayerIndex == 1) {
      currentPlayerIndex = 2;
    } else {
      currentPlayerIndex = 1;
    }
    return currentPlayerIndex;
  }

  private static Boolean haveValidCardToMove(
    Player currentPlayer,
    Card previousCard
  ) {
    Boolean canMove = false;
    for (Card card : currentPlayer.getHandOfCards()) {
      if (
        card.color.getIndex() == previousCard.color.getIndex() ||
        card.value.getIndex() == previousCard.value.getIndex()
      ) {
        canMove = true;
      }
    }
    return canMove;
  }

  private static void printInHandCards(Player currentPlayer) {
    // Print the hand of the current player
    System.out.println(currentPlayer.toString() + " availble cards:");
    int cardIndex = 1;
    for (Card card : currentPlayer.getHandOfCards()) {
      System.out.print(cardIndex + ":" + card.toString());
      cardIndex++;
    }
  }
}
