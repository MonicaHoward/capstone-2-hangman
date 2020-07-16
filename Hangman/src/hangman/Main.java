/*
 * Copyright 2015 blondiebytes
 */
package hangman;

import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Classic Hangman "
                + "You have 6 chances to guess the word.");

        
        boolean doYouWantToPlay = true;
        while (doYouWantToPlay) {
            // Setting up the game
            System.out.println();
            Game game = new Game();
            do {
                // Draw the things...
                System.out.println();
                System.out.println(game.drawPicture());
                System.out.println();
                System.out.println(game.getCurrentGuess());
                System.out.print(game.mysteryWord);
                System.out.println();
                
                System.out.println("Guess a letter");
                char guess = (scan.next().toLowerCase()).charAt(0);
                System.out.println();
                
                while (game.alreadyGuessed(guess)) {
                    System.out.println("You've already tried " + guess + ". Try another letter");
                    guess = (scan.next().toLowerCase()).charAt(0);
                }
                
                if (game.playGuess(guess)) {
                    System.out.println("Good guess");
                } else {
                    System.out.println("Incorrect guess");
                }
                
            }
            while (!game.gameOver());
            System.out.println();
            System.out.println("Do you want to play again? Yes (y) / No (any key)");
            Character response = (scan.next().toUpperCase()).charAt(0);
            doYouWantToPlay = (response == 'Y');
            
        }
    }
    
}
