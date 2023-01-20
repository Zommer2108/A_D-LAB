package de.hska.iwi.ads.solution.interfaces;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * A few simple tests for Circle.
 * 
 * Use {@link Circle#Circle(double)} to create a Circle instance.
 */
class CircleTest {

  /**
   * Create a Circle with a negative radius -10.0.
   * Check with a try-catch-statement 
   * that the constructor throws an IllegalArgumentException.
   */
  @Test
  void testCircleDouble() {
   // fail("Not yet implemented");
	 try { Circle circle = new Circle(-10.0);
	 }
	 catch(IllegalArgumentException iae) {
		 System.out.println("Illegal Argument Exception");
	 }
  }
  
  /*
   * Create a Circle with radius 1.5.
   * Scale it by a factor of 2.0.
   * Check that afterwards the Circle 
   * has a radius near 3.0.
   */
  @Test
  void testScale1() {
   // fail("Not yet implemented");
	  Circle circle2 = new Circle(1.5);
	  circle2.scale(2);
	 
	  assertEquals(3, circle2.getRadius());
  }

  /*
   * Create a Circle with radius 1.0.
   * Check that the area is nearly Math.PI.
   */
  @Test
  void testArea1() {
    fail("Not yet implemented");
  }

  /*
   * Create a Circle with radius 2.0.
   * Check that the area is nearly 4.0 * Math.PI.
   */
  @Test
  void testArea2() {
    fail("Not yet implemented");
  }


  /*
   * Create a Circle with radius 1.0.
   * Check that the radius is near 1.0.
   */
  @Test
  void testGetRadius1() {
    fail("Not yet implemented");
  }

}
