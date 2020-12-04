// functional/TransformFunction.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.util.function.*;

class I {
  @Override
  public String toString() { return "I"; }
}

class O {
  @Override
  public String toString() { return "O"; }
}

public class TransformFunction {
  static Function<I,O> transform(Function<I,O> in) {
    return in.andThen(o -> {
      System.err.println(o);
      return o;
    });
  }
  public static void main(String[] args) {
    Function<I,O> f2 = transform(i -> {
      System.err.println(i);
      return new O();
    });
    O o = f2.apply(new I());
    //self-note:
    /**
     * 在这里,运行高阶函数f2,然后会运行传入的函数in,其结果再运行andThen()部分.
     */
  }
}
/* Output:
I
O
*/
