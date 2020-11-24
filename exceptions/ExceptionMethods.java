// exceptions/ExceptionMethods.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Demonstrating the Exception Methods

public class ExceptionMethods {
  public static void main(String[] args) {
    try {
      throw new Exception("My Exception");
    } catch(Exception e) {
      System.err.println("Caught Exception");
      System.err.println(
        "getMessage():" + e.getMessage());
      System.err.println("getLocalizedMessage():" +
        e.getLocalizedMessage());
      System.err.println("toString():" + e);
      System.err.println("printStackTrace():");
      e.printStackTrace(System.out);
    }
  }
}
/* Output:
Caught Exception
getMessage():My Exception
getLocalizedMessage():My Exception
toString():java.lang.Exception: My Exception
printStackTrace():
java.lang.Exception: My Exception
        at
ExceptionMethods.main(ExceptionMethods.java:7)
*/
