// generics/InheritBounds.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

class HoldItem<T> {
  T item;
  HoldItem(T item) { this.item = item;System.err.println("HoldItem 构造器"); }



  T getItem() { return item; }
}

class WithColor2<T extends HasColor> extends HoldItem<T> {
  WithColor2(T item) { super(item);  System.err.println("WithColor2 构造器");}



  java.awt.Color color() { return item.getColor(); }
}

class WithColorCoord2<T extends Coord & HasColor>
extends WithColor2<T> {
  WithColorCoord2(T item) {  super(item);  System.err.println("WithColorCoord2 构造器");}



  int getX() { return item.x; }
  int getY() { return item.y; }
  int getZ() { return item.z; }
}

class Solid2<T extends Coord & HasColor & Weight> extends WithColorCoord2<T> {


  Solid2(T item) {  super(item);    System.err.println("Solid2 构造器");
  }
  int weight() { return item.weight(); }
}

public class InheritBounds {
  public static void main(String[] args) {
    Solid2<Bounded> solid2 =
      new Solid2<>(new Bounded());
    solid2.color();
    solid2.getY();
    solid2.weight();
  }
}
