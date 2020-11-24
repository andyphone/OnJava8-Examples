// references/Stringer.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

public class Stringer {
  public static String upcase(String s) {
    return s.toUpperCase();
  }
  public static void main(String[] args) {
    String q = new String("howdy");
    System.err.println(q); // howdy
    String qq = upcase(q);
    System.err.println(qq); // HOWDY
    System.err.println(q); // howdy
  }
}
/* Output:
howdy
HOWDY
howdy
*/
