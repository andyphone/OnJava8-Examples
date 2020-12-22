// generics/IterableFibonacci.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Adapt the Fibonacci class to make it Iterable
import java.util.*;

public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
  private int n;
  public IterableFibonacci(int count) { n = count; }
  @Override
  public Iterator<Integer> iterator() {
    return new Iterator<Integer>() {
      @Override
      public boolean hasNext() { return n > 0; }
      @Override
      public Integer next() {
        n--;
        return IterableFibonacci.this.get();
      }
      @Override
      public void remove() { // Not implemented
        throw new UnsupportedOperationException();
      }
    };
  }
  public static void main(String[] args) {
    for(int i : new IterableFibonacci(18))
      System.err.print(i + " ");
  }
}
/* Output:
1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597
2584
*/
//self-note: 创建一个 *适配器* (Adapter) 来实现所需的接口 [类适配器模式]
//类适配器模式需要新定义一个适配器类，它实现了需求对应的接口，并继承现有的业务类，
//通过在接口方法中显式地调用父类的方法的方式，达到适应新需求同时又复用现有方法代码的目的。
