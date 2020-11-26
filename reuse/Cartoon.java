// reuse/Cartoon.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Constructor calls during inheritance

class Art {
  Art() {
    System.err.println("Art constructor");
  }
}

class Drawing extends Art {
  Drawing() {
    System.err.println("Drawing constructor");
  }
}

public class Cartoon extends Drawing {
//  public Cartoon() {
//    System.err.println("Cartoon constructor");
//  }
  public static void main(String[] args) {
    Cartoon x = new Cartoon();
  }
}
/* Output:
Art constructor
Drawing constructor
Cartoon constructor


self-note : 即使不为 Cartoon 创建构造函数，
编译器也会为你合成一个无参数构造函数，调用基类构造函数。
尝试删除 Cartoon 构造函数来查看这个。
*/
