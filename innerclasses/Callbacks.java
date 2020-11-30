// innerclasses/Callbacks.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Using inner classes for callbacks
// {java innerclasses.Callbacks}
package innerclasses;

interface Incrementable {
  void increment();
}

// Very simple to just implement the interface:
class Callee1 implements Incrementable {
  private int i = 0;
  @Override
  public void increment() {
    i++;
    System.err.println("callee1: "+i);
  }
}

class MyIncrement {
  public void increment() {
    System.err.println("MyIncrement Other operation");
  }
  static void f(MyIncrement mi) { mi.increment(); }
}

// If your class must implement increment() in
// some other way, you must use an inner class:

/**
 * self-note:
 * Callee2 继承自 MyIncrement，后者已经有了一个不同的 increment() 方法，
 * 并且与 Incrementable 接口期望的 increment() 方法完全不相关。
 * 所以如果 Callee2 继承了 MyIncrement，
 * 就不能为了 Incrementable 的用途而覆盖 increment() 方法，于是只能使用内部类独立地实现 Incrementable，
 * 还要注意，当创建了一个内部类时，并没有在外部类的接口中添加东西，也没有修改外部类的接口。
 */
class Callee2 extends MyIncrement {
  private int i = 0;
  @Override
  public void increment() {
    super.increment();
    i++;
    System.err.println(i);
  }
  private class Closure implements Incrementable {
    @Override
    public void increment() {
      // Specify outer-class method, otherwise
      // you'll get an infinite recursion:
      System.err.print("callbackReference->");
      Callee2.this.increment();
    }
  }
  Incrementable getCallbackReference() {
    return new Closure();//--------------------返回一个内部类对象，这个内部类对象包含了外部类对象的信息
  }
}

class Caller {
  private Incrementable callbackReference;
  Caller(Incrementable cbh) {
    callbackReference = cbh;
  }
  void go() { callbackReference.increment(); }   //这里称为 回调;
                                                 //回调就是在闭包的基础上实现的，返回的内部类对象可以调用外部类中的方法。
                                                 //使用闭包+回调的原因,不能覆盖原来的increment方法,也没有修改外部类的接口。
}

public class Callbacks {
  public static void main(String[] args) {
    Callee1 c1 = new Callee1();
    Caller caller1 = new Caller(c1);
    caller1.go();
    caller1.go();

    System.err.println("s-------------------------------------------");

    Callee2 c2 = new Callee2();
    MyIncrement.f(c2);
    Caller caller2 = new Caller(c2.getCallbackReference());
    caller2.go();
    caller2.go();
  }
}
/* Output:
Other operation
1
1
2
Other operation
2
Other operation
3
*/
