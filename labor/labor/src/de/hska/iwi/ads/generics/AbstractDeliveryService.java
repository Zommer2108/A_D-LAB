package de.hska.iwi.ads.generics;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractDeliveryService<T> implements DeliveryService<T> {

  protected Map< Box<T>, Address > stackOfFoodBoxes = new HashMap<>();
  
  public void addBox( Box<T> box, Address address) {
    stackOfFoodBoxes.put(box, address);
  }

}
