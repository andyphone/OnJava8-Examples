// exceptions/WhoCalled.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Programmatic access to stack trace information

public class WhoCalled {
  static void f() {
    // Generate an exception to fill in the stack trace
    try {
      throw new Exception();
    } catch(Exception e) {
      for(StackTraceElement ste : e.getStackTrace())
        System.err.println(ste.getMethodName());
    }
  }
  static void g() { f(); }
  static void h() { g(); }
  public static void main(String[] args) {
    f();
    System.err.println("*******");
    g();
    System.err.println("*******");
    h();
  }
}
/* Output:
f
main
*******
f
g
main
*******
f
g
h
main
*/
