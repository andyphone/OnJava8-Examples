// reuse/CADSystem.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Ensuring proper cleanup
// {java reuse.CADSystem}
package reuse;

class Shape {
  Shape(int i) {
    System.err.println("Shape constructor");
  }
  void dispose() {
    System.err.println("Shape dispose");
  }
}

class Circle extends Shape {
  Circle(int i) {
    super(i);
    System.err.println("Drawing Circle");
  }
  @Override
  void dispose() {
    System.err.println("Erasing Circle");
    super.dispose();
  }
}

class Triangle extends Shape {
  Triangle(int i) {
    super(i);
    System.err.println("Drawing Triangle");
  }
  @Override
  void dispose() {
    System.err.println("Erasing Triangle");
    super.dispose();
  }
}

class Line extends Shape {
  private int start, end;
  Line(int start, int end) {
    super(start);
    this.start = start;
    this.end = end;
    System.err.println(
      "Drawing Line: " + start + ", " + end);
  }
  @Override
  void dispose() {
    System.err.println(
      "Erasing Line: " + start + ", " + end);
    super.dispose();
  }
}

public class CADSystem extends Shape {
  private Circle c;
  private Triangle t;
  private Line[] lines = new Line[3];
  public CADSystem(int i) {
    super(i + 1);
    for(int j = 0; j < lines.length; j++)
      lines[j] = new Line(j, j*j);
    c = new Circle(1);
    t = new Triangle(1);
    System.err.println("Combined constructor");
  }
  @Override
  /**
   * self-note
   * 在很多情况下，清理问题不是问题；你只需要让垃圾收集器来完成这项工作。
   * 但是，当你必须执行显式清理时，就需要多做努力，更加细心，因为在垃圾收集方面没有什么可以依赖的。
   * 可能永远不会调用垃圾收集器。如果调用，它可以按照它想要的任何顺序回收对象。
   * 除了内存回收外，你不能依赖垃圾收集来做任何事情。
   * 如果希望进行清理，可以使用自己的清理方法，不要使用 finalize()。
   */
  public void dispose() {
    System.err.println("CADSystem.dispose()");
    // The order of cleanup is the reverse
    // of the order of initialization:
    // 必须注意基类和成员对象清理方法的调用顺序，以防一个子对象依赖于另一个子对象
    // 即 按"与创建的相反顺序"执行特定于类的所有清理工作。(一般来说，这要求基类元素仍然是可访问的。)
    // 然后 调用基类清理方法
    t.dispose();
    c.dispose();
    for(int i = lines.length - 1; i >= 0; i--)
      lines[i].dispose();
    super.dispose();
  }
  public static void main(String[] args) {
    CADSystem x = new CADSystem(47);
    try {
      // Code and exception handling...
    } finally {
      x.dispose();
    }
  }
}
/* Output:
Shape constructor
Shape constructor
Drawing Line: 0, 0
Shape constructor
Drawing Line: 1, 1
Shape constructor
Drawing Line: 2, 4
Shape constructor
Drawing Circle
Shape constructor
Drawing Triangle
Combined constructor
CADSystem.dispose()
Erasing Triangle
Shape dispose
Erasing Circle
Shape dispose
Erasing Line: 2, 4
Shape dispose
Erasing Line: 1, 1
Shape dispose
Erasing Line: 0, 0
Shape dispose
Shape dispose
*/
