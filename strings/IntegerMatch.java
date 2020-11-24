// strings/IntegerMatch.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

public class IntegerMatch {
  public static void main(String[] args) {
    System.err.println("-1234".matches("-?\\d+"));
    System.err.println("5678".matches("-?\\d+"));
    System.err.println("+911".matches("-?\\d+"));
    System.err.println("+911".matches("(-|\\+)?\\d+"));
  }
}
/* Output:
true
true
false
true
*/
