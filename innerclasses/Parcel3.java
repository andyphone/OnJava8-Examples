// innerclasses/Parcel3.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Using .new to create instances of inner classes

public class Parcel3 {
  class Contents {
    private int i = 11;
    public int value() { return i; }
  }
  class Destination {
    private String label;
    Destination(String whereTo) { label = whereTo; }
    String readLabel() { return label; }
  }
  public static void main(String[] args) {
    Parcel3 p = new Parcel3();
    //self-note:  Must use instance of outer class to create an instance of the inner class:
    //在拥有外部类对象之前是不可能创建内部类对象的。这是因为内部类对象会暗暗地连接到建它的外部类对象上。
    //但是，如果你创建的是嵌套类（静态内部类），那么它就不需要对外部类对象的引用。
    Parcel3.Contents c = p.new Contents();
    Parcel3.Destination d =
      p.new Destination("Tasmania");
  }
}
