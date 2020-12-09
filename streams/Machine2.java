// streams/Machine2.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.util.*;
import onjava.Operations;

public class Machine2 {
  public static void main(String[] args) {
    Operations bing = () -> Operations.show("Bing");
    bing.execute();//self-note: 重点!  这是将静态方法重新给接口方法execute引用了!   该接口是函数式接口@FunctionalInterface

    Arrays.stream(new Operations[] {
            bing,
      () -> Operations.show("Crack"),
      () -> Operations.show("Twist"),
      () -> Operations.show("Pop")
    }).forEach(Operations::execute);
  }
}
/* Output:
Bing
Crack
Twist
Pop
*/
