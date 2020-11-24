// housekeeping/ArrayInit.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Array initialization
import java.util.*;

public class ArrayInit {
  public static void main(String[] args) {
    Integer[] a = {
      1, 2,
      3, // Autoboxing
    };
    Integer[] b = new Integer[]{
      1, 2,
      3, // Autoboxing
    };
    System.err.println(Arrays.toString(a));
    System.err.println(Arrays.toString(b));
  }
}
/* Output:
[1, 2, 3]
[1, 2, 3]

self-note: 在这两种形式中，初始化列表的最后一个逗号是可选的（这一特性使维护长列表变得更容易）。
尽管第一种形式很有用，但是它更加受限，因为它只能用于数组定义处。
第二种形式可以用在任何地方，甚至用在方法的内部。[参数是在调用处创建的]

*/
