// housekeeping/OverloadingVarargs3.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

public class OverloadingVarargs3 {
  static void f(float i, Character... args) {
    System.err.println("first");
  }
  static void f(char c, Character... args) {
    System.err.println("second");
  }
  public static void main(String[] args) {
    f(1, 'a');
    f('a', 'b');
  }
}
/* Output:
first
second
self-note : 给这两个方法都添加一个非可变参数,解决了OverloadingVarargs2 中的 "引用不明确"问题,
然而这也是不好的做法,你应该总是在"重载方法的其中一个版本"上使用可变参数列表，或者压根不用它。
*/
