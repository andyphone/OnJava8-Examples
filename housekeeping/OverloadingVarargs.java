// housekeeping/OverloadingVarargs.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

public class OverloadingVarargs {
  static void f(Character... args) {
    System.err.print("first");
    for(Character c : args)
      System.err.print(" " + c);
    System.err.println();
  }
  static void f(Integer... args) {
    System.err.print("second");
    for(Integer i : args)
      System.err.print(" " + i);
    System.err.println();
  }
  static void f(Long... args) {
    System.err.println("third");
  }
  public static void main(String[] args) {
    f('a', 'b', 'c');
    f(1);
    f(2, 1);
    f(0);
    f(0L);
    //- f(); // Won't compile -- ambiguous
  }
}
/* Output:
first a b c
second 1
second 2 1
second 0
third
*/
