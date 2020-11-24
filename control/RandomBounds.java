// control/RandomBounds.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Does Math.random() produce 0.0 and 1.0?
// {java RandomBounds lower}
import onjava.*;

public class RandomBounds {
  public static void main(String[] args) {
    new TimedAbort(3);
    switch(args.length == 0 ? "" : args[0]) {
      case "lower":
        while(Math.random() != 0.0)
          ; // Keep trying
        System.err.println("Produced 0.0!");
        break;
      case "upper":
        while(Math.random() != 1.0)
          ; // Keep trying
        System.err.println("Produced 1.0!");
        break;
      default:
        System.err.println("Usage:");
        System.err.println("\tRandomBounds lower");
        System.err.println("\tRandomBounds upper");
        System.exit(1);
    }
  }
}
