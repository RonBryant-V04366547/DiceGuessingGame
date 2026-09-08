# DiceGuessingGame
Contains Java files from a prior Java assignment from COP 2551C - OOP w/Java while attending Florida State College at Jacksonville (FSCJ).

## Author
Ronald Bryant - CEN 3024C - 13711

## Description
This is a simple dice guessing game with a GUI built using Java Swing.

## What it does?
You try to guess what a die will roll, from 1 to 6. You get ten guesses each game. After each roll the app shows the die face that came up. Once you've used all ten guesses, it tells you if you won, lost, or tied. You win if you got more than 5 right, you lose if you got fewer than 5, and you tie if you got exactly 5. It also keeps track of your stats while you play: games played, wins, losses, ties, and the percentage for each. To play, you type a guess and click Roll, and you can keep playing new games until you close the window.

## The Classes
There are four classes. `DiceGuessingGameApp` is where the program starts, and its `main()` opens the game window. `DiceGuessingGameFrame` is the main window (it extends `JFrame`). It builds everything you see (the guess box, the Roll button, the die face, and the stats panel) and runs the game each time you roll. `Die` stands for a single die. It picks a random number from 1 to 6 and draws the die face with the right number of dots. `GameStatistics` holds the game data. It counts your attempts and correct guesses for the current game, plus your overall totals for games, wins, losses, ties, and the percentages.

## How the application works
When you run `DiceGuessingGameApp`, the `main()` opens the Dice Guessing Game window. You type a guess from 1 to 6 and click Roll (you can also press Enter). The app rolls the die, shows the matching die face, and checks if your guess was right. It adds one to your attempts for the game. After ten attempts, it decides if you won, lost, or tied and shows a message. Then it updates your stats: games played, wins, losses, ties, and the percentages. You can keep playing more games until you close the window.

## How to compile and run the program
All four files use the same package, `edu.fscj.cop2551c`, so keep them together in the same folder. This project was set up in IntelliJ, but you can use any IDE of our choosing. Or you can use the command line terminal by changing the directory to same as the Java files, then by entering the following bash/shell commands:
`javac edu/fscj/cop2551c/DiceGuessingGameApp.java edu.fscj.cop2551c/DiceGuessingGameFrame.java edu.fscj.cop2551c/Die.java edu.fscj.cop2551c/GameStatistics.java` to compile
then
`java edu.fscj.cop2551c.DiceGuessingGameApp` to run the Dice Guessing Game application.

## Expected Output
Because the Dice Guessing Game is a GUI application, its output appears in the game window rather than in the console.
After each roll the die face updates and the "Attempts This Game" count increases. When a game reaches ten attempts, a dialog shows the results, `You won this game!`, `You lost this game.`, or `You tied this game.`, and the Statistics panel updates. Because the rolls are random, the exact numbers will differ each time you play.
Here is an example of the Statistics panel after finishing one winning game:
```
Games Played:        1
Attempts This Game:  0
Wins:                1
Losses:              0
Ties:                0
Win %:               100.0%
Loss %:              0.0%
Tie %:               0.0%
```
