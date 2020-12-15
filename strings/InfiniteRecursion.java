// strings/InfiniteRecursion.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Accidental recursion
// {ThrowsException}
// {VisuallyInspectOutput} Throws very long exception
import java.util.*;
import java.util.stream.*;

public class InfiniteRecursion {
  @Override
  public String toString() {
    return
      " InfiniteRecursion address: " + this + "\n";
  }
  public static void main(String[] args) {
    System.err.println( new InfiniteRecursion());//self-note: 神奇现象: 异常递归
    /**
     * 因为编译器发现一个 `String` 对象后面跟着一个 “+”，而 “+” 后面的对象不是 `String`，
     * 于是编译器试着将 `this` 转换成一个 `String`。它怎么转换呢？
     * 正是通过调用 `this` 上的 `toString()` 方法，于是就发生了递归调用。
     */


/*    Stream.generate(InfiniteRecursion::new)
      .limit(1)
      .forEach(System.out::println);*/
  }
}
