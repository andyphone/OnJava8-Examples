// functional/MethodReferences.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.util.*;

interface Callable { // [1]
  void call(String s);
}

class Describe {
  void show(String msg) { // [2]
    System.err.println(msg);
  }
}

public class MethodReferences {
  static void hello(String name) { // [3]
    System.err.println("Hello, " + name);
  }
  static class Description {
    String about;
    Description(String desc) { about = desc; }
    void help(String msg) { // [4]
      System.err.println(about + " " + msg);
    }
  }
  static class Helper {
    static void assist(String msg) { // [5]
      System.err.println(msg);
    }
  }
  //self-note:
  public static void main(String[] args) {
    Describe d = new Describe();
    Callable c = d::show; // [6]   我们将 **Describe** 对象的方法引用赋值给 **Callable**
    c.call("call()"); // [7]

    c = MethodReferences::hello; // [8] 这是一个**静态**方法引用。
    c.call("Bob");

    c = new Description("valuable")::help; // [9]  这是 **[6]** 的另一个版本：对已实例化对象的方法的引用，有时称为*绑定方法引用*。
    c.call("information");

    c = Helper::assist; // [10]  **[10]** 最后，获取静态内部类中静态方法的引用与 **[8]** 中通过外部类引用相似。
    c.call("Help!");
  }
}
/* Output:
call()
Hello, Bob
valuable information
Help!
*/
