// interfaces/Applicator.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.util.*;

class Processor {
  public String name() {
    return getClass().getSimpleName();
  }
  public Object process(Object input) {
    return input;
  }
}

class Upcase extends Processor {
  @Override // Covariant return:
  public String process(Object input) {
    return ((String)input).toUpperCase();
  }
}

class Downcase extends Processor {
  @Override
  public String process(Object input) {
    return ((String)input).toLowerCase();
  }
}

class Splitter extends Processor {
  @Override
  public String process(Object input) {
    // split() divides a String into pieces:
    return Arrays.toString(((String)input).split(" "));
  }
}

public class Applicator {
  public static void apply(Processor p, Object s) {
    System.err.println("Using Processor " + p.name());
    System.err.println(p.process(s));
  }
  public static void main(String[] args) {
    String s =
      "We are such stuff as dreams are made on";
    apply(new Upcase(), s);
    apply(new Downcase(), s);
    apply(new Splitter(), s);
  }
}
/* Output:
Using Processor Upcase
WE ARE SUCH STUFF AS DREAMS ARE MADE ON
Using Processor Downcase
we are such stuff as dreams are made on
Using Processor Splitter
[We, are, such, stuff, as, dreams, are, made, on]


self-note: 像本例中这样，创建一个能根据传入的参数类型从而具备不同行为的方法称为策略设计模式。
方法包含算法中不变的部分，策略包含变化的部分。
策略就是传入的对象，它包含要执行的代码。
在这里，Processor 对象是策略，main() 方法展示了三种不同的应用于 String s 上的策略。
*/
