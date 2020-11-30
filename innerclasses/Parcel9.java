// innerclasses/Parcel9.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

public class Parcel9 {
  // Argument must be final or "effectively final"
  // to use within the anonymous inner class:
  public Destination destination(final String dest) {
    return new Destination() {
      private String label = dest;
      @Override
      public String readLabel() { return label; }
    };
  }
  public static void main(String[] args) {
    Parcel9 p = new Parcel9();
    Destination d = p.destination("Tasmania");
  }
  /**
   * self-note:
   * 如果在定义一个匿名内部类时，它要使用一个外部环境（在本匿名内部类之外定义）对象，
   * 那么编译器会要求其（该对象）参数引用是 final 或者是 “effectively final”
   * （也就是说，该参数在初始化后不能被重新赋值，所以可以当作 final）的，
   * 就像你在 destination() 的参数中看到的那样。
   * 这里省略掉 final 也没问题，但通常加上 final 作为提醒比较好。
   */
}
