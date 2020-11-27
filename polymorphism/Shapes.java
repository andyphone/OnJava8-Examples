// polymorphism/Shapes.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Polymorphism in Java

import shape.*;

public class Shapes {
  public static void main(String[] args) {
    RandomShapes gen = new RandomShapes();
    // Make polymorphic method calls:
    for(Shape shape : gen.array(9))
      shape.draw();
  }
}
/* Output:
Triangle.draw()
Triangle.draw()
Square.draw()
Triangle.draw()
Square.draw()
Triangle.draw()
Square.draw()
Triangle.draw()
Circle.draw()


self-note: Java 中除了 static 和 final 方法（private 方法也是隐式的 final）外，其他所有方法都是后期绑定。
这意味着通常情况下，我们不需要判断后期绑定是否会发生——它自动发生。

*/
