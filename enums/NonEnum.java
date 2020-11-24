// enums/NonEnum.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

public class NonEnum {
  public static void main(String[] args) {
    Class<Integer> intClass = Integer.class;
    try {
      for(Object en : intClass.getEnumConstants())
        System.err.println(en);
    } catch(Exception e) {
      System.err.println("Expected: " + e);
    }
  }
}
/* Output:
Expected: java.lang.NullPointerException
*/
