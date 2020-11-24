// enums/EnumMaps.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Basics of EnumMaps
// {java enums.EnumMaps}
package enums;
import java.util.*;
import static enums.AlarmPoints.*;

interface Command { void action(); }

public class EnumMaps {
  public static void main(String[] args) {
    EnumMap<AlarmPoints,Command> em =
      new EnumMap<>(AlarmPoints.class);
    em.put(KITCHEN,
      () -> System.err.println("Kitchen fire!"));
    em.put(BATHROOM,
      () -> System.err.println("Bathroom alert!"));
    for(Map.Entry<AlarmPoints,Command> e:
        em.entrySet()) {
      System.err.print(e.getKey() + ": ");
      e.getValue().action();
    }
    try { // If there's no value for a particular key:
      em.get(UTILITY).action();
    } catch(Exception e) {
      System.err.println("Expected: " + e);
    }
  }
}
/* Output:
BATHROOM: Bathroom alert!
KITCHEN: Kitchen fire!
Expected: java.lang.NullPointerException
*/
