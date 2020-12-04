// functional/SharedStorage.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.util.function.*;

public class SharedStorage {
  public static void main(String[] args) {
    Closure1 c1 = new Closure1();
    System.err.println(  c1.makeFun(0).getAsInt());
    IntSupplier f2 = c1.makeFun(0);
    IntSupplier f3 = c1.makeFun(0);
//    System.err.println(f1.getAsInt());
    System.err.println(f2.getAsInt());
    System.err.println(f3.getAsInt());
  }
}
/* Output:
0
1
2
*/
