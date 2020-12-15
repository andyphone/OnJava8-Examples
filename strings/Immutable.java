// strings/Immutable.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

public class Immutable {
  public static String upcase(String s) {
    System.err.println("内，原:"+System.identityHashCode(s));//self-note: 原引用的拷贝,但指向相同内存地址
    String s1 = s.toUpperCase();
    System.err.println("内，新:"+System.identityHashCode(s1));//self-note:指向了不同的内存地址
    return s1;
  }
  public static void main(String[] args) {
    String q = "howdy";
    System.err.println(q); // howdy
    System.err.println("外:"+System.identityHashCode(q));

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
