// streams/StreamOfOptionals.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.util.*;
import java.util.stream.*;

public class StreamOfOptionals {
  public static void main(String[] args) {
/*    Signal.stream()
      .limit(10)
      .forEach(System.err::println);
    System.err.println(" ---");*/

    Signal.stream()
      .limit(10)
            .peek(x-> System.err.println("[P]:"+x))
      .filter(Optional::isPresent)
      .map(Optional::get)
      .forEach(System.out::println);
  }
}
/* Output:
Optional[Signal(dash)]
Optional[Signal(dot)]
Optional[Signal(dash)]
Optional.empty
Optional.empty
Optional[Signal(dash)]
Optional.empty
Optional[Signal(dot)]
Optional[Signal(dash)]
Optional[Signal(dash)]
 ---          self-note: 上面的和下面无关, 种子拿取一次之后就延续下去了, 因此取出的随机元素是顺延的
Signal(dot)
Signal(dot)
Signal(dash)
Signal(dash)
*/
