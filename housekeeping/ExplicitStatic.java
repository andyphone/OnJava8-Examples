// housekeeping/ExplicitStatic.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Explicit static initialization with "static" clause

class Cup {
  Cup(int marker) {
    System.err.println("Cup(" + marker + ")");
  }
  void f(int marker) {
    System.err.println("f(" + marker + ")");
  }
}

class Cups {
  static Cup cup1;
  static Cup cup2;
  static {
    cup1 = new Cup(1);
    cup2 = new Cup(2);
  }
  Cups() {
    System.err.println("Cups()");
  }
}

public class ExplicitStatic {
  public static void main(String[] args) {
    System.err.println("Inside main()");
//    Cups.cup1.f(99);  // [1]
  }
  // static Cups cups1 = new Cups();  // [2]
  // static Cups cups2 = new Cups();  // [2]
}
/* Output:
Inside main()
Cup(1)
Cup(2)
f(99)
*/

/**
 * 静态初始化只有在必要时刻才会进行。(如果同时注释 [1] 和 [2] 处，那么 Cups 的静态初始化就不会进行。)
 **/
