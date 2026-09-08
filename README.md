# DiceGuessingGame
Contains Java files from a prior Java assignment from COP 2551C - OOP w/Java while attending Florida State College at Jacksonville (FSCJ).

## Author
Ronald Bryant - CEN 3024C - 13711

## Description
This is a small simple GUI application (built with Java Swing) which represents a dice guessing game.

## What it does?
The application lets you guess the outcome of a random 1–6 die roll, ten times per game.
After each roll the matching die face is shown on screen, and the number of attempts for the current game is tracked.
At the end of ten attempts the game is scored as a win (more than 5 correct), a loss (fewer than 5 correct), or a tie (exactly 5 correct).
Running statistics for total games, wins, losses, ties, and their percentages are kept and displayed the whole time.
Unlike a console demo, this program requires you to type a guess and click Roll, and it can be played for as many games as you like until you close the window.

## The Classes
The `DiceGuessingGameApp` class is the entry point. Its `main()` launches the game window.
The `DiceGuessingGameFrame` class is the main window (it extends `JFrame`). It builds the user interface — the guess box, the Roll button, the die face, and the Statistics panel — and runs the game logic each time you roll.
The `Die` class represents a single die. It produces a random value from 1 to 6 and draws the matching die face image (the pips).
The `GameStatistics` class stores the game data. It tracks the attempts and correct guesses in the current game, plus the overall totals for games played, wins, losses, ties, and the win/loss/tie percentages.

## How the application works
The `main()` in `DiceGuessingGameApp` does the following:
Opens the "Dice Guessing Game" window.
Waits for you to enter a guess between 1 and 6 and click Roll (pressing Enter also works).
Rolls the die (a random 1–6) and shows the matching die face.
Records whether your guess was correct and increases the "Attempts This Game" count.
After ten attempts, decides the result — a win for more than 5 correct, a loss for fewer than 5, or a tie for exactly 5 — and shows a message.
Updates the running statistics: games played, wins, losses, ties, and their percentages.
Lets you keep playing more games until you close the window.

## How to compile and run the program
Because all four files use the same package name: `package dice_guessing_game`, ensure they are all stored in the same folder.
You can use any IDE of your choosing (this project is already set up for IntelliJ IDEA). Or you can use the command line terminal by changing the directory to the one that contains the `dice_guessing_game` folder,
then by entering the following bash/shell commands:
`javac dice_guessing_game/DiceGuessingGameApp.java dice_guessing_game/DiceGuessingGameFrame.java dice_guessing_game/Die.java dice_guessing_game/GameStatistics.java` to compile
then
`java dice_guessing_game.DiceGuessingGameApp` to run the Dice Guessing Game application.
(The code uses a newer Java feature, so compile and run with JDK 22 or later — the project is set to Java 24.)

## Expected Output
Because the Dice Guessing Game is a GUI application, its output appears in the game window rather than in the console.
After each roll the die face updates and the "Attempts This Game" count increases. When a game reaches ten attempts, a dialog shows the result — `You won this game!`, `You lost this game.`, or `You tied this game.` — and the Statistics panel updates. Because the rolls are random, the exact numbers will differ each time you play.
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
