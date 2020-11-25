// housekeeping/VarargType.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

public class VarargType {
  static void f(Character... args) {
    System.err.print(args.getClass());
    System.err.println(" length " + args.length);
  }
  static void g(int... args) {
    System.err.print(args.getClass());
    System.err.println(" length " + args.length);
  }
  public static void main(String[] args) {
    f('a');
    f();
    g(1);
    g();
    System.err.println("int[]: " +
      new int[0].getClass());
  }
}
/* Output:
class [Ljava.lang.Character; length 1
class [Ljava.lang.Character; length 0
class [I length 1
class [I length 0
int[]: class [I

self-note:前导的 "[" 代表这是一个后面紧随的类型的数组，"I" 表示基本类型 int；
*/
