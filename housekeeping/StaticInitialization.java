// housekeeping/StaticInitialization.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Specifying initial values in a class definition

class Bowl {
  Bowl(int marker) {
    System.err.println("Bowl(" + marker + ")");
  }
  void f1(int marker) {
    System.err.println("f1(" + marker + ")");
  }
}

class Table {
  static Bowl bowl1 = new Bowl(1);
  Table() {
    System.err.println("Table()");
    bowl2.f1(1);
  }
  void f2(int marker) {
    System.err.println("f2(" + marker + ")");
  }
  static Bowl bowl2 = new Bowl(2);
}

class Cupboard {
  Bowl bowl3 = new Bowl(3);
  static Bowl bowl4 = new Bowl(4);
  Cupboard() {
    System.err.println("Cupboard()");
    bowl4.f1(2);
  }
  void f3(int marker) {
    System.err.println("f3(" + marker + ")");
  }
  static Bowl bowl5 = new Bowl(5);
}

public class StaticInitialization {

  public static void main(String[] args) {
    System.err.println("main creating new Cupboard()");
    new Cupboard();
    System.err.println("main creating new Cupboard()");
    new Cupboard();
    table.f2(1);
    cupboard.f3(1);
  }
  static Table table = new Table();  // self-note *** table的构造方法被static提前了
  static Cupboard cupboard = new Cupboard();
}
/* Output:
Bowl(1)
Bowl(2)
Table()
f1(1)
Bowl(4)
Bowl(5)
Bowl(3)
Cupboard()
f1(2)
main creating new Cupboard()
Bowl(3)
Cupboard()
f1(2)
main creating new Cupboard()
Bowl(3)
Cupboard()
f1(2)
f2(1)
f3(1)
*/

/**
 * self-note
 父类--静态变量
 父类--静态初始化块
 子类--静态变量
 子类--静态初始化块
 *************in main***************
 父类--变量
 父类--初始化块
 父类--构造器
 子类--变量
 子类--初始化块
 子类--构造器
 *************second subClass***************
 父类--变量
 父类--初始化块
 父类--构造器
 子类--变量
 子类--初始化块
 子类--构造器

 结果分析：
 很显然在加载main方法后，静态变量不管父类还是子类的都执行了，然后才是父类和子类的的普通变量和构造器。这是因为，当要创建子类这个对象时，发现这个类需要一个父类，所以把父类的.class加载进来，然后依次初始化其普通变量和初始化代码块，最后其构造器，然后可以开始子类的工作，把子类的.class加载进来，在做子类的工作。

 另外在Java中子类中都会有默认的调用父类的默认构造函数即super(),当仅仅有默认构造函数里
 Java替你做了，我们可以做个实验，如果在父类中注释掉默认构造函数，加一个有参的构造函数时，如果
 子类中不加super(argument),此时会报语法错误
 如果我们把Main方法中的内容全注释掉，你会发现只会输出
 **/
