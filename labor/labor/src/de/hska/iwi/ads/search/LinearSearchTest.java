package de.hska.iwi.ads.search;

public class LinearSearchTest extends SearchTest {

  @Override
  public <E extends Comparable<E>> Search<E> createSearch() {
    return new LinearSearch<>();
  }

}
