package de.hska.iwi.ads.interfaces;

/**
 * A Circle in two-dimensional-euclidian space
 * with a middle point and a positive radius.
 */
public abstract class AbstractCircle implements Scaleable, Shape {

  protected Vector middlePoint;

  protected double radius;
  
  /**
   * Creates an AbstractCircle with (0,0) as the middle point.
   * 
   * @param radius  radius > 0
   * @throws IllegalArgumentException if radius is zero or negativ
   */
  public AbstractCircle(double radius) {
    this(null, radius);
  }
  
  /**
   * Creates an AbstractCircle with the given <code>radius</code>
   * and <code>middlePoint</code>. If the middlePoint is null, then
   * it is treated as (0,0).
   *
   * @param middlePoint  represents the middle point of the circle
   * @param radius  radius > 0
   * @throws IllegalArgumentException if radius is zero or negativ
   */
  public AbstractCircle(Vector middlePoint, double radius) {
    if (radius <= 0.0) {
      throw new IllegalArgumentException("negative radius not allowed: " + radius);
    }
    this.middlePoint = middlePoint;
    this.radius = radius;
  }
  
  /**
   * Returns the middle point of this AbstractCircle.
   * null represents (0,0)
   */
  public Vector getMiddlePoint() {
    return middlePoint;
  }
  
  /**
   * Returns the positive radius.
   */
  public double getRadius() {
    return radius;
  }
  
  /**
   * Moves the middle point in the given direction.
   * If direction is null then it is treated as (0,0).
   */
  public void move(Vector direction) {
    if (direction != null) {
      middlePoint = direction.add(middlePoint);
    }
  }
  
}
