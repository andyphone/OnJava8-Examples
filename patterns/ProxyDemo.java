// patterns/ProxyDemo.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Simple demonstration of the Proxy pattern

interface ProxyBase {
  void f();
  void g();
  void h();
}

class Proxy implements ProxyBase {
  private ProxyBase implementation;
  Proxy() {
    implementation = new Implementation();
  }
  // Pass method calls to the implementation:
  @Override
  public void f() { implementation.f(); }
  @Override
  public void g() { implementation.g(); }
  @Override
  public void h() { implementation.h(); }
}

class Implementation implements ProxyBase {
  public void f() {
    System.err.println("Implementation.f()");
  }
  public void g() {
    System.err.println("Implementation.g()");
  }
  public void h() {
    System.err.println("Implementation.h()");
  }
}

public class ProxyDemo {
  public static void main(String[] args) {
    Proxy p = new Proxy();
    p.f();
    p.g();
    p.h();
  }
}
/* Output:
Implementation.f()
Implementation.g()
Implementation.h()
*/
