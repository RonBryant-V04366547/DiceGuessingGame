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
import java.awt.*;

public class DiceGuessingGameFrame extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Die die = new Die();
    private final GameStatistics statistics = new GameStatistics();

    // UI components with full names
    private final JTextField guessInputField    = new JTextField(2);
    private final JButton    rollButton         = new JButton("Roll");
    private final JLabel     dieFaceLabel       = new JLabel();
    private final JTextField attemptCounterField = new JTextField("0", 3);
    private final JTextField gamesPlayedField   = new JTextField("0", 3);
    private final JTextField winsField          = new JTextField("0", 3);
    private final JTextField lossesField        = new JTextField("0", 3);
    private final JTextField tiesField          = new JTextField("0", 3);    
    private final JTextField winPercentageField = new JTextField("0.0%", 5);
    private final JTextField lossPercentageField = new JTextField("0.0%", 5);
    private final JTextField tiePercentageField = new JTextField("0.0%", 5);
    

    public DiceGuessingGameFrame() {
        super("Dice Guessing Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        pack();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        // prepare die face
        dieFaceLabel.setIcon(die.getFaceIcon(1));

        // top panel: input + button
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Guess (1–6):"));
        topPanel.add(guessInputField);
        topPanel.add(rollButton);

        // stats panel
        JPanel statsPanel = new JPanel(new GridLayout(8,2,5,5));
        statsPanel.setBorder(BorderFactory.createTitledBorder("Statistics"));
        addStat(statsPanel, "Games Played:", gamesPlayedField);
        addStat(statsPanel, "Attempts This Game:", attemptCounterField);
        addStat(statsPanel, "Wins:", winsField);
        addStat(statsPanel, "Losses:", lossesField);
        addStat(statsPanel, "Ties:", tiesField);        
        addStat(statsPanel, "Win %:", winPercentageField);
        addStat(statsPanel, "Loss %:", lossPercentageField);
        addStat(statsPanel, "Tie %:", tiePercentageField);
        

        // read‑only stats fields
        for (Component c : statsPanel.getComponents()) {
            if (c instanceof JTextField) ((JTextField)c).setEditable(false);
        }

        // wire the roll button
        rollButton.addActionListener(_ -> handleRoll());
        // Enter key triggers Roll
        getRootPane().setDefaultButton(rollButton);

        // layout
        Container content = getContentPane();
        content.setLayout(new BorderLayout(10,10));
        content.add(topPanel,      BorderLayout.NORTH);
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerPanel.add(dieFaceLabel);
        content.add(centerPanel, BorderLayout.CENTER);
        content.add(statsPanel,    BorderLayout.SOUTH);
    }

    private void addStat(JPanel panel, String labelText, JTextField field) {
        panel.add(new JLabel(labelText));
        panel.add(field);
    }

    private void handleRoll() {
        String text = guessInputField.getText().trim();
        int guess;
        try {
            guess = Integer.parseInt(text);
            if (guess < 1 || guess > 6) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Please enter a whole number between 1 and 6.",
                "Invalid Guess", JOptionPane.ERROR_MESSAGE);
            focusAndSelectGuessInput();
            return;
        }

        // actually roll
        int result = die.roll();
        dieFaceLabel.setIcon(die.getFaceIcon(result));

        // record that guess
        statistics.recordGuess(guess == result);
        updateAttemptCounter();

        // if round is over, finalize and show dialog
        if (statistics.isRoundComplete()) {
            showRoundResult();
            statistics.finalizeRound();
            resetRoundCounter();
        }

        // always refocus
        focusAndSelectGuessInput();
    }

    private void showRoundResult() {
        String message;
        if      (statistics.getWinCount() + statistics.getLossCount() + statistics.getTieCount() == statistics.getGameCount()) {
            // already counted, so no action
        }
        // Actually show correct one for this last round:
        int correctThisRound = statistics.isRoundComplete() ? statistics.getGameCount() : 0;
        correctThisRound = statistics.getWinCount() + statistics.getLossCount() + statistics.getTieCount() - (statistics.getGameCount() - 1);
        if      (correctThisRound > 5)  message = "You won this game!";
        else if (correctThisRound < 5) message = "You lost this game.";
        else                             message = "You tied this game.";
        JOptionPane.showMessageDialog(this, message, "Game Result", JOptionPane.INFORMATION_MESSAGE);
        updateAggregateStats();
    }

    private void updateAttemptCounter() {
        attemptCounterField.setText(String.valueOf(statistics.getAttemptCount()));
    }

    private void resetRoundCounter() {
        attemptCounterField.setText("0");
    }

    private void updateAggregateStats() {
        gamesPlayedField.setText(String.valueOf(statistics.getGameCount()));
        winsField.setText(String.valueOf(statistics.getWinCount()));
        lossesField.setText(String.valueOf(statistics.getLossCount()));
        tiesField.setText(String.valueOf(statistics.getTieCount()));        
        winPercentageField.setText(String.format("%.1f%%", statistics.getWinPercentage()));
        lossPercentageField.setText(String.format("%.1f%%", statistics.getLossPercentage()));
        tiePercentageField.setText(String.format("%.1f%%", statistics.getTiePercentage()));
        
    }

    private void focusAndSelectGuessInput() {
        guessInputField.requestFocusInWindow();
        guessInputField.selectAll();
    }
}
