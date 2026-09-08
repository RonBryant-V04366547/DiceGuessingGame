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

public class GameStatistics {
    // round state
    private int attemptCount = 0;
    private int correctGuessCount = 0;

    // overall aggregates
    private int gameCount = 0;
    private int winCount = 0;
    private int lossCount = 0;
    private int tieCount = 0;
    

    /** Record one guess: whether it was correct or not. */
    public void recordGuess(boolean wasCorrect) {
        attemptCount++;
        if (wasCorrect) correctGuessCount++;
    }

    /** Has the current 10‑guess round finished? */
    public boolean isRoundComplete() {
        return attemptCount >= 10;
    }

    /** Finalize the round, update win/tie/loss, then reset for the next round. */
    public void finalizeRound() {
        gameCount++;
        if (correctGuessCount > 5)      winCount++;
        else if (correctGuessCount < 5) lossCount++;
        else                            tieCount++;  
        // reset for next round
        attemptCount = 0;
        correctGuessCount = 0;
    }

    // getters for UI binding
    public int getAttemptCount()        { return attemptCount; }
    public int getGameCount()           { return gameCount; }
    public int getWinCount()            { return winCount; }
    public int getLossCount()           { return lossCount; }
    public int getTieCount()            { return tieCount; }    
    public double getWinPercentage()    { return pct(winCount); }
    public double getLossPercentage()   { return pct(lossCount); }
    public double getTiePercentage()    { return pct(tieCount); }
    

    private double pct(int part) {
        return (gameCount == 0) ? 0.0 : 100.0 * part / gameCount;
    }
}
