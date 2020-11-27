// polymorphism/PolyConstructors.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Constructors and polymorphism
// don't produce what you might expect

class Glyph {
  void draw() { System.err.println("Glyph.draw()"); }
  Glyph() {
    System.err.println("Glyph() before draw()");
    draw();
    System.err.println("Glyph() after draw()");
  }
}

class RoundGlyph extends Glyph {
  private int radius = 1;
  RoundGlyph(int r) {
    radius = r;
    System.err.println(
      "RoundGlyph.RoundGlyph(), radius = " + radius);
  }
  @Override
  void draw() {
    System.err.println(
      "RoundGlyph.draw(), radius = " + radius);
  }
}

public class PolyConstructors {
  public static void main(String[] args) {
    new RoundGlyph(5);
  }
}
/* Output:
Glyph() before draw()
RoundGlyph.draw(), radius = 0
Glyph() after draw()
RoundGlyph.RoundGlyph(), radius = 5

self-note:
父类--静态变量
父类--静态初始化块
子类--静态变量
子类--静态初始化块
************* main start ***************
父类--变量
父类--初始化块
父类--构造器   当 Glyph 构造器调用了 draw() 时，radius 的值不是默认初始值 1 而是 0。
子类--变量
子类--初始化块
子类--构造器
************* 第二次创建不会加载父类 *************
父类--变量
父类--初始化块
父类--构造器
子类--变量
子类--初始化块
子类--构造器
************* main end ***************


初始化的实际过程是：

  1.在所有事发生前，分配给对象的存储空间会被初始化为二进制 0。
  2.如前所述调用基类构造器。此时调用重写后的 draw() 方法（是的，在调用 RoundGraph 构造器之前调用），
  由步骤 1 可知，radius 的值为 0。
  3.按声明顺序初始化成员。
  4.最终调用派生类的构造器。

 编写构造器有一条良好规范: 在基类的构造器中能安全调用的只有基类的 final 方法（这也适用于可被看作是 final 的 private 方法）。
  这些方法不能被重写，因此不会产生意想不到的结果。
 ( 你可能无法永远遵循这条规范，但应该朝着它努力。)
*/
