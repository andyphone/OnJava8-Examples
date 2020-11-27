// interfaces/Jim.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.util.*;

interface Jim1 {
  default void jim() {
    System.err.println("Jim1::jim");
  }
}

interface Jim2 {
  default void jim() {
    System.err.println("Jim2::jim");
  }
}

public class Jim implements Jim1, Jim2 {
  @Override
  public void jim() { Jim2.super.jim(); }//self-note: 为了解决多个implements中各个接口的签名相同而导致的命名冲突(返回类型不是方法签名的一部分，因此不能用来区分方法),的问题
  public static void main(String[] args) {
    new Jim().jim();
  }
}
/* Output:
Jim2::jim
*/
