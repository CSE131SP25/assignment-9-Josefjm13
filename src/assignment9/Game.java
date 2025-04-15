package assignment9;

import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import edu.princeton.cs.introcs.StdDraw;

public class Game {

    private Snake snake;
    private Food food;
    private int score; // Score counter
    private Timer scoreTimer; // Timer for score increment

    public Game() {
        StdDraw.enableDoubleBuffering();
        snake = new Snake(); // Snake starts in the center with a body segment size
        food = new Food();   // Creates a new Food object at a random location
        score = 0;           // Initialize the score to 0
        startScoreTimer();   // Start the score increment timer
    }

    /**
     * Starts the game loop.
     */
    public void play() {
        while (snake.isInBounds()) { // Check if the snake is within bounds
            int dir = getKeypress();
            if (dir != -1) {
                snake.changeDirection(dir); // Pass the direction to the snake
            }

            snake.move(); // Move the snake

            if (snake.eatFood(food)) { // Check if the snake eats the food
                food.respawn();        // Create a new food object
            }

            updateDrawing(); // Redraw the screen
        }

        stopScoreTimer(); // Stop the score timer
        System.out.println("Game Over! Final Score: " + score); // Game over message
    }

    /**
     * Handles user input for controlling the snake.
     * 
     * @return An integer representing the direction: 
     *         1 (up), 2 (down), 3 (left), 4 (right), or -1 (no input).
     */
    private int getKeypress() {
        if (StdDraw.isKeyPressed(KeyEvent.VK_W)) {
            return 1; // Up
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
            return 2; // Down
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
            return 3; // Left
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
            return 4; // Right
        } else {
            return -1; // No key pressed
        }
    }

    /**
     * Updates the screen by clearing, drawing the snake and food, showing the score,
     * and refreshing.
     */
    private void updateDrawing() {
        StdDraw.clear();
        snake.draw();    // Draw the snake
        food.draw();     // Draw the food

        // Display the score in the top-left corner
        StdDraw.textLeft(0.05, 0.95, "Score: " + score);

        StdDraw.pause(50); // Pause for smooth animation
        StdDraw.show();    // Show the updated frame
    }

    /**
     * Starts a timer to increment the score every second.
     */
    private void startScoreTimer() {
        scoreTimer = new Timer(true); // Daemon thread to avoid blocking app exit
        scoreTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                score++; // Increment the score
            }
        }, 1000, 1000); // Delay 1 second, repeat every 1 second
    }

    /**
     * Stops the score timer.
     */
    private void stopScoreTimer() {
        if (scoreTimer != null) {
            scoreTimer.cancel();
        }
    }

    /**
     * Entry point for the game.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Game g = new Game();
        g.play();
    }
}
