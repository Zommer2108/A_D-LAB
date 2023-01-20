package de.hska.iwi.ads.generics;

import java.util.Map;
import java.util.Set;

/**
 * Abstract data type for a service that
 * delivers specific goods to an address.
 * Each single good is packed into a box.
 * 
 * @param <T> the type of the goods
 */
public interface DeliveryService<T> {

  /**
   * Returns all food boxes with the attached delivery addresses.
   */
   public Map< Box<T>, Address > getFoodBoxes(); 
  
   /**
    * Returns a set of all boxes that have to be delivered
    * to the given address.
    * The delivered boxes are removed from all food boxes.
    */
   public Set< Box<T> > deliver(Address address);
   
   /**
    * adds a new box that has to be delivered to the given address
    */
   public void addBox( Box<T> box, Address address);
   
}
