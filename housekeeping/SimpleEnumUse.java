// housekeeping/SimpleEnumUse.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

public class SimpleEnumUse {
  public static void main(String[] args) {
    Spiciness howHot = Spiciness.MEDIUM;
    System.err.println(howHot);
  }
}
/* Output:
MEDIUM

self-note ordinal() 方法表示某个特定 enum 常量的声明顺序
*/
