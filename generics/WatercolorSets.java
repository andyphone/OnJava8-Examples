// generics/WatercolorSets.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
//import generics.watercolors.*;
import watercolors.Watercolors;

import java.util.*;
import static watercolors.Watercolors.*;

public class WatercolorSets {
  public static void main(String[] args) {
    Set<Watercolors> set1 =
      EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
    Set<Watercolors> set2 =
      EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER);
    System.err.println("set1: " + set1);
    System.err.println("set2: " + set2);
    System.err.println(
      "union(set1, set2): " + Sets.union(set1, set2));
    Set<Watercolors> subset = Sets.intersection(set1, set2);

    System.err.println("intersection(set1, set2)交集: " + subset);
    System.err.println("difference(set1, subset): " +
            Sets.difference(set1, subset));
    System.err.println("difference(set2, subset): " +
            Sets. difference(set2, subset));
    System.err.println("complement(set1, set2): " +
            Sets. complement(set1, set2));
  }
}
/* Output:
set1: [BRILLIANT_RED, CRIMSON, MAGENTA, ROSE_MADDER,
VIOLET, CERULEAN_BLUE_HUE, PHTHALO_BLUE, ULTRAMARINE,
COBALT_BLUE_HUE, PERMANENT_GREEN, VIRIDIAN_HUE]
set2: [CERULEAN_BLUE_HUE, PHTHALO_BLUE, ULTRAMARINE,
COBALT_BLUE_HUE, PERMANENT_GREEN, VIRIDIAN_HUE,
SAP_GREEN, YELLOW_OCHRE, BURNT_SIENNA, RAW_UMBER,
BURNT_UMBER]
union(set1, set2): [BURNT_SIENNA, BRILLIANT_RED,
YELLOW_OCHRE, MAGENTA, SAP_GREEN, CERULEAN_BLUE_HUE,
ULTRAMARINE, VIRIDIAN_HUE, VIOLET, RAW_UMBER,
ROSE_MADDER, PERMANENT_GREEN, BURNT_UMBER,
PHTHALO_BLUE, CRIMSON, COBALT_BLUE_HUE]
intersection(set1, set2): [PERMANENT_GREEN,
CERULEAN_BLUE_HUE, ULTRAMARINE, VIRIDIAN_HUE,
PHTHALO_BLUE, COBALT_BLUE_HUE]
difference(set1, subset): [BRILLIANT_RED, MAGENTA,
VIOLET, CRIMSON, ROSE_MADDER]
difference(set2, subset): [BURNT_SIENNA, YELLOW_OCHRE,
BURNT_UMBER, SAP_GREEN, RAW_UMBER]
complement(set1, set2): [BURNT_SIENNA, BRILLIANT_RED,
YELLOW_OCHRE, MAGENTA, SAP_GREEN, VIOLET, RAW_UMBER,
ROSE_MADDER, BURNT_UMBER, CRIMSON]
*/
