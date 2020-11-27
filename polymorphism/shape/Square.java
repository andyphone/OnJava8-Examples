// polymorphism/shape/Square.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package  shape;

public class Square extends Shape {
  @Override
  public void draw() {
    System.err.println("Square.draw()");
  }
  @Override
  public void erase() {
    System.err.println("Square.erase()");
  }
}
