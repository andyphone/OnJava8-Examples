// control/WhileTest.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Demonstrates the while loop

public class WhileTest {
  static boolean condition() {
    boolean result = Math.random() < 0.99;
    System.err.print(result + ", ");
    return result;
  }
  public static void main(String[] args) {
    while(condition())
      System.err.println("Inside 'while'");
    System.err.println("Exited 'while'");
  }
}
/* Output: (First and Last 5 Lines)
true, Inside 'while'
true, Inside 'while'
true, Inside 'while'
true, Inside 'while'
true, Inside 'while'
...________...________...________...________...
true, Inside 'while'
true, Inside 'while'
true, Inside 'while'
true, Inside 'while'
false, Exited 'while'
*/
