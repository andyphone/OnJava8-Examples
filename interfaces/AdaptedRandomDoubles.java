// interfaces/AdaptedRandomDoubles.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Creating an adapter with inheritance
import java.nio.*;
import java.util.*;

public class AdaptedRandomDoubles implements RandomDoubles, Readable {
  private int count;
  public AdaptedRandomDoubles(int count) {
    this.count = count;
  }
  @Override
  public int read(CharBuffer cb) {
    if(count-- == 0)
      return -1;
    String result = Double.toString(next()) + " ";
    cb.append(result);
    return result.length();
  }
  public static void main(String[] args) {
    Scanner s =
      new Scanner(new AdaptedRandomDoubles(7));
    while(s.hasNextDouble())
      System.err.print(s.nextDouble() + " ");
  }
}
/* Output:
0.7271157860730044 0.5309454508634242
0.16020656493302599 0.18847866977771732
0.5166020801268457 0.2678662084200585
0.2613610344283964
*/
/**
 * self-note:  RandomDoubles 类没有实现 Readable 接口,
 * 使用适配器模式，但这里适配器类可以实现两个接口
 * 通过关键字 interface 提供的多继承，我们可以创建一个既是 RandomDoubles，又是 Readable 的类AdaptedRandomDoubles：
 *
 *
 *
 *  类适配器模式主要应用于新需求是一个新的接口。为了适应新的需求，我们必须
 *  1.先实现此接口，2.但我们又要想复用原有的代码。此时要满足这一点，可通过继承原有的类，来复用父类的方法。
 *  综合以上的两个关键点，我们应该定义一个新的类，使其继承原有的类，同时去实现业务所需的新目标接口。
 *
 *  类适配器模式需要新定义一个适配器类，它实现了需求对应的接口，并继承现有的业务类，
 *  通过在接口方法中显式地调用父类的方法的方式，达到适应新需求同时又复用现有方法代码的目的。
 *
 *
 *
 */
