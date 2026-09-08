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
import java.awt.image.BufferedImage;
import java.util.Random;

public class Die {
    private static final Random RANDOM = new Random();

    /** Returns a value from 1–6. */
    public int roll() {
        return RANDOM.nextInt(6) + 1;
    }

    /** Returns an ImageIcon for the face showing `value`. */
    public ImageIcon getFaceIcon(int value) {
        return new ImageIcon(drawFaceImage(value));
    }

    /** Draws a 100×100 image of the pip layout for `value`. */
    private Image drawFaceImage(int value) {
        int size = 100, radius = 10, margin = 20;
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        // background & border
        g.setColor(Color.WHITE);
        g.fillRoundRect(0, 0, size, size, 20, 20);
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(2f));
        g.drawRoundRect(0, 0, size - 1, size - 1, 20, 20);

        // compute pip positions
        Point topLeft     = new Point(margin, margin);
        Point topRight    = new Point(size - margin - 2 * radius, margin);
        Point bottomLeft  = new Point(margin, size - margin - 2 * radius);
        Point bottomRight = new Point(size - margin - 2 * radius, size - margin - 2 * radius);
        Point middle      = new Point(size / 2 - radius, size / 2 - radius);
        Point middleLeft  = new Point(margin, size / 2 - radius);
        Point middleRight = new Point(size - margin - 2 * radius, size / 2 - radius);

        // draw pips
        switch (value) {
            case 1:
                drawPip(g, middle, radius);
                break;
            case 2:
                drawPip(g, topLeft, radius);
                drawPip(g, bottomRight, radius);
                break;
            case 3:
                drawPip(g, topLeft, radius);
                drawPip(g, middle, radius);
                drawPip(g, bottomRight, radius);
                break;
            case 4:
                drawPip(g, topLeft, radius);
                drawPip(g, topRight, radius);
                drawPip(g, bottomLeft, radius);
                drawPip(g, bottomRight, radius);
                break;
            case 5:
                drawPip(g, topLeft, radius);
                drawPip(g, topRight, radius);
                drawPip(g, middle, radius);
                drawPip(g, bottomLeft, radius);
                drawPip(g, bottomRight, radius);
                break;
            case 6:
                drawPip(g, topLeft, radius);
                drawPip(g, topRight, radius);
                drawPip(g, middleLeft, radius);
                drawPip(g, middleRight, radius);
                drawPip(g, bottomLeft, radius);
                drawPip(g, bottomRight, radius);
                break;
        }

        g.dispose();
        return image;
    }

    private void drawPip(Graphics2D g, Point center, int radius) {
        g.fillOval(center.x, center.y, radius * 2, radius * 2);
    }
}
