package assignment9;

import java.util.LinkedList;



public class Snake {

    private static final double SEGMENT_SIZE = 0.02;
    private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
    private LinkedList<BodySegment> segments;
    private double deltaX;
    private double deltaY;
   

    /**
     * Constructs a new Snake, starting with one segment in the center of the canvas.
     */
    public Snake() {
        segments = new LinkedList<>();
        // Initialize the snake with one segment at the center
        segments.add(new BodySegment(0.5, 0.5, SEGMENT_SIZE));
        deltaX = 0;
        deltaY = 0;

        
    }

    /**
     * Changes the direction of the snake's movement.
     * 
     * @param direction The direction to move (1 = up, 2 = down, 3 = left, 4 = right).
     */
    public void changeDirection(int direction) {
        if (direction == 1) { // up
            deltaY = MOVEMENT_SIZE;
            deltaX = 0;
        } else if (direction == 2) { // down
            deltaY = -MOVEMENT_SIZE;
            deltaX = 0;
        } else if (direction == 3) { // left
            deltaY = 0;
            deltaX = -MOVEMENT_SIZE;
        } else if (direction == 4) { // right
            deltaY = 0;
            deltaX = MOVEMENT_SIZE;
        }
    }

    /**
     * Moves the snake by updating the position of each segment based on direction.
     */
    public void move() {
        // Calculate new head position
        double newX = segments.getFirst().getX() + deltaX;
        double newY = segments.getFirst().getY() + deltaY;

        // Add new head segment
        segments.addFirst(new BodySegment(newX, newY, SEGMENT_SIZE));

        // Remove the tail segment
        segments.removeLast();
    }

    /**
     * Draws the snake by drawing each segment.
     */
    public void draw() {
        for (BodySegment segment : segments) {
            segment.draw();
        }
    }

    /**
     * The snake attempts to eat the given food, growing if it does so successfully.
     * 
     * @param f The food to be eaten.
     * @return true if the snake successfully ate the food.
     */
    public boolean eatFood(Food f) {
        double headX = segments.getFirst().getX();
        double headY = segments.getFirst().getY();
        double foodX = f.getX();
        double foodY = f.getY();

        // Check if the head is close enough to the food
        if (Math.abs(headX - foodX) < SEGMENT_SIZE && Math.abs(headY - foodY) < SEGMENT_SIZE) {
            // Grow the snake by adding a new segment at the head's position
            segments.addFirst(new BodySegment(headX, headY, SEGMENT_SIZE));
            return true;
        }
        return false;
    }

    /**
     * Returns true if the head of the snake is within bounds.
     * 
     * @return whether or not the head is in the bounds of the window.
     */
    public boolean isInBounds() {
        double headX = segments.getFirst().getX();
        double headY = segments.getFirst().getY();

        // Check if the head is within the canvas bounds
        return headX >= 0 && headX <= 1 && headY >= 0 && headY <= 1;
    }

    /**
     * Returns the current score.
     * 
     * @return the score.
     */
    public int getScore() {
        return score;
    }
}
