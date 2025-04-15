package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class BodySegment {
    private double x, y, size;
    private Color color;

    /**
     * Constructor for a BodySegment with a random solid color.
     *
     * @param x     The x-coordinate of the segment.
     * @param y     The y-coordinate of the segment.
     * @param size  The size (diameter) of the segment.
     */
    public BodySegment(double x, double y, double size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = ColorUtils.solidColor(); // Use ColorUtils for a random solid color
    }

    /**
     * Constructor for a BodySegment with a random transparent color.
     *
     * @param x     The x-coordinate of the segment.
     * @param y     The y-coordinate of the segment.
     * @param size  The size (diameter) of the segment.
     * @param transparent Whether the segment color should be transparent.
     */
    public BodySegment(double x, double y, double size, boolean transparent) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = transparent ? ColorUtils.transparentColor() : ColorUtils.solidColor();
    }

    /**
     * Draws the segment using StdDraw.
     */
    public void draw() {
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(x, y, size / 2.0); // Draw as a circle, size/2 for radius
    }

	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}
	public double getY() {
		return y;
	}
	}
