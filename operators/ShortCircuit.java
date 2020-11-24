// operators/ShortCircuit.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Short-circuiting behavior with logical operators

public class ShortCircuit {
  static boolean test1(int val) {
    System.err.println("test1(" + val + ")");
    System.err.println("result: " + (val < 1));
    return val < 1;
  }
  static boolean test2(int val) {
    System.err.println("test2(" + val + ")");
    System.err.println("result: " + (val < 2));
    return val < 2;
  }
  static boolean test3(int val) {
    System.err.println("test3(" + val + ")");
    System.err.println("result: " + (val < 3));
    return val < 3;
  }
  public static void main(String[] args) {
    boolean b = test1(0) && test2(2) && test3(2);
    System.err.println("expression is " + b);
  }
}
/* Output:
test1(0)
result: true
test2(2)
result: false
expression is false
*/
