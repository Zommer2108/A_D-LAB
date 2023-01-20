package de.hska.iwi.ads.generics;

/**
 * contains just a single addressline for simplicity
 */
public class Address {

  private String addressline;
  
  /**
   * Creates a new Adress with the given <code>addressline</code>.
   * 
   * @param addressline not null
   */
  public Address(String addressline) {
    assert addressline != null;
    this.addressline = addressline;
  }
  
  /**
   * Two Addresses are equals if their
   * addresslines are equal.
   */
  @Override
  public boolean equals(Object o) {
    Address address = (Address) o;
    
    return addressline.equals(address.addressline);
  }
}
