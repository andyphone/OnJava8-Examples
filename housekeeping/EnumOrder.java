// housekeeping/EnumOrder.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

public class EnumOrder {
  public static void main(String[] args) {
    for(Spiciness s : Spiciness.values())
      System.err.println(
        s + ", ordinal " + s.ordinal());
  }
}
/* Output:
NOT, ordinal 0
MILD, ordinal 1
MEDIUM, ordinal 2
HOT, ordinal 3
FLAMING, ordinal 4
self-note:
ordinal() 方法表示某个特定 enum 常量的声明顺序，
static values() 方法按照 enum 常量的声明顺序，生成这些常量值构成的数组
*/
