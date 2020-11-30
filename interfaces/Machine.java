// interfaces/Machine.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.util.*;



class Bing implements Operations {
  public void execute() {
    Operations.show("Bing");
  }
}

class Crack implements Operations {
  public void execute() {
    Operations.show("Crack");
  }
}

class Twist implements Operations {
  public void execute() {
    Operations.show("Twist");
  }
}

public class Machine {
  public static void main(String[] args) {
    Operations.runOps(
      new Bing(), new Crack(), new Twist());
  }
}
/* Output:
Bing
Crack
Twist

self-note: 这是模板方法设计模式的一个版本（在“设计模式”一章中详细描述），runOps() 是一个模板方法。
runOps() 使用可变参数列表，因而我们可以传入任意多的 Operation 参数并按顺序运行它们：
*/
