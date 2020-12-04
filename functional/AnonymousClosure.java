// functional/AnonymousClosure.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.util.function.*;

public class AnonymousClosure {
  //fun1
  IntSupplier makeFun(int x) {
    int i = 0;
    return () -> x + i;
  }

  //fun2 是fun1的繁写
  IntSupplier makeFun2(int x) {
    int i = 0;
    return new IntSupplier() {
      @Override
      public int getAsInt() { return x + i; }
    };
  }

  /**
   *
   * x和i是方法的局部变量, 但是匿名内部类用到了这些变量,而局部变量生命周期短于 内部类, 导致 变量 发生变化
   *
   * self-note:
   * 内部类和外部类是处于同一个级别的，内部类不会因为定义在方法中,就会随着方法的执行完毕就被销毁.
   * 这里就会产生问题：
   *    当外部类的方法结束时，局部变量就会被销毁了，但是内部类对象可能还存在(只有没有人再引用它时，才会死亡)。
   *    这里就出现了一个矛盾：内部类对象访问了一个不存在的变量。
   *
   *
   * 为了妥协, 将局部变量复制了一份作为内部类的成员变量 确保相同的生命周期;
   * 这样当局部变量死亡后，内部类仍可以访问它，实际访问的是局部变量的"copy"。
   *    如果我们在内部类中修改了成员变量，方法中的局部变量也得跟着改变，怎么解决问题呢？
   * 再次为了妥协, 变量都必须为final,都不可变.
   *
   *
   * 总而言之, java机制帮我们解决了外层方法局部变量作为内部类成员引用时生命周期的问题:复制外层方法局部变量,构造方法再把拷贝赋值给类成员变量;
   *          此时可能导致数据不同步,因此要用final修饰.
   *
   *
   * 实际上只要有内部类，就会有闭包（Java 8 只是简化了闭包操作）。
   * 在 Java 8 之前，变量 `x` 和 `i` 必须被明确声明为 `final`。在 Java 8 中，内部类的规则放宽，包括**等同 final 效果**。
   *
   *
   * 严格来说，闭包需要满足三个条件：【1】访问所在作用域；【2】函数嵌套；【3】在所在作用域外被调用
   *
   *          有些人觉得只满足条件1就可以，所以IIFE（立即调用函数表达式）是闭包；
   *          有些人觉得满足条件1和2才可以，所以被嵌套的函数才是闭包；
   *          有些人觉得3个条件都满足才可以，所以在作用域以外的地方被调用的函数才是闭包
   */

}
