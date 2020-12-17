// typeinfo/packageaccess/HiddenC.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package typeinfo.packageaccess;
import typeinfo.interfacea.*;

class C implements A {
  @Override
  public void f() {
    System.err.println("public C.f()");
  }
  public void g() {
    System.err.println("public C.g()");
  }
  void u() {
    System.err.println("package C.u()");
  }
  protected void v() {
    System.err.println("protected C.v()");
  }
  private void w() {
    System.err.println("private C.w()");
  }
}

public class HiddenC {
  public static A makeA() { return new C(); }
}
