// polymorphism/ReferenceCounting.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Cleaning up shared member objects

class Shared {
  private int refcount = 0;
  private static long counter = 0;
  private final long id = counter++;
  Shared() {
    System.err.println("Creating " + this);
  }
  public void addRef() { refcount++; }
  protected void dispose() {
    if(--refcount == 0)
      System.err.println("Disposing " + this);
  }
  @Override
  public String toString() {
    return "Shared " + id;
  }
}

class Composing {
  private Shared shared;
  /**
   * self-note: 一旦某个成员对象(shared)被其它一个或多个对象共享时，问题就变得复杂了，不能只是简单地调用 dispose()。
   * 这里，也许就必须使用引用计数来跟踪仍然访问着共享对象的对象数量
   * 使用这种技巧需要加倍细心，但是如果正在共享的对象需要被清理，你没有太多选择。
   */
  private static long counter = 0;
  private final long id = counter++;
  Composing(Shared shared) {
    System.err.println("Creating " + this);
    this.shared = shared;
    this.shared.addRef();
  }
  protected void dispose() {
    System.err.println("disposing " + this);
    shared.dispose();
  }
  @Override
  public String toString() {
    return "Composing " + id;
  }
}

public class ReferenceCounting {
  public static void main(String[] args) {
    Shared shared = new Shared();
    Composing[] composing = {
      new Composing(shared),
      new Composing(shared),
      new Composing(shared),
      new Composing(shared),
      new Composing(shared)
    };
    for(Composing c : composing)
      c.dispose();
  }
}
/* Output:
Creating Shared 0
Creating Composing 0
Creating Composing 1
Creating Composing 2
Creating Composing 3
Creating Composing 4
disposing Composing 0
disposing Composing 1
disposing Composing 2
disposing Composing 3
disposing Composing 4
Disposing Shared 0
*/
