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
*/
