// reuse/Beetle.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// The full process of initialization

class Insect {
  private int i = 9;
  protected int j;
  Insect() {
    System.err.println("i = " + i + ", j = " + j);
    j = 39;
  }
  private static int x1 =
    printInit("static Insect.x1 initialized");
  static int printInit(String s) {
    System.err.println(s);
    return 47;
  }
}
class Insect2 {
  protected int j;

  static{
    System.err.println("基类都会被加载!!!");
  }
  static int printInit(String s) {
    System.err.println(s);
    return 47;
  }
}
public class Beetle extends Insect2 {
//  private int k = printInit("Beetle.k initialized");
//  public Beetle() {
//    System.err.println("k = " + k);
//    System.err.println("j = " + j);
//  }
//  private static int x2 =
//    printInit("static Beetle.x2 initialized");
  public static void main(String[] args) {
    System.err.println("Beetle constructor");
//    Beetle b = new Beetle();
//    self-note: 不论是否创建了基类的对象，基类Insect2都会被加载。
//    如果基类还存在自身的基类，那么基类的基类也将被加载。除此之外要用到(Insect)才会加载
  }
}
/* Output:
static Insect.x1 initialized
static Beetle.x2 initialized
Beetle constructor
i = 9, j = 0
Beetle.k initialized
k = 47
j = 39
*/
