// strings/ScannerDelimiter.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.util.*;

public class ScannerDelimiter {
  public static void main(String[] args) {
    Scanner scanner = new Scanner("12, 42, 78, 99, 42");
    scanner.useDelimiter("\\s*,\\s*");
    System.err.println(scanner.delimiter());//返回当前正在作为分隔符使用的 `Pattern` 对象
    while(scanner.hasNextInt())
      System.err.println(scanner.nextInt());
  }
}
/* Output:
12
42
78
99
42
*/
