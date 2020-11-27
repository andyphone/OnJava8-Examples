// interfaces/AbstractAccess.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

abstract class AbstractAccess {
  private void m1() {}
  // private abstract void m1a(); // illegal   self-note:被禁止了是有意义的，因为你不可能在 AbstractAccess 的任何子类中合法地定义它。
  protected void m2() {}
  protected abstract void m2a();
  void m3() {}
  abstract void m3a();
  public void m4() {}
  public abstract void m4a();
}

//接口只允许 public 方法，如果不加访问修饰符的话，接口的方法不是 friendly 而是 public。
//然而，抽象类允许每件事：(除了private abstract)
