// exceptions/AlwaysFinally.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Finally is always executed

class FourException extends Exception {}

public class AlwaysFinally {
  public static void main(String[] args) {
    System.err.println("Entering first try block");
    try {
      System.err.println("Entering second try block");
      try {
        throw new FourException();
      } finally {
        System.err.println("finally in 2nd try block");
      }
    } catch(FourException e) {
      System.err.println(
        "Caught FourException in 1st try block");
    } finally {
      System.err.println("finally in 1st try block");
    }
  }
}
/* Output:
Entering first try block
Entering second try block
finally in 2nd try block
Caught FourException in 1st try block
finally in 1st try block
*/
