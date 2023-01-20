package de.hska.iwi.ads.interfaces;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public abstract class VectorTest {

  public abstract Vector createVector(double x, double y);
  
  @Test
  void testScale() {
    Vector vector = createVector(1.0, 1.5);
    vector.scale(2.0);
    assertEquals(2.0, vector.getX(), 0.0000001);
    assertEquals(3.0, vector.getY(), 0.0000001);
  }

  @Test
  void testScale1() {
    Vector vector = createVector(1.0, 1.5);
    vector.scale(-1.0);
    assertEquals(-1.0, vector.getX(), 0.0000001);
    assertEquals(-1.5, vector.getY(), 0.0000001);
  }
  
  @Test
  void testScale2() {
    Vector vector = createVector(2.0, -1.5);
    vector.scale(0.0);
    assertEquals(0.0, vector.getX(), 0.0000001);
    assertEquals(0.0, vector.getY(), 0.0000001);
  }
  
  @Test
  void testScale3() {
    Vector vector = createVector(2.0, -1.5);
    vector.scale(0.1);
    assertEquals(0.2, vector.getX(), 0.0000001);
    assertEquals(-0.15, vector.getY(), 0.0000001);
  }
  
  @Test
  void testGetDirection() {
    Vector vector = createVector(23.45, 0.0);
    assertEquals(0.0, vector.getDirection(), 0.0000001);
  }
  
  @Test
  void testGetDirection2() {
    Vector vector = createVector(1.0, 0.0);
    assertEquals(0.0, vector.getDirection(), 0.0000001);
  }
  
  @Test
  void testGetDirection3() {
    Vector vector = createVector(0.0, 2.0);
    assertEquals(Math.PI / 2.0, vector.getDirection(), 0.0000001);
  }
  
  @Test
  void testGetDirection4() {
    Vector vector = createVector(0.0, -2.0);
    assertEquals(-Math.PI / 2.0, vector.getDirection(), 0.0000001);
  }
  
  @Test
  void testGetDirection5() {
    Vector vector = createVector(-23.32, 0);
    assertEquals(Math.PI, vector.getDirection(), 0.0000001);
  }
  
  @Test
  void testGetDirection6() {
    Vector vector = createVector(2.5, 2.5);
    assertEquals(Math.PI / 4.0, vector.getDirection(), 0.0000001);
  }

  @Test
  void testGetDirection7() {
    Vector vector = createVector(-2.0, -2.0);
    assertEquals(- 3.0 / 4.0 * Math.PI, vector.getDirection(), 0.0000001);
  }
}
