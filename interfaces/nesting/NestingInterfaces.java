// interfaces/nesting/NestingInterfaces.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {java interfaces.nesting.NestingInterfaces}
package nesting;

class A {
  interface B {
    void f();
  }
  public class BImp implements B {
    @Override
    public void f() {}
  }
  private class BImp2 implements B {
    @Override
    public void f() {}
  }
  public interface C {
    void f();
  }
  class CImp implements C {
    @Override
    public void f() {}
  }
  private class CImp2 implements C {
    @Override
    public void f() {}
  }
  private interface D {
    void f();
  }
  private class DImp implements D {
    @Override
    public void f() {}
  }
  public class DImp2 implements D {
    @Override
    public void f() {}
  }
  public D getD() { return new DImp2(); }
  private D dRef;
  public void receiveD(D d) {
    dRef = d;
    dRef.f();
  }
}

interface E {
  interface G {
    void f();
  }
  // Redundant "public":
  public interface H {
    void f();
  }
  void g();
  // Cannot be private within an interface:
  //- private interface I {}
}

public class NestingInterfaces {
  public class BImp implements A.B {
    @Override
    public void f() {}
  }
  class CImp implements A.C {
    @Override
    public void f() {}
  }
  // Cannot implement a private interface except
  // within that interface's defining class:
  //- class DImp implements A.D {
  //-  public void f() {}
  //- }
  class EImp implements E {
    @Override
    public void g() {}  //尤其是当实现某个接口(E)时，并不需要实现嵌套在其内部的接口(E.G)。
  }
  class EGImp implements E.G {
    @Override
    public void f() {}
  }
  class EImp2 implements E {
    @Override
    public void g() {}
    class EG implements E.G {
      @Override
      public void f() {}
    }
  }
  public static void main(String[] args) {
    A a = new A();

    //-
//     A.D ad = a.getD(); // Can't access A.D:

    //-
//     A.DImp2 di2 = a.getD(); // Doesn't return anything but A.D:

    //-
//     a.getD().f();  // Cannot access a member of the interface:

    //-
    A a2 = new A(); // Only another A can do anything with getD():
    a2.receiveD(a.getD());

    /**
     * getD()是一个 public 方法却返回了对 private 接口的引用。能对这个返回值做些什么呢？
     * main() 方法里进行了一些使用返回值的尝试但都失败了。返回值必须交给有权使用它的对象，本例中另一个 A 通过 receiveD() 方法接受了它。
     */
  }
}
