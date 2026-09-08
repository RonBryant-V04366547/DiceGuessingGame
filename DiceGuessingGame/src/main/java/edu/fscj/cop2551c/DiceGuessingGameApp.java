// Programmer: Ronald Bryant

// Date: 08/10/2025

/* Purpose:
     * A simple dice guessing game with a GUI using Swing.
	 * The user guesses the outcome of a random 1–6 roll ten times per game.
	 * After each roll the face of the die is shown.
	 * At the end of ten attempts the game is classified as a win if (>5 correct), a loss if (<5 correct) or a tie if (==5).
	 * Stats for total games, attempts per game, wins, ties, losses, and their percentages are shown in text fields.  
	 * Players may continue playing as many games  as they like until closing the app. 
*/

// Course: COP 2551C - Intro to OOP w/ Java (Holbert)

package edu.fscj.cop2551c;

import javax.swing.*;

public class DiceGuessingGameApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DiceGuessingGameFrame().setVisible(true);
        });
    }
}