// collections/StackTest2.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import onjava.Stack;

public class StackTest2 {
  public static void main(String[] args) {
//    onjava.Stack<String> stack = new onjava.Stack<>();//fun1 完整指定包名 import onjava.*;
    Stack<String> stack = new Stack<>();                //fun2 完整指定包名 import onjava.Stack;


    for(String s : "My dog has fleas".split(" "))
      stack.push(s);
    while(!stack.isEmpty())
      System.err.print(stack.pop() + " ");
  }
}
/* Output:
fleas has dog My

self-note:
如果想在自己的代码中使用这个 Stack 类，当在创建其实例时，就需要完整指定包名，或者更改这个类的名称；
否则，就有可能会与 java.util 包中的 Stack 发生冲突。
*/
