// reuse/FinalOverridingIllusion.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// It only looks like you can override
// a private or private final method

class WithFinals {
  // Identical to "private" alone: 这里 有没有final是一样的
  private final void f() {
    System.err.println("WithFinals.f()");
  }
  // Also automatically "final": self-note:私有方法自动处于final状态
  private void g() {
    System.err.println("WithFinals.g()");
  }
}

class OverridingPrivate extends WithFinals {
  private final void f() {
    System.err.println("OverridingPrivate.f()");
  }
  private void g() {
    System.err.println("OverridingPrivate.g()");
  }
}

class OverridingPrivate2 extends OverridingPrivate {
  public final void f() {
    System.err.println("OverridingPrivate2.f()");
  }//final给方法上锁，防止子类覆写
  public void g() {
    System.err.println("OverridingPrivate2.g()");
  }
}

public class FinalOverridingIllusion {
  public static void main(String[] args) {
    OverridingPrivate2 op2 = new OverridingPrivate2();
    op2.f();
    op2.g();
    // You can upcast:
    OverridingPrivate op = op2; //self-note: 向上转型会导致调用同名方法不明确而无法调用
    // But you can't call the methods:
//     op.f(); 如果一个方法是 private 的，它就不是基类接口的一部分。它只是隐藏在类内部的代码，且恰好有相同的命名而已。
//     op.g();
    // Same here:
    WithFinals wf = op2;
    //- wf.f();
    //- wf.g();
  }
}
/* Output:
OverridingPrivate2.f()
OverridingPrivate2.g()
*/
