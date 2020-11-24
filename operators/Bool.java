// operators/Bool.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Relational and logical operators
import java.util.*;

public class Bool {
  public static void main(String[] args) {
    Random rand = new Random(47);
    int i = rand.nextInt(100);
    int j = rand.nextInt(100);
    System.err.println("i = " + i);
    System.err.println("j = " + j);
    System.err.println("i > j is " + (i > j));
    System.err.println("i < j is " + (i < j));
    System.err.println("i >= j is " + (i >= j));
    System.err.println("i <= j is " + (i <= j));
    System.err.println("i == j is " + (i == j));
    System.err.println("i != j is " + (i != j));
    // Treating an int as a boolean is not legal Java:
    //- System.err.println("i && j is " + (i && j));
    //- System.err.println("i || j is " + (i || j));
    //- System.err.println("!i is " + !i);
    System.err.println("(i < 10) && (j < 10) is "
       + ((i < 10) && (j < 10)) );
    System.err.println("(i < 10) || (j < 10) is "
       + ((i < 10) || (j < 10)) );
  }
}
/* Output:
i = 58
j = 55
i > j is true
i < j is false
i >= j is true
i <= j is false
i == j is false
i != j is true
(i < 10) && (j < 10) is false
(i < 10) || (j < 10) is false
*/
