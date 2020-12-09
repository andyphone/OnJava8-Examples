// streams/Ranges.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import static java.util.stream.IntStream.*;

public class Ranges {
  public static void main(String[] args) {
    //self-note: 左闭右开,1到99之和      //    rangeClosed的话就是1到100了!
    // The traditional way:
    int result = 0;
    for(int i = 1; i < 100; i++)
      result += i;
    System.err.println(result);

    // for-in with a range:
    result = 0;
    for(int i : range(1, 100).toArray())
      result += i;
    System.err.println(result);

    // Use streams:
    System.err.println(rangeClosed(1, 100).sum());
  }
}
/* Output:
145
145
145
*/
