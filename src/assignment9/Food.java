package assignment9;

import java.awt.Color;
import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;

	/**
	 * Creates a new Food at a random location
	 */
	public Food() {
		respawn(); // Initializes the food at a random location
	}

	/**
	 * Draws the Food on the canvas.
	 */
	public void draw() {
		StdDraw.setPenColor(Color.RED); // Set food color
		StdDraw.filledCircle(x, y, FOOD_SIZE); // Draw food as a filled circle
	}

	/**
	 * Respawns the food at a random location on the canvas.
	 */
	public void respawn() {
		Random random = new Random();
		x = random.nextDouble(); // Random x-coordinate between 0.0 and 1.0
		y = random.nextDouble(); // Random y-coordinate between 0.0 and 1.0
	}

	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}
	public double getY() {
		return y;
	}
}